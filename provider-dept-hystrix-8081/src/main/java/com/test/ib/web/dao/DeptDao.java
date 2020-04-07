package com.test.ib.web.dao;

import com.test.ib.web.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 费世程
 * @Date: 2019/6/21 11:45
 */
@Mapper
public interface DeptDao {

  public int addDept(Dept pojo);

  public Dept findByDeptNo(@Param(value = "deptNo") Long deptNo);

  public List<Dept> findAll();

}
