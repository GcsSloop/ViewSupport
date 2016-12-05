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
 * Last modified 2016-12-05 18:44:07
 *
 */

package com.gcssloop.test.viewsupport;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.gcssloop.test.base.BaseActivity;
import com.gcssloop.view.helper.MotionEventHelper;
import com.gcssloop.viewsupporttest.R;

public class TestMorionEventHelperActivity extends BaseActivity {
    private static final String TAG = "TestMorionEventHelper";
    Matrix mMatrix;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_logcat);
        TextView text = (TextView) findViewById(R.id.custom_view_text);
        text.append("\n在屏幕上触摸，查看坐标变化。\nx，y坐标均增加100");

        mMatrix = new Matrix();
        mMatrix.postTranslate(100,100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "转换前 > "+event.getX()+" : "+event.getY());
        MotionEvent e = MotionEventHelper.transformEvent(event, mMatrix);
        Log.i(TAG, "转换后 > "+e.getX()+" : "+e.getY());
        Log.i(TAG, "-------------------------");
        return true;
    }
}
