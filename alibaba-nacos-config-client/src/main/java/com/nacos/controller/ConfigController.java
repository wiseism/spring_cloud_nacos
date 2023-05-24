package com.nacos.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@Slf4j
@RestController
@RefreshScope
public class ConfigController {

    //    @Value("${goods}")
    @Value("${didispace.title:}")
    private String title;

    @Autowired
    private NacosConfigManager nacosConfigManager;


    @GetMapping("/test")
    public String hello() {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, "127.0.0.1:8848");
//            properties.put(PropertyKeyConst.NAMESPACE, "563bbd2b-2c7b-4fd7-a45e-30d37399a40b");
            properties.put(PropertyKeyConst.NAMESPACE, "my-dev");
            NacosConfigService configService = new NacosConfigService(properties);
            String s = "";
            s = configService.getConfig(dataId, group, 600);
            log.warn("hello  dddd {}", s);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return title;
    }

    String dataId = "nacos-config-test.properties";
    String group = "DEFAULT_GROUP";

    @GetMapping("/test2")
    public String hello2() {

        String s = "";
        try {
            s = nacosConfigManager.getConfigService().getConfig(dataId, group, 600);
            log.warn("[getConfig all] " + s);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return s;
    }

}
