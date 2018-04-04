package com.chaos.controller;

import com.chaos.po.AlarmTarget;
import com.chaos.po.AlarmTask;
import com.chaos.service.IAlarmTargetService;
import com.chaos.service.IAlarmTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/alarmTask")
public class AlarmTaskController {

    private final static String PATH="alarmTask/";

    @Resource
    private IAlarmTargetService alarmTargetService;
    @Resource
    private IAlarmTaskService alarmTaskService;

    @RequestMapping("/toAdd.htm")
    public String toAdd(Model model){
        List<AlarmTarget> alarmTargetlist=alarmTargetService.listAll();
        model.addAttribute("alarmTargetlist",alarmTargetlist);
        return PATH+"toAdd";
    }

    @RequestMapping("/add.htm")
    public String add(AlarmTask alarmTask,BindingResult bindingResult){
        alarmTaskService.add(alarmTask);
        return "redirect:/alarmTask/list.htm";
    }

    @RequestMapping("/list.htm")
    public String list(Model model){
        List<AlarmTask> alarmTaskList=alarmTaskService.list();
        model.addAttribute("alarmTaskList",alarmTaskList);
        return PATH+"list";
    }

}
