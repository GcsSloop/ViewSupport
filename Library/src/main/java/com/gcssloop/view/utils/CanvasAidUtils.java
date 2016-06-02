package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * This is a ait tool for canvas
 * <p/>
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/5/20
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class CanvasAidUtils {

    private static boolean isDraw = true;

    private static Paint mPaint;
    private static int LEN_X = 500;
    private static int LEN_Y = 700;

    private static int LINE_WIDTH = 5;
    private static int LINE_COLOR = Color.GRAY;

    private static int Cap_Axis_Distance = 15;
    private static int Cap_Head_Distance = 30;

    private static Point XHead, XTail, YHead, YTail;
    private static Point XCap1, XCap2, YCap1, YCap2;


    private CanvasAidUtils() {
    }

    public static boolean isDraw() {
        return isDraw;
    }

    public static void setIsDraw(boolean isDraw) {
        CanvasAidUtils.isDraw = isDraw;
    }

    /**
     * @param lenX      px
     * @param lenY      px
     * @param lineWidth px
     * @param lineColor you can use it like this -> Color.GRAY
     */
    public static void setStyle(int lenX, int lenY, int lineWidth, int lineColor) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LINE_WIDTH = lineWidth;
        LINE_COLOR = lineColor;
    }


    /**
     * draw coordinate system
     *
     * @param canvas the canvas
     */
    public static void drawCoordinateSystem(Canvas canvas) {
        if (!isDraw) {
            return;
        }

        initPaint();
        initPoint();

        canvas.save();

        CanvasUtils canvasUtils = new CanvasUtils(canvas);

        canvasUtils.drawLine(XHead, XTail, mPaint);
        canvasUtils.drawLine(XHead, XCap1, mPaint);
        canvasUtils.drawLine(XHead, XCap2, mPaint);

        canvasUtils.drawLine(YHead, YTail, mPaint);
        canvasUtils.drawLine(YHead, YCap1, mPaint);
        canvasUtils.drawLine(YHead, YCap2, mPaint);

        canvas.restore();
    }

    private static void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(LINE_COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(LINE_WIDTH);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private static void initPoint() {

        XHead = new Point(+LEN_X, 0);
        XTail = new Point(-LEN_X, 0);
        XCap1 = new Point(LEN_X - Cap_Head_Distance, +Cap_Axis_Distance);
        XCap2 = new Point(LEN_X - Cap_Head_Distance, -Cap_Axis_Distance);

        YHead = new Point(0, +LEN_Y);
        YTail = new Point(0, -LEN_Y);
        YCap1 = new Point(+Cap_Axis_Distance, LEN_Y - Cap_Head_Distance);
        YCap2 = new Point(-Cap_Axis_Distance, LEN_Y - Cap_Head_Distance);
    }
}
