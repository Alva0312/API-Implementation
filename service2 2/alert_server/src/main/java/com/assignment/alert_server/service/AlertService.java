package com.assignment.alert_server.service;

import com.assignment.alert_server.bean.Alert;

import java.util.List;

public interface AlertService {
    void add(Alert alert);
    List<Alert> find(String serviceId, long startTs, long endTs);
}
