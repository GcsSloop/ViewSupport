package com.gcssloop.viewsupporttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TestMathUtils(this));
        // CanvasAidUtils.setIsDraw(false);
    }
}
