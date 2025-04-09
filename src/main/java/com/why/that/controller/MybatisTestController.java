package com.why.that.controller;

import com.why.that.repository.DBTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class MybatisTestController {

  private final DBTestRepository dbTestRepository;

  @GetMapping("/mybatis")
  public String connectTest() {
    // select 1 from dual; 쿼리 테스트
    Integer result1 = dbTestRepository.selectOne();
    Integer result2 = dbTestRepository.selectTwo();
    if (result1 == 1 && result2 == 2) {
      return "ok";
    }
    return "fail";
  }
}
