package com.namewu.androidlearningnotes.onetofivenote;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.namewu.androidlearningnotes.wuutils.T;

/**
 * Created by Administrator on 2017/8/18.
 * BroadcastReceiver（广播接收器），属于Android四大组件之一
 在Android开发中，BroadcastReceiver的应用场景非常多
 今天，我将详细讲解关于BroadcastReceiver的一切相关知识
 *
 * 1. 定义

 广播，是一个全局的监听器，属于Android四大组件之一

 Android 广播分为两个角色：广播发送者、广播接收者
 *
 *
 * 2. 作用

 用于监听 / 接收 应用发出的广播消息，并做出响应

 应用场景
 a. 不同组件之间通信（包括应用内 / 不同应用之间）
 b. 与 Android 系统在特定情况下的通信

 如当电话呼入时、网络可用时
 c. 多线程通信
 *
 *
 * 3. 实现原理

 Android中的广播使用了设计模式中的观察者模式：基于消息的发布/订阅事件模型。

 因此，Android将广播的发送者 和 接收者 解耦，使得系统方便集成，更易扩展
 模型中有3个角色：

 消息订阅者（广播接收者）
 消息发布者（广播发布者）
 消息中心（AMS，即Activity Manager Service）

 示意图
 原理描述：
 广播接收者 通过 Binder机制在 AMS 注册
 广播发送者 通过 Binder 机制向 AMS 发送广播
 AMS 根据 广播发送者 要求，在已注册列表中，寻找合适的广播接收者
 寻找依据：IntentFilter / Permission
 AMS将广播发送到合适的广播接收者相应的消息循环队列中；
 广播接收者通过 消息循环 拿到此广播，并回调 onReceive()
 特别注意：广播发送者 和 广播接收者的执行 是 异步 的，发出去的广播不会关心有无接收者接收，也不确定接收者到底是何时才能接收到；

 链接：http://www.jianshu.com/p/ca3d87a4cdf3
 來源：简书
 *
 *
 * 4.2 广播接收器注册

 注册的方式分为两种：静态注册、动态注册
 *
 *
 */

public class FourNoteBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        T.showShot(context,"收到广播");
    }
}
