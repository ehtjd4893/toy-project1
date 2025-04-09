package com.why.that.repository.mybatis;

import com.why.that.mapper.MybatisTestMapper;
import com.why.that.repository.DBTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisTestRepository implements DBTestRepository {

  private final MybatisTestMapper mybatisTestMapper;

  @Override
  public Integer selectOne() {
    return mybatisTestMapper.selectOneTest();
  }

  @Override
  public Integer selectTwo() {
    return mybatisTestMapper.selectTwoTest();
  }

}