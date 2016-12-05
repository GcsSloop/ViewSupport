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
 * Last modified 2016-12-04 03:39:58
 *
 */

package com.gcssloop.test.viewsupport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gcssloop.test.base.BaseActivity;
import com.gcssloop.view.helper.ApiHelper;
import com.gcssloop.viewsupporttest.R;

public class TestApiHelperActivity extends BaseActivity{
    private static final String TAG = "TestApiHelper";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_logcat);

        Class testClass = com.gcssloop.test.viewsupport.MyClass.class;

        Log.i(TAG, "-----------------------");

        // 测试某个类是否包含该字段
        Log.i(TAG, "hasField - (T): "+ApiHelper.hasField(testClass, "mSloop"));
        Log.i(TAG, "hasField - (F): "+ApiHelper.hasField(testClass, "mField"));

        Log.i(TAG, "-----------------------");

        // 测试某个类是否包含该方法
        Log.i(TAG, "hasMethod - (T): "+ApiHelper.hasMethod("com.gcssloop.test.viewsupport.MyClass", "MyMethod"));
        Log.i(TAG, "hasMethod - (T): "+ApiHelper.hasMethod(testClass, "MyMethod"));
        Log.i(TAG, "hasMethod - (T): "+ApiHelper.hasMethod(testClass, "MyMethod", String.class));
        Log.i(TAG, "hasMethod - (F): "+ApiHelper.hasMethod(testClass, "MyMethod", int.class));

    }
}

/**
 * 一个被测试的类
 */
class MyClass {
    int mSloop = 8;


    int MyMethod(){
        return 0;
    }

    int MyMethod(String haha){
        return 0;
    }
}

