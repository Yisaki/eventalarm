package com.chaos.controller;

import com.chaos.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String toLogin(String msg,Model model){
        if(msg!=null){
            model.addAttribute("msg",msg);
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login(String userName, String password, HttpServletRequest request){
        if("hxq".equals(userName)&&"123".equals(password)){
            HttpSession session=request.getSession();
            session.setAttribute("login",userName);
            return "redirect:/event/list.htm";
        }else{
            return "redirect:/?msg="+ CommonUtil.urlEncodeWithUtf8("密码错误");
        }

    }

    public String logout(){
        return "login";
    }
}
