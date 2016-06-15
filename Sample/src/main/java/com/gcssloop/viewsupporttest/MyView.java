package com.gcssloop.viewsupporttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gcssloop.view.CustomView;

/**
 * Author: GcsSloop
 * <p>
 * Created Date: 16/6/6
 * <p>
 * Copyright (C) 2016 GcsSloop.
 * <p>
 * GitHub: https://github.com/GcsSloop
 */
public class MyView extends CustomView {

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 初始化画笔
        mDefaultTextPaint.setColor(Color.GRAY);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取View宽高与画笔并根据此绘制内容

        canvas.translate(mViewWidth / 2, mViewHeight / 2);
        canvas.drawCircle(0,0,100,mDeafultPaint);
    }
}
