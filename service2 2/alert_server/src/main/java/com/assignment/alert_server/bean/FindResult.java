package com.assignment.alert_server.bean;

import java.util.List;

public class FindResult {

    private String serviceId;
    private String serviceName;
    private List<Alert> alerts;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
        for (Alert alert : alerts) {
            alert.setServiceId(null);
            alert.setServiceName(null);
        }
    }
}
