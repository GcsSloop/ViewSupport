package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * This is a ait tool for canvas
 * Author: GcsSloop
 * Created Date: 16/5/20
 * Copyright (C) 2016 GcsSloop.
 * GitHub: https://github.com/GcsSloop
 */
public class CanvasAidUtils {

    public CanvasAidUtils() {
    }

    public static int lineLength = 8000;

    /**
     * draw coordinate system
     *
     * @param canvas    the canvas
     * @param lineWidth coordinate system line width
     * @param lineColor coordinate system line color
     */
    public static void drawCoordinateSystem(Canvas canvas, int lineWidth, int lineColor) {

        canvas.save();

        Paint paint = new Paint();
        paint.setColor(lineColor);
        paint.setStrokeWidth(lineWidth);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawLine(0, -lineLength, 0, lineLength, paint);
        canvas.drawLine(-lineLength, 0, lineLength, 0, paint);

        canvas.restore();
    }

}
