package com.chaos.service;

import com.chaos.po.AlarmTask;

import java.util.List;

public interface IAlarmTaskService {
    List<AlarmTask> list();

    int add(AlarmTask alarmTask);
}
