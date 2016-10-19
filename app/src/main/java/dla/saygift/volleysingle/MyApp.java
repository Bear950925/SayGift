package dla.saygift.volleysingle;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/20.
 * 注意!!!写完Application之后, 一定要注册!!!
 */
public class MyApp extends Application {


    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }
}
