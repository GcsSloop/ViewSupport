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
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;

public class CanvasUtils {


    private CanvasUtils() {
    }

    /**
     * Draw a straight line through the points.
     */
    public static void drawLine(Point p1, Point p2, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        canvas.restore();
    }

    /**
     * Draw a straight line through the points
     */
    public static void drawLine(PointF p1, PointF p2, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        canvas.restore();
    }

}
