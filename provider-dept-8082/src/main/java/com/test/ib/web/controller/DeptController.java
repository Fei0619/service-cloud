package com.test.ib.web.controller;

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

  private final DeptService service;
  private final DiscoveryClient discoveryClient;

  @Autowired
  public DeptController(DeptService service,DiscoveryClient discoveryClient){
    this.service=service;
    this.discoveryClient=discoveryClient;
  }

  /**
   * 服务发现
   * @return
   */
  @GetMapping(value = "/dept/discovery")
  public Object discovery(){
    List<String> list=discoveryClient.getServices();
    System.out.println("*******************"+list);
    List<ServiceInstance> serviceList=discoveryClient.getInstances("provider-dept");
    for (ServiceInstance item:serviceList){
      System.out.println(item.getServiceId()+"\t"+item.getHost()+"\t"
              +item.getPort()+"\t"+item.getUri());
    }
    return this.discoveryClient;
  }

  @PostMapping(value = "/dept/add")
  public int addDept(@RequestBody Dept pojo) {
    return service.addDept(pojo);
  }

  @GetMapping(value = "/dept/findByNo")
  public Dept findByDeptNo(@Param(value = "deptNo") Long deptNo) {
    return service.findByDeptNo(deptNo);
  }

  @GetMapping(value = "/dept/findAll")
  public List<Dept> findAll() {
    return service.findAll();
  }

}
