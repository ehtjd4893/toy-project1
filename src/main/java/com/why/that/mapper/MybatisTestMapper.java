package com.why.that.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MybatisTestMapper {
  Integer selectOneTest();

  @Select("SELECT 2 FROM DUAL")
  Integer selectTwoTest();
}
