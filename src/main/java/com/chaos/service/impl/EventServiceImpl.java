package com.chaos.service.impl;

import com.chaos.mapper.IEventMapper;
import com.chaos.po.Event;
import com.chaos.service.IEventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EventServiceImpl implements IEventService {
    @Resource
    private IEventMapper eventMapper;
    @Override
    public List<Event> listAll() {

        return eventMapper.listAll();
    }

    @Override
    public Event[] predictNextBigAunt() {
        List<Event> bigAuntEvnetList=null;
        //两次间隔
        int[] space=null;
        //持续时间
        int[] last=null;
        //准确率
        float[] scale=null;

        float spaceUp=0;
        int spaceDown=0;

        float lastUp=0;
        int lastDown=0;
        int sampleSize=space.length;
        for(int i=0;i<sampleSize;i++){
            spaceUp+=space[i]*scale[i];
            spaceDown+=space[i];

            lastUp+=last[i]*scale[i];
            spaceDown+=last[i];
        }

        return new Event[0];
    }
}
