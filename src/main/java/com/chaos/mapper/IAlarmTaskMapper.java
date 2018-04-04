package com.chaos.mapper;

import com.chaos.po.AlarmTask;

import java.util.List;

public interface IAlarmTaskMapper {
    List<AlarmTask> listAll();

    int add(AlarmTask alarmTask);
}
