package com.example.springcloudcustomer.controller;

import com.example.springcloudcustomer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenqibin
 * @Date: 2019/8/21 16:25
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    public HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hi(name);
    }
}
