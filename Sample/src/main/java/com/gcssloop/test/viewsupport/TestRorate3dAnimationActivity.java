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
 * Last modify $2016-09-15 05:30:31
 */

package com.gcssloop.test.viewsupport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RadioGroup;

import com.gcssloop.view.animation.Rotate3dAnimation;
import com.gcssloop.viewsupporttest.R;

public class TestRorate3dAnimationActivity extends AppCompatActivity {
    private static final String TAG = "TestRorate3dAnimationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rorate3d_animation);

        final View view = findViewById(R.id.card);

        final int[] tempAxis = {1};
        RadioGroup group = (RadioGroup) findViewById(R.id.group);
        assert group != null;
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.axis_x: tempAxis[0] =1; break;
                    case R.id.axis_y: tempAxis[0] =2; break;
                    case R.id.axis_z: tempAxis[0] =3; break;
                }
            }
        });

        final Button start = (Button) findViewById(R.id.btn_start);
        assert start != null;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTestRotate(view, tempAxis[0]);
                Log.e(TAG, "开始旋转 - "+tempAxis[0]);
            }
        });
    }

    private void startTestRotate(View view, int axis) {
        float start = 0f;
        float end = 360f;

        // 计算中心点（这里是使用view的中心作为旋转的中心点）
        final float centerX = view.getWidth() / 2.0f;
        final float centerY = view.getHeight() / 2.0f;

        //括号内参数分别为（上下文，开始角度，结束角度，x轴中心点，y轴中心点，深度，是否扭曲）
        final Rotate3dAnimation rotation = new Rotate3dAnimation(this, start, end, centerX, centerY, 0f, true);

        rotation.setAxis(axis);                                 // 设置坐标系
        rotation.setDuration(3000);                             // 设置动画时长
        rotation.setFillAfter(true);                            // 保持旋转后效果
        rotation.setInterpolator(new LinearInterpolator());     // 设置插值器

        view.startAnimation(rotation);                          //开始动画
    }
}
