package com.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class WebClientController {


    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/test")
    public Mono<String> test() {
        Mono<String> result = webClientBuilder.build()
                .get()
                .uri("http://alibaba-nacos-discovery-server/hello?name=ceshi")
                .retrieve()
                .bodyToMono(String.class);
        return result;
    }

    @Bean
    @LoadBalanced//集群支持，负载均衡，必须要有本注解，不然请求会失败
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
