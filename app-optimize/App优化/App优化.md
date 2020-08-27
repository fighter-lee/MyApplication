#App优化

## 1. 启动优化

### 1.1 了解系统启动流程

1. 打开电源   引导芯片代码加载引导程序Boot Loader到RAM中去执行；
2. BootLoader把操作系统拉起来；
3. Linux 内核启动开始系统设置，找到一个init.rc文件启动初始化进程；
4. init进程初始化和启动属性服务，之后开启Zygote进程；
5. Zygote开始创建JVM并注册JNI方法，开启SystemServer；
6. 启动Binder线程沲和SystemServiceManager,并启动各种服务；
7. AMS启动Launcher；

### 1.2 application启动

1. 当我们用手点击一个图标时，就到了这个类public final class Launcher extends Activity
   执行onClick(View view)方法，会把这个应用的相关信息传入
   先获取一个intent--->startActivitySafely(v, intent, tag)--》startActivity(v, intent, tag);-->startActivity(intent);
2. startActivity(intent)会开一个APP进程
3. ActivityThread.java做为入口     用attach开启app    再加载application和activity
   thread.attach(false);---》mgr.attachApplication(mAppThread)会通过远端进程去
   回调private void handleBindApplication(AppBindData data)
   						Application app = data.info.makeApplication(创建Application对象
    						mInstrumentation.callApplicationOnCreate(app);----》 app.onCreate();

### 1.3 黑白屏问题

