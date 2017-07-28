package com.namewu.androidlearningnotes.onetofivenote;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/7/28.
 *启动应用程序就会开启Activity栈，位于栈顶的activity被用户可见，每次启动一个Activity都会将该Activity
 *   的实例加入到Activity栈中
 * 启动一个Activity 的时候有四种模式，分别是：
 * Standard: 标准启动模式 如果需要启动一个activity 就会创建一个activity的实例
 * SingleTask:设置SingleTask的Activity在启动的时候，如果位于Activity栈当中。就会复用该Activity，这样的话
 *              在该实例之上的所有Activity都依次进行出栈，执行对应的onDestroy方法，直到当前需要启动的Activity位于栈顶
 *              一键退出当前的应用程序
 * SingleTop:如果启动的Activity已经位于栈顶，那么就不会重复创建一个新的Activity
 *             而是复用位于栈顶的实例对象，如果不位于栈顶仍旧会重复创建Activity的实例对象
 * SingleInstance:如果使用了SingleInstance启动模式的Activity在启动的时候会复用已经存在的Activity实例
 *              不管这个Activity实例位于哪个应用当中，都会共享已经启动的Activity的实例对象
 *              使用了singleInstance的启动模式的Activity会单独的开启一个共享栈，这个栈中只存在当前的Activity的实例对象
 *
 * 每种启动模式操作的activity都有所不同。
 */

public class OneStartModeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
