package com.test.ib.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

//  private static final String REST_URL_PREFIX="http://localhost:8081";
  private static final String REST_URL_PREFIX="http://provider-dept";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/dept/findAll")
  public List findAll() {
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll",List.class);
  }

}
