package com.taiji.library.http.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by panho on 2016/10/19.
 */

public abstract class FileCallback implements Callback<ResponseBody>{
    /**
     * 订阅下载进度
     */
    private CompositeSubscription mSubscription = new CompositeSubscription();
    /**
     * 目标文件存储文件夹路径
     */
    private String destFileDir;
    /**
     * 目标文件储存文件名
     */
    private String destFileName;

    public FileCallback(String destFileDir,String destFileName){
        this.destFileDir = destFileDir;
        this.destFileName = destFileName;
        subscribeLoadProgress();
    }

    public void onSuccess(File file) {
        unsubscribe();
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            saveFile(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void progress(long progress,long total);

    public File saveFile(Response<ResponseBody> response) throws IOException{
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;

        try {
            is = response.body().byteStream();
            File dir = new File(destFileDir);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(dir,destFileName);
            fos = new FileOutputStream(file);
            while ((len=is.read(buf))!=-1){
                fos.write(buf,0,len);
            }
            fos.flush();
            onSuccess(file);
            return file;
        } finally {
            try {
                if(is!=null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 订阅文件下载进度
     */
    private void subscribeLoadProgress(){
        mSubscription.add(RxBus.getDefault()
        .toObservable(FileLoadEvent.class)
        .onBackpressureBuffer()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<FileLoadEvent>() {
            @Override
            public void call(FileLoadEvent fileLoadEvent) {
                progress(fileLoadEvent.getProgress(),fileLoadEvent.getTotal());
            }
        }));
    }
    /**
     * 取消订阅防止内存泄漏
     */
    private void unsubscribe(){
        if(!mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }
}
