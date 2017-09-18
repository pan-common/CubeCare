package com.taiji.cubecare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.taiji.library.util.T;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        T.showShort(this,"测试");
    }
}
