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
    //	private static String REST_URL_PREFIX = "http://localhost:8762";
    /*直接根据微服务名调用，而不再是根据地址和端口了，运用了eureka的发现功能*/
    private static String REST_URL_PREFIX = "http://microservice-hi-provider";

    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String hi(String name) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/hi/" + name, String.class);
    }
}
