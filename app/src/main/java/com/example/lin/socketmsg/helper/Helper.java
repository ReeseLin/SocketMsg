package com.example.lin.socketmsg.helper;

import com.example.lin.socketmsg.bean.ChatroomMessage;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *  Creater :ReeseLin
 *  Email:172053362@qq.com
 *  Date:2016/6/25
 *  Des：帮助类
 *  mySocket：存放与服务器建立连接的Socket
 *  socketReader:输入流
 *  socketWriter：输出流
 *  showData：页面显示数据
 */
public class Helper {

    public static Socket mySocket;
    public static BufferedReader socketReader;
    public static PrintWriter socketWriter;
    public static final List<ChatroomMessage> showData = new ArrayList<ChatroomMessage>();
}
