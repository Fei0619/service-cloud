package com.test.ib.web.feign;

import com.test.ib.web.entity.Dept;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/7/3 14:50
 */
//@FeignClient(value = "provider-dept")
@FeignClient(value = "provider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

  @PostMapping(value = "/dept/add")
  int addDept(@RequestBody Dept pojo);

  @GetMapping(value = "/dept/findByNo")
  Dept findByDeptNo(@Param(value = "deptNo") Long deptNo);

  @GetMapping(value = "/dept/findAll")
  List<Dept> findAll();

}
