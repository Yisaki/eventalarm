package com.chaos.controller;

import com.chaos.po.Event;
import com.chaos.service.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
}
