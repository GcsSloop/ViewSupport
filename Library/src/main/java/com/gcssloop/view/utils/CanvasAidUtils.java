/*
 * Copyright (c) 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * GitHub :  https://github.com/GcsSloop
 * Weibo  :  http://weibo,com/GcsSloop
 * Blog     :  http://www.gcssloop.com
 *
 * Last modify $2016-09-03 23:07:52
 */

package com.gcssloop.view.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class CanvasAidUtils {

    private static boolean isDrawAid = true;

    private static Paint mPaint;
    private static int LEN_X = 500;
    private static int LEN_NX = 0;
    private static int LEN_Y = 700;
    private static int LEN_NY = 0;
    private static int LEN_Z = 400;
    private static int LEN_NZ = 0;

    private static int LINE_WIDTH = 5;
    private static int LINE_COLOR = Color.GRAY;

    private static int Cap_Axis_Distance = 15;
    private static int Cap_Head_Distance = 30;

    private static Point XHead, XTail, YHead, YTail, ZHead, ZTail;
    private static Point XCap1, XCap2, YCap1, YCap2, ZCap1, ZCap2;


    private CanvasAidUtils() {
    }


    public static boolean isDrawAid() {
        return isDrawAid;
    }

    public static void setDrawAid(boolean isDraw) {
        CanvasAidUtils.isDrawAid = isDraw;
    }


    /**
     * 标注为废弃
     *
     * @param lenX      x坐标轴长度
     * @param lenY      y坐标轴长度
     * @param lineWidth 坐标轴宽度
     * @param lineColor 坐标轴颜色
     * @deprecated 标注为废弃, 后续版本中可能移除该方法, 请使用 {@link #setCoordinateLen(int, int, int, int)}. {@link #setLineWidth(int)} 和 {@link #setLineColor(int)} 来代替.
     */
    @Deprecated
    public static void setStyle(int lenX, int lenY, int lineWidth, int lineColor) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_NX = lenX;
        LEN_NY = lenY;
        LINE_WIDTH = lineWidth;
        LINE_COLOR = lineColor;
    }

    /**
     * 设置坐标轴长度
     *
     * @param lenX x坐标轴长度
     * @param lenY y坐标轴长度
     * @deprecated 被标记为删除, 后续版本中可能移除该方法, 请使用 {@link #setCoordinateLen(int, int, int, int)}代替
     */
    public static void setLen(int lenX, int lenY) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_NX = lenX;
        LEN_NY = lenY;
    }

    /**
     * 设置坐标轴长度
     *
     * @param lenX  x正坐标轴长度.
     * @param lenNX x负坐标轴长度.
     * @param lenY  y正坐标轴长度.
     * @param lenNY y负坐标轴长度.
     */
    public static void setCoordinateLen(int lenX, int lenNX, int lenY, int lenNY) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_NX = lenNX;
        LEN_NY = lenNY;
    }

    /**
     * 设置3D坐标轴长度
     *
     * @param lenX  x正坐标轴长度.
     * @param lenNX x负坐标轴长度.
     * @param lenY  y正坐标轴长度.
     * @param lenNY y负坐标轴长度.
     * @param lenZ  z正坐标轴长度.
     * @param lenNZ z负坐标轴长度.
     */
    public static void set3DCoordinateLen(int lenX, int lenNX, int lenY, int lenNY, int lenZ, int lenNZ) {
        LEN_X = lenX;
        LEN_Y = lenY;
        LEN_Z = lenZ;
        LEN_NX = lenNX;
        LEN_NY = lenNY;
        LEN_NZ = lenNZ;
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
     *
     * @param canvas 画布
     * @deprecated 被标记为删除, 后续版本中可能移除该方法, 请使用 {@link #drawCoordinateSpace(Canvas)}代替
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
     *
     * @param canvas 画布
     */
    public static void drawCoordinateSpace(Canvas canvas) {

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
     * 绘制3D坐标空间
     *
     * @param canvas 画布
     */
    public static void draw3DCoordinateSpace(Canvas canvas) {

        drawCoordinateSpace(canvas);

        canvas.save();

        CanvasUtils.drawLine(ZHead, ZTail, canvas, mPaint);
        CanvasUtils.drawLine(ZHead, ZCap1, canvas, mPaint);
        CanvasUtils.drawLine(ZHead, ZCap2, canvas, mPaint);

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

        int zl = convert_3D_to_2D(LEN_Z);
        int nzl = convert_3D_to_2D(LEN_NZ);
        int CAD = convert_3D_to_2D(Cap_Axis_Distance);
        int CHD = convert_3D_to_2D(Cap_Head_Distance);
        ZHead = new Point(-zl, zl);
        ZTail = new Point(nzl, -nzl);
        ZCap1 = new Point(ZHead.x + CHD - CAD, ZHead.y - CHD - CAD);
        ZCap2 = new Point(ZHead.x + CHD + CAD, ZHead.y - CHD + CAD);
    }

    private static int convert_3D_to_2D(int l) {
        return l * 3 / 4;
    }
}
