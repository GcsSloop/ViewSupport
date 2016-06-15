package com.gcssloop.viewsupporttest;

import android.content.Context;
import android.graphics.Canvas;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasAidUtils;

/**
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/6/2
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class TestCanvasAidUtils extends CustomView {
    public TestCanvasAidUtils(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //CanvasAidUtils.setStyle(200,200,3, Color.RED);

        canvas.translate(mViewWidth / 2, mViewHeight / 2);


        CanvasAidUtils.drawCoordinateSystem(canvas);


    }
}
