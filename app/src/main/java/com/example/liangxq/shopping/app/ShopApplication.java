package com.example.liangxq.shopping.app;

import android.app.Application;

import com.example.httplibrary.HttpConstant;
import com.example.httplibrary.HttpGlobalConfig;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMModuleRegister;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.app
 * 文件名：ShopApplication
 * 创建者：liangxq
 * 创建时间：2020/8/1  14:12
 * 描述：TODO
 */
public class ShopApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInsance()
                .setBaseUrl("https://wanandroid.com/")
//                .setBaseUrl("http://169.254.39.119:8080/kotlin/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
        CrashReport.initCrashReport(getApplicationContext(), "f7628dd575", false);
        UMConfigure.init(this, "5f2bff32b4b08b653e91ef12", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setEncryptEnabled(true);
        // CrashReport.testJavaCrash();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

}
