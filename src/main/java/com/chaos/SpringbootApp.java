package com.chaos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.chaos.config.web")
@MapperScan(basePackages = "com.chaos.mapper")
@SpringBootApplication
public class SpringbootApp {
    public static void main(String args[]){
        args=new String[]{"--spring.profiles.active=dev"};
        SpringApplication.run(SpringbootApp.class,args);
    }
}
