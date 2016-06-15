package com.gcssloop.viewsupporttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasAidUtils;
import com.gcssloop.view.utils.CanvasUtils;
import com.gcssloop.view.utils.MathUtils;

/**
 * Author: GcsSloop
 * <p>
 * Created Date: 16/6/3
 * <p>
 * Copyright (C) 2016 GcsSloop.
 * <p>
 * GitHub: https://github.com/GcsSloop
 */
public class TestMathUtils extends CustomView{

    public TestMathUtils(Context context) {
        super(context);

        mDeafultPaint.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mViewWidth/2,mViewHeight/2);

        CanvasAidUtils.drawCoordinateSystem(canvas);

        Point p1 = new Point(0,0);
        Point p2 = new Point(100,-100);

        CanvasUtils.drawLine(p1,p2,canvas,mDeafultPaint);

        Log.i("TAG", MathUtils.getRadian(p2,p1)+"");




    }
}
