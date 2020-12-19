package com.guanshi.spring.cloud.alibaba.consumer.service.fallback;

import com.guanshi.spring.cloud.alibaba.consumer.service.echoservice.EchoService;
import org.springframework.stereotype.Component;

/**
 * @author poi 2020/12/19 19:53
 * @version 1.0
 * 2020/12/19 19:53
 */
@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String string) {
        return "echo fallback";
    }

    @Override
    public String lb() {
        return "lb fallback";
    }
}
