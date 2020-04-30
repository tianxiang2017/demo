package com.example.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 启用服务注册和发现
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    // Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。
    @Bean
    @LoadBalanced // 表明这个restTemplate开启负载均衡的功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
