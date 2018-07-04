package com.shujun.bao.androidthreaddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shujun.bao.androidthreaddemo.threadcreation.ThreadCtreationOne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d(TAG, "run: threadName" + Thread.currentThread().getName() + " " + i);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadCtreationOne threadCtreationOne = new ThreadCtreationOne();
                threadCtreationOne.start();
            }
        }).start();

    }
}
