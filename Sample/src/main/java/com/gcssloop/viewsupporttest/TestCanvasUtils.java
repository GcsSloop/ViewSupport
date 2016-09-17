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
 */

package com.gcssloop.viewsupporttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasUtils;

public class TestCanvasUtils extends CustomView {
    public TestCanvasUtils(Context context) {
        super(context);

        mDeafultPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        Point p1 = new Point(100,100);
        Point p2 = new Point(500,500);

        CanvasUtils.drawLine(p1,p2, canvas, mDeafultPaint);
    }
}
