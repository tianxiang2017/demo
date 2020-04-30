package com.example.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        // 获取服务。restTemplate已开启LoadBalanced功能。// 负载均衡策略默认是轮训
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
    }

}