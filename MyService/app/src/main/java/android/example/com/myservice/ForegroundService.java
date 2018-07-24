package android.example.com.myservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/*
Android中Service接口中还提供了一个称之为”前台Service“的概念。
通过Service.startForeground (int id, Notification notification)方法可以将此Service设置为前台Service。
在UI显示上，notification将是一个处于onGoing状态的通知，使得前台Service拥有更高的进程优先级，并且Service可以直接notification通信。
 */
public class ForegroundService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("ForegroundService", "onStartCommand()");
        // 在API11之后构建Notification的方式
        Notification.Builder builder = new Notification.Builder(this.getApplicationContext());

        //获取一个Notification构造器
        Intent nfIntent = new Intent(this, MainActivity.class);

        builder.setContentIntent(
                //PendingIntent来处理意图，(Pending译为“待定的”、“延迟”，PendingIntent类提供了一种创建可由其它应用程序在稍晚时间触发的Intent的机制-
                PendingIntent.getActivity(this, 0, nfIntent, 0))
                .setContentTitle("下拉列表中的Title") // 设置下拉列表里的标题
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏内的小图标
                .setContentText("要显示的内容") // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间

        Notification notification = builder.build(); // 获取构建好的Notification
        notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音

        // 参数一：唯一的通知标识；参数二：通知消息。
        startForeground(110, notification);// 开始前台服务

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        stopForeground(true);// 停止前台服务--参数：表示是否移除之前的通知
        super.onDestroy();
    }
}
