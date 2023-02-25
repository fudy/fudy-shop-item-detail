package com.fudy.itemdetail.interfaces.web;

import com.fudy.itemdetail.infrastructure.dubbo.HelloServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {


    @Autowired
    private HelloServiceFacade helloServiceFacade;

    @RequestMapping("/hello")
    public String hello() {
        return helloServiceFacade.hello("xxx");
    }
}

