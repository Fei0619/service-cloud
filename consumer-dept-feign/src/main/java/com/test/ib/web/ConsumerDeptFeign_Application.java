package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: 费世程
 * @Date: 2019/6/25 17:51
 */
@SpringBootApplication(scanBasePackages = "com.test.ib.web")
@EnableFeignClients(basePackages = {"com.test.ib.web.feign"})
@EnableEurekaClient
public class ConsumerDeptFeign_Application {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerDeptFeign_Application.class,args);
  }

}
