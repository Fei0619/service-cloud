package com.test.ib.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.ib.web.entity.Dept;
import com.test.ib.web.service.DeptService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 费世程
 * @Date: 2019/6/24 14:38
 */
@RestController
public class DeptController {

  @Autowired
  private DeptService service;

  /**
   * 一旦调用服务方法失败并抛出了错误信息后，
   * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
   */
  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
  @HystrixCommand(fallbackMethod = "processHystrix_Get")
  public Dept get(@PathVariable("id") Long id){
    Dept dept=service.findByDeptNo(id);
    if (null==dept){
      throw new RuntimeException("该"+id+"没有对应的信息...");
    }
    return dept;
  }

  public Dept processHystrix_Get(@PathVariable("id") Long id){
    return new Dept().setDeptNo(id).setDeptName("该ID："+id+"没有对应的信息...null")
            .setDbSource("no this database in MySQL");
  }

}
