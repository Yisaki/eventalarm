package com.chaos.controller;

import com.chaos.po.Event;
import com.chaos.service.IEventService;
import com.chaos.vo.AnalysisInfo;
import com.chaos.vo.BigAuntParis;
import com.chaos.vo.ResultVo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    @Resource
    private IEventService eventService;

    private final static String PATH="event/";
    @RequestMapping("/list.htm")
    public String list(Model model){
        List<Event> eventList=eventService.listAll();
        model.addAttribute("eventList",eventList);
        return PATH+"eventList";
    }

    @ResponseBody
    @RequestMapping(value="/analysis.do",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultVo analysisWithHis(){
        List<Event> allEvent=eventService.listAllReal();
        AnalysisInfo result=eventService.analysis(allEvent);
        return new ResultVo(result);
    }

    @ResponseBody
    @RequestMapping(value="/saveMextBigAunt.do",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultVo saveMextBigAunt(Date come,Date go){
        Event baCome=new Event();
        baCome.setEventTime(come);
        baCome.setCorrectScale(1F);
        baCome.setEventType(1);
        baCome.setPredictType(1);
        baCome.setEventDesc("预测");

        Event baGo=new Event();
        baGo.setEventTime(go);
        baGo.setCorrectScale(1F);
        baGo.setEventType(2);
        baGo.setPredictType(1);
        baCome.setEventDesc("预测");

        BigAuntParis nextBigAuntParis=new BigAuntParis(baCome,baGo);

        eventService.saveNext(nextBigAuntParis);

        return  new ResultVo(null);
    }



}
