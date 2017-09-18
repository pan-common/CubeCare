package com.taiji.library.ui.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.taiji.library.R;
import com.taiji.library.util.L;

/**
 * 描述：基础加载网页界面
 * 创建人： panho
 * 创建时间： 2016-11-29
 */

public abstract class WebViewActivity extends BaseActivity{

    private class WebChromeClient extends android.webkit.WebChromeClient{

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            WebViewActivity.this.setProgress(newProgress*100);
        }
    }

    private class WebViewClient extends android.webkit.WebViewClient{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            L.d(LOG,"loadUrl:"+url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

    }

    private static final String LOG = "WebViewActivity";

    private Uri mLastUrl = null;
    protected WebView mWebView;
    protected SwipeRefreshLayout webview_sr;

    public void loadUri(Uri url){
        L.d(LOG, "loadUrl: " + url);
        mLastUrl = url;
        mWebView.loadUrl(url.toString());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_webview_layout);
        webview_sr = (SwipeRefreshLayout) findViewById(R.id.webview_sr);
        mWebView = (WebView) findViewById(R.id.webview);

    }

    abstract public void onPageStarted(String url);
    abstract public void onPageFinished(String url);

    @Override
    protected void onStart() {
        super.onStart();
        if(mLastUrl!=null){
            mWebView.loadUrl(mLastUrl.toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mWebView.stopLoading();
    }

    /**
     * 设置点击返回时优先调用网页返回
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK&&mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.setVisibility(View.GONE);
    }
}
