package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 费世程
 * @date 2019/7/8 16:49
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_HystrixDashboard_Application {

  public static void main(String[] args) {
    SpringApplication.run(Consumer_HystrixDashboard_Application.class,args);
  }

}
