package android.example.com.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartedService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("StartedService", "onStartCommand run");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("StartedService", "onDestroy run");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("StartedService", "onCreate run");
    }
}
