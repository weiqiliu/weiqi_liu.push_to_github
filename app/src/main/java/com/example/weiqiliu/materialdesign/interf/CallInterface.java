package com.example.weiqiliu.materialdesign.interf;

public class CallInterface {

    public CallInterface() {
    }

    public void getCallback(){
        Icallback icallback=new Icallback() {
            @Override
            public void run() {

            }
        };
        icallback.run();
    }
}
