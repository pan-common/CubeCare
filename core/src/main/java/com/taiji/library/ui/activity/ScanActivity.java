package com.taiji.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.taiji.library.R;
import com.taiji.library.util.T;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-28
 */

public abstract class ScanActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener{

    private static final int REQUEST_CODE = 1;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId()==R.id.action_scan){
            Intent intent = new Intent(this, CaptureActivity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE:
                //扫码
                if(null!=data){
                    Bundle bundle = data.getExtras();
                    if(bundle==null){
                        return;
                    }
                    if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        onScanResult(result);
                    }else if(bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED){
                        T.showShort(this,"解析失败");
                    }
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scan,menu);
        return true;
    }

    /**
     * 扫描结束获取扫描结果
     * @param result
     */
    protected abstract void onScanResult(String result);
}
