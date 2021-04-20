package com.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AlibabaNacosConfigClientApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AlibabaNacosConfigClientApplication.class, args);


//        ConfigurableApplicationContext context = SpringApplication.run(AlibabaNacosConfigClientApplication.class, args);
//        while(true){
//            String goods = context.getEnvironment().getProperty("goods");
//            System.out.println(goods);
//            TimeUnit.SECONDS.sleep(1);
//        }


    }


}
