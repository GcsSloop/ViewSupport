package com.gcssloop.viewsupporttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasUtils;

/**
 * Author: GcsSloop
 * <p>
 * Created Date: 16/6/3
 * <p>
 * Copyright (C) 2016 GcsSloop.
 * <p>
 * GitHub: https://github.com/GcsSloop
 */
public class TestCanvasUtils extends CustomView {
    public TestCanvasUtils(Context context) {
        super(context);

        mDeafultPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        Point p1 = new Point(100,100);
        Point p2 = new Point(500,500);

        CanvasUtils.drawLine(p1,p2, canvas, mDeafultPaint);
    }
}
