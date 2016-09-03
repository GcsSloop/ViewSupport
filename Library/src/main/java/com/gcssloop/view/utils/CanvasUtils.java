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
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.annotation.NonNull;

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
    public void drawLine(PointF p1, PointF p2, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
        canvas.restore();
    }

}
