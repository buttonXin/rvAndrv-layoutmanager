package com.dopool.game;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init();
    }
}
