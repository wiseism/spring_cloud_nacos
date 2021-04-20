package com.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.rmi.server.LoaderHandler;

@Slf4j
@RestController
public class TestController {

//      一.restemplate模版支持服务方式
    @Autowired
    LoadBalancerClient loadBalancerClient;

    //spring cloud common 提供负载均衡接口选取服务提供结点实现接口调用
    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
        String uri = serviceInstance.getUri() + "/hello?name= " + " didi";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return "Invoke : " +uri + "return : " + result;
    }



}
