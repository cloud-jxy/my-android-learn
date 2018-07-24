package android.example.com.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class BusyService extends IntentService {

    /*
    必须要有这么一个无参构造函数，否则
    AndroidManifest.xml会有红色下划线提示有错
    运行时exception
     */
    public BusyService() {
        super("BusyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        /*
         * IntentService是专门用来解决Service中不能执行耗时操作这一问题的.
         * 创建一个IntentService也很简单，只要继承IntentService并覆写onHandlerIntent函数，在该函数中就可以执行耗时操作了
         */
        Log.e("BusyService", "onHandleIntent run");
    }
}
