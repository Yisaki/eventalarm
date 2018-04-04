package com.chaos.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class ControllerAspect {

    @Pointcut("execution(public * com.chaos.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerPointCut(){

    }

    @Around("controllerPointCut()")
    public Object injectContext(ProceedingJoinPoint pjp) throws Throwable{

        Object result=pjp.proceed();


        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        request.setAttribute("basePath", basePath);

       // System.out.println(basePath);

        return result;
    }
}
