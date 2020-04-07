package com.test.ib.web.service;

import com.test.ib.web.entity.Dept;

import java.util.List;

/**
 * @Author: 费世程
 * @Date: 2019/6/24 14:35
 */
public interface DeptService {

  public int addDept(Dept pojo);

  public Dept findByDeptNo(Long deptNo);

  public List<Dept> findAll();

}
