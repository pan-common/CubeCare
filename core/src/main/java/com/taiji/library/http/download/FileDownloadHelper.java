package com.taiji.library.http.download;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.taiji.library.R;
import com.taiji.library.data.DataPreferences;
import com.taiji.library.data.constant.C;
import com.taiji.library.data.constant.PermissionsConstant;
import com.taiji.library.data.manager.DataManager;
import com.taiji.library.http.methods.HttpMethod;
import com.taiji.library.util.PermissionUtil;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * 作者：panho on 2017-4-17 17:16
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class FileDownloadHelper {

    public static FileDownloadHelper mInstance;

    private Context mContext;

    private String ipAddress = "";

    private String filePath = "";

    private String fileName = "";

    private TextView txtProgress;

    private OnDownloadSuccessListener mListener;

    private HDialogBuilder hDialogBuilder;

    private FileDownloadHelper(Context context){
        this.mContext = context;
        ipAddress = DataPreferences.getInstance(context).getData(C.HTTP.IP)+":"+DataPreferences.getInstance(context).getData(C.HTTP.PORT)+"/";
    }

    public static FileDownloadHelper getmInstance(Context context) {
        if(mInstance==null){
            synchronized (FileDownloadHelper.class){
                mInstance = new FileDownloadHelper(context);
            }
        }
        return mInstance;
    }

    public void start(String filePath,String fileName){
        this.fileName = fileName;
        this.filePath = filePath;
        String fileStoreDir = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator + "metl";
        String fileStoreName = fileName;
        showLoadingDialog();
        PermissionUtil.checkWriteStoragePermission((Activity) mContext);
        FileApi.getInstance("http://"+ipAddress+filePath)
                .loadFileByName(fileName, new FileCallback(fileStoreDir,fileStoreName) {

                    @Override
                    public void onSuccess(File file) {
                        super.onSuccess(file);
                        if(mListener!=null){
                            mListener.onDownloadSuccess(file);
                        }
                    }

                    @Override
                    public void progress(long progress, long total) {
                        updateProgress(progress,total);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        call.cancel();
                    }
                });
    }

    public void downloadByPath(String filePath,String fileName){
        this.filePath = filePath;
        this.fileName = fileName;
        String fileStoreDir = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator + "metl/template";
        String fileStoreName = fileName;
        showLoadingDialog();
        PermissionUtil.checkWriteStoragePermission((Activity) mContext);
        FileApi.getInstance(filePath)
                .loadFileByName(fileName,new FileCallback(fileStoreDir,fileStoreName) {

                    @Override
                    public void onSuccess(File file) {
                        super.onSuccess(file);
                        hDialogBuilder.dismiss();
                        if(mListener!=null){
                            mListener.onDownloadSuccess(file);
                        }
                    }

                    @Override
                    public void progress(long progress, long total) {
                        updateProgress(progress,total);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        call.cancel();
                    }
                });
    }

    private void showLoadingDialog(){
        txtProgress = (TextView) View.inflate(mContext, R.layout.layout_hd_dialog_custom_tv,null);
        hDialogBuilder = new HDialogBuilder(mContext);
        hDialogBuilder.setCustomView(txtProgress);
        hDialogBuilder.setCustomView(txtProgress)
                .title("下载")
                .nBtnText("取消")
                .nBtnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hDialogBuilder.dismiss();
                        FileApi.cancelLoading();
                    }
                })
                .show();
    }

    private void updateProgress(long progress, long total) {
        txtProgress.setText(String.format("正在下载:(%s/%s)",
                DataManager.getFormatSize(progress),
                DataManager.getFormatSize(total)));
    }

    public void setOnDownloadSuccessListener(OnDownloadSuccessListener listener){
        this.mListener = listener;
    }

    public interface OnDownloadSuccessListener{

        public void onDownloadSuccess(File file);

    }

}
