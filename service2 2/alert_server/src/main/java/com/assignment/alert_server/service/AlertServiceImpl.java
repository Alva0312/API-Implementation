package com.assignment.alert_server.service;

import com.assignment.alert_server.bean.Alert;
import com.assignment.alert_server.mapper.AlertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertMapper alertMapper;

    @Override
    public void add(Alert alert) {
        alertMapper.add(alert);
    }

    @Override
    public List<Alert> find(String serviceId, long startTs, long endTs) {
        return alertMapper.find(serviceId, startTs, endTs);
    }
}
