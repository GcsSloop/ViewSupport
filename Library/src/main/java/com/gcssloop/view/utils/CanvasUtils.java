package com.gcssloop.view.utils;

import android.app.VoiceInteractor;
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

    private Canvas mCanvas;

    public CanvasUtils(@NonNull Canvas canvas) {
        mCanvas = canvas;
    }

    public void drawLine(Point p1, Point p2, Paint paint) {
        mCanvas.save();
        mCanvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        mCanvas.restore();
    }

    public void drawLine(PointF p1, PointF p2, Paint paint) {
        mCanvas.save();
        mCanvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        mCanvas.restore();
    }

}
