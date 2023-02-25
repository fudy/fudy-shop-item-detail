package com.fudy.itemdetail.infrastructure.dubbo;

import com.fudy.shop.item.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceFacade {
    @DubboReference(check = false,version = "1.0.0")
    private HelloService helloService;

    public String hello(String name) {
        return helloService.hello(name);
    }
}
