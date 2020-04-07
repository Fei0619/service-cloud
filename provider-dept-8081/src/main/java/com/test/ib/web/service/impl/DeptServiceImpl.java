package com.test.ib.web.service.impl;

import com.test.ib.web.dao.DeptDao;
import com.test.ib.web.entity.Dept;
import com.test.ib.web.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 费世程
 * @Date: 2019/6/24 14:36
 */
@Service
public class DeptServiceImpl implements DeptService {

  private final DeptDao dao;

  @Autowired
  public DeptServiceImpl(DeptDao dao){
    this.dao=dao;
  }

  @Override
  public int addDept(Dept pojo) {
    return dao.addDept(pojo);
  }

  @Override
  public Dept findByDeptNo(Long deptNo) {
    return dao.findByDeptNo(deptNo);
  }

  @Override
  public List<Dept> findAll() {
    return dao.findAll();
  }
}
