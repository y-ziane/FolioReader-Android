package com.folioreader.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.webkit.WebView;

/**
 * Created by mahavir on 3/31/16.
 */
public class ObservableWebView extends WebView {

    private ActionMode.Callback mActionModeCallback;


    public static interface ScrollListener {
        public void onScrollChange(int percent);
    }

    private ScrollListener mScrollListener;

    public ObservableWebView(Context context) {
        super(context);
    }

    public ObservableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ObservableWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setScrollListener(ScrollListener listener) {
        mScrollListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        /*int height = (int) Math.floor(this.getContentHeight() * this.getScale());
        int webViewHeight = this.getMeasuredHeight();


        //float scrollPercent = ((float)t/(height - webViewHeight))*100.0f;
        Log.d("ObservableWebview", "Height: "+height+", WebviewHeight: "+webViewHeight+", scrollY:"+t);*/
        if (mScrollListener!=null) mScrollListener.onScrollChange(t);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public int getContentHeightVal(){
        int height = (int) Math.floor(this.getContentHeight() * this.getScale());
        return height;
    }

    public int getWebviewHeight(){
        return this.getMeasuredHeight();
    }

}
