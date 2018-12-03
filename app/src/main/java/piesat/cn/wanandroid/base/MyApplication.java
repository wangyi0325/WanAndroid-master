package piesat.cn.wanandroid.base;

import android.app.Application;

import piesat.cn.wanandroid.util.CrashHandler2;
import piesat.cn.wanandroid.util.LogcatHelper;


/**
 * application
 *
 * @packageName:  piesat.cn.wanandroid.base
 * @fileName: MyApplication
 * @date: 2018/7/19  15:22
 * @author: wangyi
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        // 初始化 log 保存本地工具类
        LogcatHelper.getInstance(this).start();
        // 初始化 抓取 异常信息
        CrashHandler2.getInstance().init(this);
    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

}
