package com.chaos.service.impl;

import com.chaos.mapper.IAlarmTaskMapper;
import com.chaos.po.AlarmTask;
import com.chaos.service.IAlarmTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AlarmTaskServiceImpl implements IAlarmTaskService {
    @Resource
    private IAlarmTaskMapper alarmTaskMapper;

    @Override
    public List<AlarmTask> list() {

        return alarmTaskMapper.listAll();
    }

    @Override
    @Transactional(readOnly = false)
    public int add(AlarmTask alarmTask) {

        return alarmTaskMapper.add(alarmTask);
    }


}
