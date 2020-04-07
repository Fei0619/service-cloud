package com.test.ib.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 轮询策略，但是加上新的需求：每个服务要求被调用5次
 * @author 费世程
 * @date 2019/7/3 10:38
 */
public class RandomRuler_my extends AbstractLoadBalancerRule {

  private int total=0;  //总共被调用的次数
  private int currentIndex=0;  //当前提供服务的机器号

  public Server choose(ILoadBalancer lb, Object key) {
    if (lb == null) {
      return null;
    }
    Server server = null;

    while (server == null) {
      if (Thread.interrupted()) {
        return null;
      }
      List<Server> upList = lb.getReachableServers();
      List<Server> allList = lb.getAllServers();

      int serverCount = allList.size();
      if (serverCount == 0) {
        return null;
      }

      if (total<5){
        server=upList.get(currentIndex);
        total++;
      }else{
        total=0;
        currentIndex++;
        if (currentIndex>=upList.size()){
          currentIndex=0;
        }
      }

      if (server == null) {
        //唯一可能发生这种情况的情况是服务器列表以某种方式被修剪。这是一个瞬态条件。屈服后重试。
        Thread.yield();
        continue;
      }

      if (server.isAlive()) {
        return (server);
      }

      // Shouldn't actually happen.. but must be transient or a bug.
      server = null;
      Thread.yield();
    }
    return server;

  }

  @Override
  public Server choose(Object key) {
    return choose(getLoadBalancer(), key);
  }

  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {

  }
}
