package android.example.com.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartBootComplete extends BroadcastReceiver {
    static final String ACTION_BOOT ="android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_BOOT)){

            Intent intent2 = new Intent(context, MainActivity.class);
            // 下面这句话必须加上才能实现开机自动运行app的界面
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }
}
