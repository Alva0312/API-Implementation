package com.assignment.alert_server.mapper;

import com.assignment.alert_server.bean.Alert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlertMapper {

    @Select("insert into alert(alert_id, service_id, service_name, model, alert_type, alert_ts, severity, team_slack) values(#{alertId}, #{serviceId}, #{serviceName}, #{model}, #{alertType}, #{alertTs}, #{severity}, #{teamSlack})")
    void add(Alert alert);

    @Select("select * from alert where service_id=#{serviceId} and alert_ts > #{startTs} and alert_ts < #{endTs}")
    @Results({
            @Result(column = "alert_id",property = "alertId"),
            @Result(column = "service_id",property = "serviceId"),
            @Result(column = "service_name",property = "serviceName"),
            @Result(column = "model",property = "model"),
            @Result(column = "alert_type",property = "alertType"),
            @Result(column = "alert_ts",property = "alertTs"),
            @Result(column = "severity",property = "severity"),
            @Result(column = "team_slack",property = "teamSlack")
    })
    List<Alert> find(String serviceId, long startTs, long endTs);
}
