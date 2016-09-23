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
 * Last modify $2016-09-14 02:44:30
 */

package com.gcssloop.view.animation;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {
    private final float mFromDegrees;
    private final float mToDegrees;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;
    private float scale = 1;

    private int mAxis = 2;  // 围绕旋转的轴,默认是y轴
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;

    /**
     * 创建一个绕y轴旋转的3D动画效果，旋转过程中具有深度调节，可以指定旋转中心。
     *
     * @param context     上下文
     * @param fromDegrees 起始时角度
     * @param toDegrees   结束时角度
     * @param centerX     旋转中心x坐标
     * @param centerY     旋转中心y坐标
     * @param depthZ      最远到达的z轴坐标
     * @param reverse     true 表示由从0到depthZ，false相反
     */
    public Rotate3dAnimation(Context context, float fromDegrees, float toDegrees,
                             float centerX, float centerY, float depthZ, boolean reverse) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mCenterX = centerX;
        mCenterY = centerY;
        mDepthZ = depthZ;
        mReverse = reverse;

        //获取手机像素比 （即dp与px的比例
        scale = context.getResources().getDisplayMetrics().density;
    }

    /**
     * 创建一个绕y轴旋转的3D动画效果，旋转过程中具有深度调节，可以指定旋转中心。
     *
     * @param context     上下文
     * @param fromDegrees 起始时角度
     * @param toDegrees   结束时角度
     * @param centerX     旋转中心x坐标
     * @param centerY     旋转中心y坐标
     * @param depthZ      最远到达的z轴坐标
     * @param reverse     true 表示由从0到depthZ，false相反
     * @param axis        围绕旋转的坐标轴
     */
    public Rotate3dAnimation(Context context, float fromDegrees, float toDegrees,
                             float centerX, float centerY, float depthZ, boolean reverse, int axis) {
        this(context, fromDegrees, toDegrees, centerX, centerY, depthZ, reverse);
        setAxis(axis);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        final Matrix matrix = t.getMatrix();

        mCamera.save();

        // 调节深度
        if (mReverse) {
            mCamera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
        } else {
            mCamera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
        }

        // 绕轴旋转
        switch (mAxis) {
            case 1:
                mCamera.rotateX(degrees);
                break;
            case 2:
                mCamera.rotateY(degrees);
                break;
            case 3:
                mCamera.rotateZ(degrees);
                break;
        }

        mCamera.getMatrix(matrix);
        mCamera.restore();

        // 修复失真
        float[] mValues = new float[9];
        matrix.getValues(mValues);          //获取数值
        mValues[6] = mValues[6] / scale;    //数值修正
        mValues[7] = mValues[7] / scale;    //数值修正
        matrix.setValues(mValues);          //重新赋值

        // 设置中心
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
    }

    /**
     * 设置围绕旋转的坐标轴
     *
     * @param axis
     */
    public void setAxis(int axis) {
        if (axis < 1 || axis > 3)
            return;
        mAxis = axis;
    }
}
