package com.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FeignController {


    //注入client,调用他的方法
    @Autowired
    Client client;

    @GetMapping("/test")
    public  String test(){
        String result = client.hello("feign");
        return "Return :    "+result;
    }




    //注解指定需要调用服务的名称
    @FeignClient("alibaba-nacos-discovery-server")
    interface Client{

        @GetMapping("/hello")
        String hello(@RequestParam(name = "name") String name);
    }
}
