package com.assignment.alert_server.bean;

import com.google.gson.annotations.SerializedName;

public class MessageGet {
    @SerializedName("success")
    boolean success;
    @SerializedName("alert_id")
    String alertId;
    @SerializedName("error")
    String error;

    public MessageGet(boolean success, String alertId, String error) {
        this.success = success;
        this.alertId = alertId;
        this.error = error;
    }
}
