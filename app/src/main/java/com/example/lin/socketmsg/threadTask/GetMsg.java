package com.example.lin.socketmsg.threadTask;


import android.os.Handler;

import com.example.lin.socketmsg.MainActivity;
import com.example.lin.socketmsg.bean.ChatroomMessage;
import com.example.lin.socketmsg.helper.Helper;

import java.io.IOException;

/**
 *  Creater :ReeseLin
 *  Email:172053362@qq.com
 *  Date:2016/6/25
 *  Des：用来接收数据的一个线程，
 *  接收到数据后存入全局显示集合中，
 *  并且返回一个空的消息给Handler去触发页面刷新
 */
public class GetMsg implements Runnable{

    private Handler myHandler;

    public GetMsg(Handler myHandler) {
        this.myHandler=myHandler;
    }

    @Override
    public void run() {
        String line = null;
        try {
            while ((line = Helper.socketReader.readLine()) != null) {
                //分割传过来的数据，格式为ip:content
                String[] result =  line.split(":");
                ChatroomMessage cm = new ChatroomMessage(result[0]+":",result[1]);
                Helper.showData.add(cm);
                //发送Handler去触发刷新界面
                myHandler.sendEmptyMessage(MainActivity.Refresh_What);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
