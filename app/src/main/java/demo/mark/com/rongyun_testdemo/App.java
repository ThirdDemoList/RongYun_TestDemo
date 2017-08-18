package demo.mark.com.rongyun_testdemo;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * 作者：mark on 2017/8/14 11:56
 * <p>应用管理主类
 * 邮箱：2285581945@qq.com
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化融云
        RongIM.init(this);
    }


}
