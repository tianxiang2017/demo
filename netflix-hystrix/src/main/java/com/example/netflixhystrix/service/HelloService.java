package com.example.netflixhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError") // 该注解对该方法创建了熔断器的功能。当服务不可以时，会快速失败
    public String hiService(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class); // 负载均衡策略默认是轮训
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}