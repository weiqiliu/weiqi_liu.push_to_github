package com.example.weiqiliu.materialdesign.domain;

public class Box<T extends String> {
    private T data;

    public Box(){

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setInformation(T data){
        if(data.equals("123")){
            data.length();
        }
    }
}
