package com.chaos.po;

import java.util.Date;

public class Event{
    private Long id;
    private Date eventTime;
    private Integer eventType;
    private Float correctScale;
    private Integer predictType;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Float getCorrectScale() {
        return correctScale;
    }

    public void setCorrectScale(Float correctScale) {
        this.correctScale = correctScale;
    }

    public Integer getPredictType() {
        return predictType;
    }

    public void setPredictType(Integer predictType) {
        this.predictType = predictType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
