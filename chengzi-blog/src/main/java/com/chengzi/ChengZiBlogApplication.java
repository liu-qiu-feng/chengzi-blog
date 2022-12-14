package com.chengzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chengzi.mapper")
public class ChengZiBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChengZiBlogApplication.class,args);
    }
}
