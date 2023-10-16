package com.assignment.alert_server.bean;

import lombok.Data;

@Data
public class Alert {
    private String alertId;
    private String serviceId;
    private String serviceName;
    private String model;
    private String alertType;
    private long alertTs;
    private String severity;
    private String teamSlack;

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getModel() {
        return model;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public long getAlertTs() {
        return alertTs;
    }

    public void setAlertTs(long alertTs) {
        this.alertTs = alertTs;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTeamSlack() {
        return teamSlack;
    }

    public void setTeamSlack(String teamSlack) {
        this.teamSlack = teamSlack;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId='" + alertId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", model='" + model + '\'' +
                ", alertType='" + alertType + '\'' +
                ", alertTs=" + alertTs +
                ", severity='" + severity + '\'' +
                ", teamSlack='" + teamSlack + '\'' +
                '}';
    }
}