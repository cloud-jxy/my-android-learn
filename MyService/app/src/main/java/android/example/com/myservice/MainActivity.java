package android.example.com.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.stop_btn).setOnClickListener(this);
        findViewById(R.id.bind_btn).setOnClickListener(this);
        findViewById(R.id.unbind_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.start_btn) {
            startMyService();
        } else if (id == R.id.stop_btn) {
            stopMyService();
        } else if (id == R.id.bind_btn) {
            bindMyService();
        } else if (id == R.id.unbind_btn) {
            unbindMyService();
        }
    }

    private void unbindMyService() {
        unbindService(conn);
    }

    private void bindMyService() {
        Intent intent = new Intent(this, StartedService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private void startMyService() {
        Intent intent = new Intent(this, BusyService.class);
        startService(intent);
    }

    private void stopMyService() {
        Intent intent = new Intent(this, BusyService.class);
        stopService(intent);
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("ServiceConnection", "onServiceConnected run");

            MyBinder binder = (MyBinder)iBinder;
            binder.test();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("ServiceConnection", "onServiceDisconnected run");
        }
    };
}
