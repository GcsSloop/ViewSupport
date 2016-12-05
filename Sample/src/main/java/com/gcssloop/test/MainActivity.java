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

package com.gcssloop.test;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.gcssloop.test.adapter.CommonAdapter;
import com.gcssloop.test.adapter.ViewHolder;
import com.gcssloop.test.base.BaseActivity;
import com.gcssloop.test.date.MainMenu;
import com.gcssloop.test.utils.CrashHandler;
import com.gcssloop.viewsupporttest.R;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrashHandler.getInstance().init(this.getApplicationContext());

        ListView listView = (ListView) findViewById(R.id.main_list);

        assert listView != null;
        listView.setAdapter(new CommonAdapter<MainMenu.MenuEntity>(this, MainMenu.menu, R.layout.item_main) {
            @Override
            public void convert(int position, ViewHolder holder, MainMenu.MenuEntity bean) {
                TextView textView = holder.getView(R.id.item_main_text);
                textView.setText(bean.info);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, MainMenu.menu.get(position).goClass));
            }
        });

    }
}
