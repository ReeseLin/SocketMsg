package com.example.lin.socketmsg;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lin.socketmsg.adapter.ChatMessageAdapter;
import com.example.lin.socketmsg.bean.ChatroomMessage;
import com.example.lin.socketmsg.helper.Helper;
import com.example.lin.socketmsg.threadTask.SendMsg;
import com.example.lin.socketmsg.threadTask.GetMsg;
import com.example.lin.socketmsg.threadTask.IniSocket;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ListView showMsgListView;
    private EditText contentEditText;
    private Button commitButton;

    //显示相关
    private List<ChatroomMessage> showData = Helper.showData;
    private ChatMessageAdapter chatMessageAdapter;

    //handler相关
    public static final int Refresh_What =1 ;
    private MyHandler myHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMsgListView = (ListView) findViewById(R.id.showMsgListView);
        contentEditText = (EditText) findViewById(R.id.contentEditText);
        commitButton = (Button) findViewById(R.id.commitButton);

        commitButton.setOnClickListener(this);

        chatMessageAdapter = new ChatMessageAdapter(this, showData, R.layout.chatmessage_item);
        showMsgListView.setAdapter(chatMessageAdapter);
        chatMessageAdapter.refresh(showData);

        myHandler=new MyHandler();

        //初始化Socket
        new Thread(new IniSocket()).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //开启获取数据的线程
        new Thread(new GetMsg(myHandler)).start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commitButton:
                sendMsgToServer();
                break;
        }
    }

    /**
     * 当点击发送按钮后，提交数据到服务器上
     */
    private void sendMsgToServer() {
        String sendMsg = contentEditText.getText().toString();
        new Thread(new SendMsg(sendMsg)).start();
        contentEditText.setText("");
    }

    /**
     * 本页面的Handler，用于刷新界面
     */
    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MainActivity.Refresh_What:
                    //刷新
                    chatMessageAdapter.refresh(showData);
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
