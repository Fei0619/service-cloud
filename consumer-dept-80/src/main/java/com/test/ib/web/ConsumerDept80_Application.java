package com.test.ib.web;

import com.test.ib.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: 费世程
 * @Date: 2019/6/25 17:51
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务的时候就能去加载我们自定义Ribbon配置类，从而使配置生效
 * name:指定使用算法的服务名称
 */
@RibbonClient(value = "provider-dept",configuration = MySelfRule.class)
public class ConsumerDept80_Application {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerDept80_Application.class,args);
  }

}
