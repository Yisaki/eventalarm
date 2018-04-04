package com.chaos.service;

import com.chaos.po.Event;

import java.util.List;

public interface IEventService {
    List<Event> listAll();

    /**
     * 预测下次大姨妈开始与结束日期
     * @return
     */
    Event[] predictNextBigAunt();
}
