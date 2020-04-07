package com.test.ib.web.feign;

import com.test.ib.web.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author 费世程
 * @date 2019/7/4 14:02
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
  @Override
  public DeptClientService create(Throwable throwable) {
    return new DeptClientService() {
      @Override
      public int addDept(Dept pojo) {
        return 0;
      }

      @Override
      public Dept findByDeptNo(Long id) {
        return new Dept().setDeptNo(id)
                .setDeptName("该ID："+id+"没有对应的信息,consumer客户端提供降级信息，此刻服务provider已经关闭")
                .setDbSource("no this database in MySQL");
      }

      @Override
      public List<Dept> findAll() {
        return Arrays.asList(new Dept().setDeptNo(null)
                .setDeptName("该ID没有对应的信息,consumer客户端提供降级信息，此刻服务provider已经关闭")
                .setDbSource("no this database in MySQL"));
      }
    };
  }
}
