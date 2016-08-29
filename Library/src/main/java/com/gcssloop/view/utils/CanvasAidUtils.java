package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * This is a ait tool for canvas
 * <p>
 * Author: GcsSloop
 * <p>
 * Created Date: 16/5/20
 * <p>
 * Copyright (C) 2016 GcsSloop.
 * <p>
 * GitHub: https://github.com/GcsSloop
 */
public class CanvasAidUtils {

    private static boolean isDrawAid = true;

    private static Paint mPaint;
    private static int LEN_X = 500;
    private static int LEN_NX = 0;
    private static int LEN_Y = 700;
    private static int LEN_NY = 0;

    private static int LINE_WIDTH = 5;
    private static int LINE_COLOR = Color.GRAY;

    private static int Cap_Axis_Distance = 15;
    private static int Cap_Head_Distance = 30;

    private static Point XHead, XTail, YHead, YTail;
    private static Point XCap1, XCap2, YCap1, YCap2;


    private CanvasAidUtils() {
    }


    public static boolean isDrawAid() {
        return isDrawAid;
    }

    public static void setDrawAid(boolean isDraw) {
        CanvasAidUtils.isDrawAid = isDraw;
    }


    public static void setStyle(int lenX, int lenY, int lineWidth, int lineColor) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LINE_WIDTH = lineWidth;
        LINE_COLOR = lineColor;
    }

    /**
     * 设置坐标轴长度
     * @param lenX x坐标轴长度
     * @param lenY y坐标轴长度
     * @deprecated 被标记为删除, 后续版本中可能移除该方法, 请使用 {@link #setCoordinateLen(int, int, int, int)}
     */
    public static void setLen(int lenX, int lenY) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_NX = lenX;
        LEN_NY = lenY;
    }

    /**
     * 设置坐标轴长度
     * @param lenX  x正坐标轴长度.
     * @param lenNX x负坐标轴长度.
     * @param lenY  y正坐标轴长度.
     * @param lenNY y负坐标轴长度.
     */
    public static void setCoordinateLen(int lenX, int lenNX, int lenY, int lenNY){
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_NX = lenNX;
        LEN_NY = lenNY;
    }

    public static void setLineWidth(int lineWidth) {
        LINE_WIDTH = lineWidth;
    }

    public static void setLineColor(int lineColor) {
        LINE_COLOR = lineColor;
    }

    /**
     * 绘制坐标系.
     * 修复名称,标记为删除,可能在几个版本后移除该方法.
     * @param canvas 画布
     * @deprecated 被标记为删除,后续版本中可能移除该方法,请使用 {@link #drawCoordinateSpace(Canvas)}
     */
    @Deprecated
    public static void drawCoordinateSystem(Canvas canvas) {
        if (!isDrawAid) {
            return;
        }

        initPaint();
        initPoint();

        canvas.save();

        CanvasUtils.drawLine(XHead, XTail, canvas, mPaint);
        CanvasUtils.drawLine(XHead, XCap1, canvas, mPaint);
        CanvasUtils.drawLine(XHead, XCap2, canvas, mPaint);

        CanvasUtils.drawLine(YHead, YTail, canvas, mPaint);
        CanvasUtils.drawLine(YHead, YCap1, canvas, mPaint);
        CanvasUtils.drawLine(YHead, YCap2, canvas, mPaint);

        canvas.restore();
    }


    /**
     * 绘制坐标空间.
     * @param canvas 画布
     */
    public static void drawCoordinateSpace(Canvas canvas) {
        if (!isDrawAid) {
            return;
        }

        initPaint();
        initPoint();

        canvas.save();

        CanvasUtils.drawLine(XHead, XTail, canvas, mPaint);
        CanvasUtils.drawLine(XHead, XCap1, canvas, mPaint);
        CanvasUtils.drawLine(XHead, XCap2, canvas, mPaint);

        CanvasUtils.drawLine(YHead, YTail, canvas, mPaint);
        CanvasUtils.drawLine(YHead, YCap1, canvas, mPaint);
        CanvasUtils.drawLine(YHead, YCap2, canvas, mPaint);

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
        XTail = new Point(-LEN_NX, 0);
        XCap1 = new Point(LEN_X - Cap_Head_Distance, +Cap_Axis_Distance);
        XCap2 = new Point(LEN_X - Cap_Head_Distance, -Cap_Axis_Distance);

        YHead = new Point(0, +LEN_Y);
        YTail = new Point(0, -LEN_NY);
        YCap1 = new Point(+Cap_Axis_Distance, LEN_Y - Cap_Head_Distance);
        YCap2 = new Point(-Cap_Axis_Distance, LEN_Y - Cap_Head_Distance);
    }
}
