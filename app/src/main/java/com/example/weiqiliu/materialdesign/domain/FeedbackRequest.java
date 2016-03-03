package com.example.weiqiliu.materialdesign.domain;
import java.io.Serializable;

public class FeedbackRequest implements Serializable {

    private String contact;
    private String content;
    private String deviceInfo;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
