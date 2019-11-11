package com.example.dynamicviewpager;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * @author Dante
 * 2019-11-07
 */
public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
