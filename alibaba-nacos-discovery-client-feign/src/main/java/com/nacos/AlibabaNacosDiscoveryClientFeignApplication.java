package com.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients//注解开启spring cloud feign客户端的功能
@SpringBootApplication
public class AlibabaNacosDiscoveryClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientFeignApplication.class, args);
    }

}
