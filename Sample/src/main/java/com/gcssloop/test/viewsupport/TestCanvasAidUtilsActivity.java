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
 * Last modified 2016-12-05 23:34:36
 *
 */

package com.gcssloop.test.viewsupport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gcssloop.test.base.BaseActivity;
import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasAidUtils;

public class TestCanvasAidUtilsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TestCanvasAidUtilsView(this));
    }
}

class TestCanvasAidUtilsView extends CustomView {

    public TestCanvasAidUtilsView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 平移坐标系
        canvas.translate(mViewWidth/2, mViewHeight/2);

        // 重置坐标轴长度
        CanvasAidUtils.set2DAxisLength(mViewWidth/2*0.8f, mViewHeight/2*0.8f);

        // 绘制辅助坐标系
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
    }
}