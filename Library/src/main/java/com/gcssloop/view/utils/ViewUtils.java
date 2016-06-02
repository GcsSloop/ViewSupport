package com.gcssloop.view.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Utils for view.
 * <p/>
 * Author: GcsSloop
 * <p/>
 * Created Date: 16/5/19
 * <p/>
 * Copyright (C) 2016 GcsSloop.
 * <p/>
 * GitHub: https://github.com/GcsSloop
 */
public class ViewUtils {

    public ViewUtils() {
    }

    /*The method about measure view****************************************************************/

    /**
     * measure view
     * if you want get view size before the view measured, you should call this method.
     * E.g you want gei the view size on constructor method
     * <p/>
     * The width and height is a value or type, it can used like this.
     * E.g： measureView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
     *
     * @param view   The view that will be measured
     * @param width  the default width
     * @param height the default height
     */
    public static void measureView(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(width, height);
        }
        int mWidth = ViewGroup.getChildMeasureSpec(0, 0, params.width);

        int mHeight;
        int tempHeight = params.height;
        if (tempHeight > 0) {
            mHeight = View.MeasureSpec.makeMeasureSpec(tempHeight, View.MeasureSpec.EXACTLY);
        } else {
            mHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        view.measure(mWidth, mHeight);
    }

    /*The method about view margin*****************************************************************/

    /**
     * set margin left
     *
     * @param view the view
     * @param left value of margin left
     */
    public static void setMarginLeft(View view, int left) {
        setMargins(view, left, 0, 0, 0);
    }

    /**
     * set margin top
     *
     * @param view the view
     * @param top  value of margin top
     */
    public static void setMarginTop(View view, int top) {
        setMargins(view, 0, top, 0, 0);
    }

    /**
     * set margin right
     *
     * @param view  the view
     * @param right value of margin right
     */
    public static void setMarginRight(View view, int right) {
        setMargins(view, 0, 0, right, 0);
    }

    /**
     * set margin bottom
     *
     * @param view   the view
     * @param bottom value of margin bottom
     */
    public static void setMarginBottom(View view, int bottom) {
        setMargins(view, 0, 0, 0, bottom);
    }

    /**
     * set view margin
     *
     * @param view   the view
     * @param left   value of margin left
     * @param top    value of margin top
     * @param right  value of margin right
     * @param bottom value of margin bottom
     */
    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();       //请求重绘
        }
    }

}
