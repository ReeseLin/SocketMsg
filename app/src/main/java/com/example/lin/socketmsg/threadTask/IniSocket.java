package com.example.lin.socketmsg.threadTask;

import com.example.lin.socketmsg.helper.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *  Creater :ReeseLin
 *  Email:172053362@qq.com
 *  Date:2016/6/25
 *  Des：启动应用后初始化与服务器之间的Socket链接
 *
 *  Helper.mySocket =  new Socket("ip地址",10010);
 *  需要做修改，把ip地址设置为服务器的对应ip，
 *  并且服务器与客户端需要再同一wifi环境下
 */
public class IniSocket implements Runnable{

    @Override
    public void run() {
        //开启Socket
        try {
            //服务器的ip地址和端口号
            Helper.mySocket =  new Socket("192.168.100.114",10010);
            //读取信息
            Helper.socketReader =
                    new BufferedReader(new InputStreamReader(Helper.mySocket.getInputStream()));
            //输出信息
            Helper.socketWriter = new PrintWriter(Helper.mySocket.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
