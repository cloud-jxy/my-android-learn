package android.example.com.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/*
https://www.cnblogs.com/lwbqqyumidi/p/4181185.html

Bound Service的主要特性在于Service的生命周期是依附于Client的生命周期的,
当Client不存在时，Bound Service将执行onDestroy.
同时通过Service中的Binder对象可以较为方便进行Client-Service通信。

注：在四大基本组件中，需要注意的的是BroadcastReceiver不能作为Bound Service的Client.
因为BroadcastReceiver的生命周期很短，当执行完onReceive(..)回调时，BroadcastReceiver生命周期完结。
而Bound Service又与Client本身的生命周期相关，因此，Android中不允许BroadcastReceiver去bindService(..)，当有此类需求时，可以考虑通过startService(..)替代。
 */
public class BoundService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("BoundService", "onBind run");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("BoundService", "onUnbind run");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("BoundService", "onStartCommand run");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("BoundService", "onDestroy run");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("BoundService", "onCreate run");
    }
}
