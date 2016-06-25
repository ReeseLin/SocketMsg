package com.example.lin.socketmsg.bean;

/**
 * Creater :ReeseLin
 * Email:172053362@qq.com
 * Date:2016/3/29
 * Des：聊天室信息的Bean
 */
public class ChatroomMessage {
    private String message;
    private String sendername;

    public ChatroomMessage(String sendername,String message) {
        this.message = message;
        this.sendername = sendername;
    }

    public String getMessage() {
        return message;
    }

    public String getSendername() {
        return sendername;
    }

}
