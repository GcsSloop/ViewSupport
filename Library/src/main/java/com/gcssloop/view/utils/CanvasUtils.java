package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.annotation.NonNull;

/**
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/6/2
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class CanvasUtils {


    private CanvasUtils() {
    }

    /**
     * draw a line by tow point
     *
     * @param p1    point
     * @param p2    point
     * @param paint paint
     */
    public static void drawLine(Point p1, Point p2, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        canvas.restore();
    }

    /**
     * draw a line by tow point
     *
     * @param p1    point
     * @param p2    point
     * @param paint paint
     */
    public void drawLine(PointF p1, PointF p2, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        canvas.restore();
    }

}
