package com.test.ib.web.controller;

import com.test.ib.web.entity.Dept;
import com.test.ib.web.feign.DeptClientService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController_Consumer {

  private DeptClientService service;

  @Autowired
  public DeptController_Consumer(DeptClientService service){
    this.service=service;
  }

  @PostMapping(value = "/consumer/dept/add")
  public int addDept(@RequestBody Dept pojo) {
    return service.addDept(pojo);
  }

  @RequestMapping(value = "/consumer/dept/findByNo",method = RequestMethod.GET)
  public Dept findByDeptNo(@Param(value = "deptNo") Long deptNo) {
    return service.findByDeptNo(deptNo);
  }

  @GetMapping(value = "/consumer/dept/findAll")
  public List<Dept> findAll() {
    return service.findAll();
  }


}
