package com.chaos.controller;

import com.alibaba.fastjson.JSON;
import com.chaos.po.Event;
import com.chaos.service.IEventService;
import com.chaos.vo.AnalysisInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    IEventService eventService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        List<Event> list=eventService.listAll();
        AnalysisInfo result=eventService.analysis(list);
        return JSON.toJSONString(result);
    }
}
