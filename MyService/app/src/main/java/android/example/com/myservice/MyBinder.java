package android.example.com.myservice;

import android.os.Binder;
import android.util.Log;

public class MyBinder extends Binder {
    public void test() {
        Log.e("MyBinder", "test run");
    }
}
