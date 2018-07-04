package com.shujun.bao.androidthreaddemo.threadcreation;


import android.util.Log;

/**
 *
 * description：Java多线程的创建
 * Java中线程的创建常见有三种基本形式
 * 1.继承Thread类，重写该类的run()方法。
 *
 *
 * created by baoshujun in the 2018/7/2 5:13 PM
 *
 *
 *
 */
public class ThreadCtreationOne extends Thread {
    private static final String TAG = "ThreadCtreationOne";
    private int anInt = 100;

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < anInt; i++) {
            Log.d(TAG, "run: threadName" + Thread.currentThread().getName() + " " + i);
        }
    }
}
