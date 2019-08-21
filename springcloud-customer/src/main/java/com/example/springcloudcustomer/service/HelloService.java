package com.example.springcloudcustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: chenqibin
 * @Date: 2019/8/21 16:25
 * @Description:
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hi(String name) {
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hi?name=" + name, String.class);
    }
}
