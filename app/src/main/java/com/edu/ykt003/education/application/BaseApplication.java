package com.edu.ykt003.education.application;

import android.app.Application;
import android.content.Context;

import com.edu.ykt003.education.util.CrashHandler;

/**
 * Application 类
 * @author YL
 * @date 2017/2/27 23:31
 */
public class BaseApplication extends Application {

    /**
     * 应用级上下文对象
     */
    private static Context mContext ;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //运行异常捕获类
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }

    public static Context getContext(){
        return mContext;
    }
}
