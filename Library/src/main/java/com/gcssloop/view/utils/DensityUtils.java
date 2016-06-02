package com.gcssloop.view.utils;

import android.content.Context;

/**
 * A utils of screen density.
 * <p/>
 * it can help you convert the different unit.
 * <p/>
 * E.g: dp -> px  ps->dp sp->px px->sp
 * <p/>
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/5/24
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class DensityUtils {

    public DensityUtils() {
    }

    /**
     * convert the dp to px depend on the device density.
     *
     * @param context the context
     * @param dpValue a value of dp
     * @return the result of px
     */
    public static int dip2px(Context context, float dpValue) {
        return (int) (dpValue * getDensity(context) + 0.5f);
    }

    /**
     * convert the px to dp depend on the device density.
     *
     * @param context the context
     * @param pxValue a value of px
     * @return the result of dp
     */
    public static int px2dip(Context context, float pxValue) {
        return (int) (pxValue / getDensity(context) + 0.5f);
    }

    /**
     * convert the sp to px depend on the device scaledDensity.
     *
     * @param context the context
     * @param spValue a value of sp
     * @return the result of px
     */
    public static int sp2px(Context context, float spValue) {
        return (int) (spValue * getFontDensity(context) + 0.5);
    }

    /**
     * convert the px to sp depend on the device scaledDensity.
     *
     * @param context the context
     * @param pxValue a value of px
     * @return the result of sp
     */
    public static int px2sp(Context context, float pxValue) {
        return (int) (pxValue / getFontDensity(context) + 0.5);
    }

    /**
     * get the density of device screen.
     *
     * @param context the context
     * @return the screen density
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * get the scale density of device screen.
     * usually this value is the same as density.
     * but it can adjust by user.
     *
     * @param context the context
     * @return the screen scale density.
     */
    public static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }
}
