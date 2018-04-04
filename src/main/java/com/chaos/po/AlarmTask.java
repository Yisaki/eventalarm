package com.chaos.po;

import java.util.Date;

public class AlarmTask {
    private Long id;
    private Date alarmTime;
    private Integer alarmFix;
    private Integer alarmCount;
    private String alarmDesc;
    private Integer status;
    private Date createTime;

    private AlarmTarget alarmTarget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getAlarmFix() {
        return alarmFix;
    }

    public void setAlarmFix(Integer alarmFix) {
        this.alarmFix = alarmFix;
    }

    public Integer getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(Integer alarmCount) {
        this.alarmCount = alarmCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAlarmDesc() {
        return alarmDesc;
    }

    public void setAlarmDesc(String alarmDesc) {
        this.alarmDesc = alarmDesc;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public AlarmTarget getAlarmTarget() {
        return alarmTarget;
    }

    public void setAlarmTarget(AlarmTarget alarmTarget) {
        this.alarmTarget = alarmTarget;
    }
}
