## 运行时Service、绑定Service

定Service，生命周期随绑定对象onCreate、onDestory

## 前台、普通Service

前台Service的系统优先级更高、不易被回收；
前台Service会一直有一个正在运行的图标在系统的状态栏显示，下拉状态栏后可以看到更加详细的信息，非常类似于通知的效果。


## 其他

### IntentService

建议耗时的Service，继承。Override onHandleIntent，处理耗时工作。
