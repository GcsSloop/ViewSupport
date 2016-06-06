package com.gcssloop.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * This view have some method and field can help you custom view.
 * <p/>
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/5/18
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class CustomView extends View {

    /**
     * the context of current view
     */
    protected Context mCurrentContext;

    /**
     * the width of current view.
     */
    protected int mViewWidth;

    /**
     * the height of current view.
     */
    protected int mViewHeight;

    /**
     * default Paint.
     */
    protected Paint mDeafultPaint = new Paint();

    /**
     * default TextPaint
     */
    protected TextPaint mDefaultTextPaint = new TextPaint();


    public CustomView(Context context) {
        super(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentContext = context;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }


}
