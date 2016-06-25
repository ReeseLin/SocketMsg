package com.example.lin.socketmsg.threadTask;

import com.example.lin.socketmsg.helper.Helper;

/**
 *  Creater :ReeseLin
 *  Email:172053362@qq.com
 *  Date:2016/6/25
 *  Des：发送数据的线程
 */
public class SendMsg implements Runnable {

    private String sendMsg;

    public SendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    @Override
    public void run() {
        Helper.socketWriter.println(sendMsg);
    }
}
