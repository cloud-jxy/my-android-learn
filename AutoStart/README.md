## 实现

### 创建Receiver类

继承自BroadcastReceiver，实现onReceive接口——启动app

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

关键：

	intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

### 广播接受权限

	<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /> 

### 清单配置

	<!--StartBootComplete 是上面建的广播类,四大组件都要在清单配置文件中注册-->
	<!--注册开机广播地址-->
        
    <receiver android:name=".StartBootComplete">
        
		<intent-filter>
			<action android:name="android.intent.action.BOOT_COMPLETED"> </action>
			<category android:name="android.intent.category.DEFAULT" />
		</intent-filter>
	</receiver>
  

## 补充说明

### 检查手机的开机广播设置

1.类似360管家的软件，为了加快开机速度，默认是关闭掉开机广播的，只需要在设置中打开即可。

2.如果监听不到广播，可以尝试同时监听广播和sd卡。
3.同时监听广播和sd卡，在application标签中，配置以下相关信息：


	<receiver android:name=".StartBootComplete">
		<intent-filter>
        	<action android:name="android.intent.action.BOOT_COMPLETED" />
        	<category android:name="android.intent.category.HOME" />
		</intent-filter>



		<intent-filter>
    		<action android:name="android.intent.action.PACKAGE_ADDED" />
    		<action android:name="android.intent.action.PACKAGE_REMOVED" />
    		<action android:name="android.intent.action.PACKAGE_REPLACED" />

    		<data android:scheme="package" />
        </intent-filter>
    </receiver>


### category标签

Category：Category属性用于指定当前动作（Action）被执行的环境。通过addCategory()方法或在清单文件AndroidManifest.xml中设置。默认为：CATEGORY_DEFAULT。

CATEGORY_DEFAULT：Android系统中默认的执行方式，按照普通Activity的执行方式执行。

CATEGORY_HOME：设置该组件为Home Activity。

CATEGORY_PREFERENCE：设置该组件为Preference。　

CATEGORY_LAUNCHER：设置该组件为在当前应用程序启动器中优先级最高的Activity，通常为入口ACTION_MAIN配合使用。　

CATEGORY_BROWSABLE：设置该组件可以使用浏览器启动。　

CATEGORY_GADGET：设置该组件可以内嵌到另外的Activity中。

 