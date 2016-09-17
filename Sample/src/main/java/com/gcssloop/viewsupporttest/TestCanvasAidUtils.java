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
import android.util.AttributeSet;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasAidUtils;

public class TestCanvasAidUtils extends CustomView {

    public TestCanvasAidUtils(Context context) {
        super(context);
    }

    public TestCanvasAidUtils(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestCanvasAidUtils(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //CanvasAidUtils.setStyle(200,200,3, Color.RED);

        canvas.translate(mViewWidth / 2, mViewHeight / 2);

        //CanvasAidUtils.set3DAxisLength(800,1000,600);

        //CanvasAidUtils.drawCoordinateSystem(canvas);

        CanvasAidUtils.draw2DCoordinateSpace(canvas);
    }
}
