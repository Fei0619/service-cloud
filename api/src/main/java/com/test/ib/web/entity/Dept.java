package com.test.ib.web.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 费世程
 * @Date: 2019/6/20 16:28
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //使用链式设置属性
@Data
public class Dept implements Serializable {

  private Long deptNo;

  private String deptName;

  /**
   * 来自哪个数据库
   * 微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
   */
  private String dbSource;

  @Override
  public String toString() {
    return JSONObject.toJSONString(this);
  }

  public static void main(String[] args) {
    Dept dept=new Dept();
    dept.setDeptNo(1000L).setDeptName("研发部").setDbSource("db01");
    System.out.println(dept);
  }
}
