package com.mml.studyapp.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

/**
 * 作者： MLing
 * 邮箱：mamenglingkl1314@163.com
 * 创建时间 ：2017/6/14 15:11
 * $DESE$
 */
public class BaseApplication extends MultiDexApplication {
    private static BaseApplication application;
    private static Context mContext;
    public static final String TAG = Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = getApplicationContext();
        Log.d(TAG, "Application is onCreated!");
        Log.e(TAG, "*****UfoSDK.init(this)*****");
    }

    /**
     * 分割 Dex 支持
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {

        return mContext;
    }
}
