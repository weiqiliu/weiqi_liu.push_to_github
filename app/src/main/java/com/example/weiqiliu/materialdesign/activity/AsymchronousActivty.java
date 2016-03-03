package com.example.weiqiliu.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weiqiliu.materialdesign.MainActivity;
import com.example.weiqiliu.materialdesign.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

public class AsymchronousActivty extends Activity implements Runnable{
    private static final int DOWNLOAD_IMG = 1;
    private TextView textview;
    private Button button1;
    private Button button2;
    private Button button3;
    private int i;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asymbronous);
        initView();
    }

    private void initView() {
        i = 0;
        textview = (TextView) findViewById(R.id.txt_asymchronous);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.post(runnable);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread background = new Thread(new Runnable() {
                    public void run() {
                        try {
                            for (int i = 0; i < 20; i++) {
                                Thread.sleep(1000);
                        /* 步骤2.1：发送Message到Message qeue中，参数中的obtainMessage()是用于给出一个新Message，本例无参数，对应的在handler在队列中收到这条消息时，则通过handleMessage()进行处理*/
                                Message message = Message.obtain();
                                message.arg1 = 250;
                                message.what = DOWNLOAD_IMG;
                                handler2.sendMessage(message);
                            }
                        } catch (Throwable t) {
                            //jest end the thread
                        }
                    }

                });

                        /*步骤3：启动线程*/
                background.start();
            }
        });

        
        Observable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).map(new Func1<Long, Object>() {
            @Override
            public Object call(Long aLong) {
                startActivity(new Intent(AsymchronousActivty.this, MainActivity.class));
                finish();
                return null;
            }
        }).subscribe();
        
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textview.setText(String.valueOf(i++));
            handler.postDelayed(runnable, 1000);
            //runOnUiThread();
        }
    };

    //会造成内存泄露。非静态的内部类和匿名内部类都会隐式地持有其外部类的引用。静态的内部类不会持有外部类的引用
    private Handler handler2 = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == DOWNLOAD_IMG) {
                i++;
                textview.setText("变中文" + i);
            } else {
                textview.setText("wancheng" + i);
            }
        }
    };

    @Override
    public void run() {

    }
}
