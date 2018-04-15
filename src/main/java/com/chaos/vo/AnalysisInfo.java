package com.chaos.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class AnalysisInfo {

    private Integer avgLastDay;

    private Integer avgGapDay;

    @JSONField(format="yyyy-MM-dd")
    private Date nextCome;

    @JSONField(format="yyyy-MM-dd")
    private Date nextGo;

    public Integer getAvgLastDay() {
        return avgLastDay;
    }

    public void setAvgLastDay(Integer avgLastDay) {
        this.avgLastDay = avgLastDay;
    }

    public Integer getAvgGapDay() {
        return avgGapDay;
    }

    public void setAvgGapDay(Integer avgGapDay) {
        this.avgGapDay = avgGapDay;
    }

    public Date getNextCome() {
        return nextCome;
    }

    public void setNextCome(Date nextCome) {
        this.nextCome = nextCome;
    }

    public Date getNextGo() {
        return nextGo;
    }

    public void setNextGo(Date nextGo) {
        this.nextGo = nextGo;
    }
}
