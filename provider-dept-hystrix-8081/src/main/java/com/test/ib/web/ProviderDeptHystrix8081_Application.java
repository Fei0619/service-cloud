package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: 费世程
 * @Date: 2019/6/24 14:44
 */
@SpringBootApplication
@EnableEurekaClient     //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //对Hystrix熔断机制的支持
public class ProviderDeptHystrix8081_Application {

  public static void main(String[] args) {
    SpringApplication.run(ProviderDeptHystrix8081_Application.class,args);
  }

}
