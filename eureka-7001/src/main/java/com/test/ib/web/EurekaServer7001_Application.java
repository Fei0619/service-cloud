package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 费世程
 * @Date: 2019/6/26 17:04
 */
@SpringBootApplication
@EnableEurekaServer     //EurekaServer服务端启动类，接受其他微服务注册进来
public class EurekaServer7001_Application {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServer7001_Application.class,args);
  }

}
