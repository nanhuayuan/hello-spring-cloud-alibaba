package com.guanshi.spring.cloud.alibaba.consumer.controller;

import com.guanshi.spring.cloud.alibaba.consumer.service.echoservice.EchoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope//打开动态刷新功能
@RestController
public class TestEchoController {
    @Autowired
    private EchoService echoService;
    @GetMapping(value = "/feign/echo/{str}")
    public String echo(@PathVariable String str) {
        return echoService.echo(str);
    }



    @GetMapping(value = "/lb")
    public String lb() {
        return echoService.lb();
    }

    @Value("${user.name}")
    private String username;
    @GetMapping(value = "/config")
    public String config() {
        return echoService.echo(username);
    }
}