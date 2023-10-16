package com.assignment.alert_server.controller;

import com.assignment.alert_server.bean.Alert;
import com.assignment.alert_server.bean.FindResult;
import com.assignment.alert_server.bean.Message;
import com.assignment.alert_server.bean.MessageGet;
import com.assignment.alert_server.service.AlertService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String handleRequest(HttpServletRequest request) {
        //遍历请求参数
        String method = request.getMethod();

        Map<String, String> map = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        if ("POST".equals(method)) {
            try {
                int ts = 0;
                if (null != map.get("alert_ts") && !"".equals(map.get("alert_ts"))) {
                    try {
                        ts = Integer.parseInt(map.get("alert_ts"));
                    } catch (NumberFormatException e) {
                        return new Gson().toJson(new Message(map.get("alert_id"), e.getMessage()));
                    }
                }
                Alert alert = new Alert();
                alert.setAlertId(map.get("alert_id"));
                alert.setAlertTs(ts);
                alert.setModel(map.get("model"));
                alert.setSeverity(map.get("severity"));
                alert.setAlertType(map.get("alert_type"));
                alert.setServiceId(map.get("service_id"));
                alert.setServiceName(map.get("service_name"));
                alert.setTeamSlack(map.get("team_slack"));

                alertService.add(alert);
                return new Gson().toJson(new Message(map.get("alert_id"), ""));
            } catch (Exception e) {
                return new Gson().toJson(new Message(map.get("alert_id"), e.getMessage()));
            }

        }
        if ("GET".equals(method)) {
            String serviceId = map.get("service_id");
            String startTsStr = map.get("start_ts");
            String endTsStr = map.get("end_ts");
            int startTs = 0;
            int endTs = 0;
            try {
                startTs = Integer.parseInt(startTsStr);
                endTs = Integer.parseInt(endTsStr);
            } catch (NumberFormatException e) {
                return new Gson().toJson(new MessageGet(false, map.get("alert_id"), e.getMessage()));
            }
            List<Alert> alertList = alertService.find(serviceId, startTs, endTs);
            if (null != alertList && !alertList.isEmpty()) {
                Alert alert = alertList.get(0);
                String serviceName = alert.getServiceName();
                FindResult findResult = new FindResult();
                findResult.setServiceId(serviceId);
                findResult.setServiceName(serviceName);
                findResult.setAlerts(alertList);
                return new Gson().toJson(findResult);
            }
            return new Gson().toJson(new MessageGet(false, map.get("alert_id"), "empty data"));
        }

        return "hello";
    }
}
