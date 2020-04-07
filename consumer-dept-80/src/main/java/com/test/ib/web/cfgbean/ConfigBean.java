package com.test.ib.web.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 费世程
 * @Date: 2019/6/25 17:43
 */
@Configuration
public class ConfigBean {

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }

  @Bean
  public IRule myRule(){
//    return new RandomRule();  //用我们重新选择的随机算法替代默认的轮询
    return new RetryRule();
  }

}
