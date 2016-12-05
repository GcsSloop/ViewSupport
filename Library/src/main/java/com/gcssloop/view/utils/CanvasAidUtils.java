/*
 * Copyright 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2016-12-03 22:55:55
 *
 */

package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

public class CanvasAidUtils {

    // field for 2D and 3D
    private static boolean isDrawAid = true;
    private static Paint mPaint;
    private static int mLineWidth = 5;
    private static int mLineColor = Color.GRAY;

    private static int Cap_Axis_Distance = 15;
    private static int Cap_Head_Distance = 30;


    // 2D
    private static float XAxisPosLen_2D = 500;   // X axis positive length
    private static float XAxisNegLen_2D = 0;     // X axis negative length
    private static float YAxisPosLen_2D = 700;   // Y axis positive length
    private static float YAxisNegLen_2D = 0;     // Y axis negative length

    private static PointF XHead_2D, XTail_2D, YHead_2D, YTail_2D;
    private static PointF XCap1_2D, XCap2_2D, YCap1_2D, YCap2_2D;


    // 3D
    private static float XAxisPosLen_3D = 400;   // X axis positive length
    private static float XAxisNegLen_3D = 400;   // X axis negative length
    private static float YAxisPosLen_3D = 500;   // Y axis positive length
    private static float YAxisNegLen_3D = 500;   // Y axis negative length
    private static float ZAxisPosLen_3D = 300;   // Z axis positive length
    private static float ZAxisNegLen_3D = 400;   // Z axis negative length

    private static PointF XHead_3D, XTail_3D, YHead_3D, YTail_3D, ZHead_3D, ZTail_3D;
    private static PointF XCap1_3D, XCap2_3D, YCap1_3D, YCap2_3D, ZCap1_3D, ZCap2_3D;


    private CanvasAidUtils() {
    }


    /**
     * draw 2D Coordinate Space.
     *
     * @param canvas Canvas
     */
    public static void draw2DCoordinateSpace(Canvas canvas) {
        if (!isDrawAid) return;

        initPaint();
        init2DPoint();

        canvas.save();

        CanvasUtils.drawLine(XHead_2D, XTail_2D, canvas, mPaint);
        CanvasUtils.drawLine(XHead_2D, XCap1_2D, canvas, mPaint);
        CanvasUtils.drawLine(XHead_2D, XCap2_2D, canvas, mPaint);

        CanvasUtils.drawLine(YHead_2D, YTail_2D, canvas, mPaint);
        CanvasUtils.drawLine(YHead_2D, YCap1_2D, canvas, mPaint);
        CanvasUtils.drawLine(YHead_2D, YCap2_2D, canvas, mPaint);

        canvas.restore();
    }

    /**
     * draw 3D Coordinate Space
     *
     * @param canvas Canvas
     */
    public static void draw3DCoordinateSpace(Canvas canvas) {
        if (!isDrawAid) return;

        initPaint();
        init3DPoint();

        canvas.save();

        CanvasUtils.drawLine(XHead_3D, XTail_3D, canvas, mPaint);
        CanvasUtils.drawLine(XHead_3D, XCap1_3D, canvas, mPaint);
        CanvasUtils.drawLine(XHead_3D, XCap2_3D, canvas, mPaint);

        CanvasUtils.drawLine(YHead_3D, YTail_3D, canvas, mPaint);
        CanvasUtils.drawLine(YHead_3D, YCap1_3D, canvas, mPaint);
        CanvasUtils.drawLine(YHead_3D, YCap2_3D, canvas, mPaint);

        CanvasUtils.drawLine(ZHead_3D, ZTail_3D, canvas, mPaint);
        CanvasUtils.drawLine(ZHead_3D, ZCap1_3D, canvas, mPaint);
        CanvasUtils.drawLine(ZHead_3D, ZCap2_3D, canvas, mPaint);

        canvas.restore();
    }

    private static void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mLineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mLineWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private static void init2DPoint() {

        XHead_2D = new PointF(+XAxisPosLen_2D, 0);
        XTail_2D = new PointF(-XAxisNegLen_2D, 0);
        XCap1_2D = new PointF(XAxisPosLen_2D - Cap_Head_Distance, +Cap_Axis_Distance);
        XCap2_2D = new PointF(XAxisPosLen_2D - Cap_Head_Distance, -Cap_Axis_Distance);

        YHead_2D = new PointF(0, +YAxisPosLen_2D);
        YTail_2D = new PointF(0, -YAxisNegLen_2D);
        YCap1_2D = new PointF(+Cap_Axis_Distance, YAxisPosLen_2D - Cap_Head_Distance);
        YCap2_2D = new PointF(-Cap_Axis_Distance, YAxisPosLen_2D - Cap_Head_Distance);
    }

    private static void init3DPoint() {

        XHead_3D = new PointF(+XAxisPosLen_3D, 0);
        XTail_3D = new PointF(-XAxisNegLen_3D, 0);
        XCap1_3D = new PointF(XAxisPosLen_3D - Cap_Head_Distance, +Cap_Axis_Distance);
        XCap2_3D = new PointF(XAxisPosLen_3D - Cap_Head_Distance, -Cap_Axis_Distance);

        YHead_3D = new PointF(0, -YAxisPosLen_3D);
        YTail_3D = new PointF(0, +YAxisNegLen_3D);
        YCap1_3D = new PointF(+Cap_Axis_Distance, -YAxisPosLen_3D + Cap_Head_Distance);
        YCap2_3D = new PointF(-Cap_Axis_Distance, -YAxisPosLen_3D + Cap_Head_Distance);

        float zl = convert_3D_to_2D(ZAxisPosLen_3D);
        float nzl = convert_3D_to_2D(ZAxisNegLen_3D);
        float CAD = convert_3D_to_2D(Cap_Axis_Distance);
        float CHD = convert_3D_to_2D(Cap_Head_Distance);
        ZHead_3D = new PointF(zl, -zl);
        ZTail_3D = new PointF(-nzl, nzl);
        ZCap1_3D = new PointF(ZHead_3D.x - CHD - CAD, ZHead_3D.y + CHD - CAD);
        ZCap2_3D = new PointF(ZHead_3D.x - CHD + CAD, ZHead_3D.y + CHD + CAD);
    }

    private static float convert_3D_to_2D(float l) {
        return l * 3 / 4;
    }

    public static boolean isDrawAid() {
        return isDrawAid;
    }

    public static void setDrawAid(boolean isDraw) {
        CanvasAidUtils.isDrawAid = isDraw;
    }


    /**
     * set 2D axis length
     *
     * @param lenX x axis length
     * @param lenY y axis length
     */
    public static void set2DAxisLength(float lenX, float lenY) {
        XAxisPosLen_2D = XAxisNegLen_2D = lenX;
        YAxisPosLen_2D = YAxisNegLen_2D = lenY;
    }

    /**
     * set 2D axis length
     *
     * @param lenPX x axis positive length
     * @param lenNX x axis negative length
     * @param lenPY y axis positive length
     * @param lenNY y axis negative length
     */
    public static void set2DAxisLength(float lenPX, float lenNX, float lenPY, float lenNY) {
        XAxisPosLen_2D = lenPX;
        YAxisPosLen_2D = lenPY;
        XAxisNegLen_2D = lenNX;
        YAxisNegLen_2D = lenNY;
    }

    /**
     * set 3D axis length
     *
     * @param lenX x axis length
     * @param lenY y axis length
     * @param lenZ z axis length
     */
    public static void set3DAxisLength(float lenX, float lenY, float lenZ) {
        XAxisPosLen_3D = XAxisNegLen_3D = lenX;
        YAxisPosLen_3D = YAxisNegLen_3D = lenY;
        ZAxisPosLen_3D = ZAxisNegLen_3D = lenZ;
    }

    /**
     * set 3D axis length
     *
     * @param lenPX x axis positive length
     * @param lenNX x axis negative length
     * @param lenPY y axis positive length
     * @param lenNY y axis negative length
     * @param lenPZ z axis positive length
     * @param lenNZ z axis negative length
     */
    public static void set3DAxisLength(float lenPX, float lenNX, float lenPY, float lenNY, float lenPZ, float lenNZ) {
        XAxisPosLen_3D = lenPX;
        YAxisPosLen_3D = lenPY;
        ZAxisPosLen_3D = lenPZ;
        XAxisNegLen_3D = lenNX;
        YAxisNegLen_3D = lenNY;
        ZAxisNegLen_3D = lenNZ;
    }

    /**
     * set axis line width
     *
     * @param width width
     */
    public static void setLineWidth(int width) {
        CanvasAidUtils.mLineWidth = width;
    }

    /**
     * set axis line color
     *
     * @param color
     */
    public static void setLineColor(int color) {
        CanvasAidUtils.mLineColor = color;
    }
}
