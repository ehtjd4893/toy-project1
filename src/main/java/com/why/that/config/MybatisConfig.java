package com.why.that.config;

import org.mybatis.spring.boot.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
public class MybatisConfig {
  @Bean
  SqlSessionFactoryBeanCustomizer sqlSessionFactoryBeanCustomizer() {
    return factoryBean -> {
      // 1. MyBatis 전역 설정 (CamelCase 매핑 등)
      org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
      config.setMapUnderscoreToCamelCase(true); // CamelCase 활성화
      factoryBean.setConfiguration(config);

      // 2. Mapper XML 파일 위치 지정
      try {
        factoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mybatis/mapper/**/*.xml")
        );
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      // 3. Type Aliases 패키지 설정
      factoryBean.setTypeAliasesPackage("com.why.that.dao");
    };
  }
}