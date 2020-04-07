package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 费世程
 * @date 2019/7/12 16:34
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway_Application {

  public static void main(String[] args) {
    SpringApplication.run(ZuulGateway_Application.class,args);
  }

}
