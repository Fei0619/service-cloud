package com.test.ib.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 费世程
 * @date 2019/7/2 17:30
 */
@Configuration
public class MySelfRule {

  @Bean
  public IRule myRule(){
    return new RandomRuler_my();  //自定义算法
  }

}
