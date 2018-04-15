package com.chaos.service;

import com.chaos.po.Event;
import com.chaos.vo.AnalysisInfo;
import com.chaos.vo.BigAuntParis;

import java.util.List;

public interface IEventService {
    List<Event> listAll();

    /**
     * 预测下次大姨妈开始与结束日期
     * @return
     */
    Event[] predictNextBigAunt();

    /**
     *
     * @param hisBaList 历史发生的大姨妈信息
     * @return
     */
    AnalysisInfo analysis(List<Event> hisBaList);

    int saveNext(BigAuntParis bigAuntParis);


}
