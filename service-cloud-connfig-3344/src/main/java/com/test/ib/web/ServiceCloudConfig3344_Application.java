package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 费世程
 * @date 2019/8/7 10:21
 */
@SpringBootApplication
@EnableConfigServer
public class ServiceCloudConfig3344_Application {
  public static void main(String[] args) {
    SpringApplication.run(ServiceCloudConfig3344_Application.class,args);
  }
}
