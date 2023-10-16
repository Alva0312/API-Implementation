package com.assignment.alert_server.bean;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("alert_id")
    String alertId;
    @SerializedName("error")
    String error;

    public Message(String alertId, String error) {
        this.alertId = alertId;
        this.error = error;
    }
}
