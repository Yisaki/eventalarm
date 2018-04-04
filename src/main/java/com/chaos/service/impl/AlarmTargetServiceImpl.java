package com.chaos.service.impl;

import com.chaos.mapper.IAlarmTargetMapper;
import com.chaos.po.AlarmTarget;
import com.chaos.service.IAlarmTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlarmTargetServiceImpl implements IAlarmTargetService {
    @Resource
    private IAlarmTargetMapper alarmTargetMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AlarmTarget> listAll() {
        return alarmTargetMapper.listAll();
    }
}
