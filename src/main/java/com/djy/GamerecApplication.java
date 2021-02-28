package com.djy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 扫描com.djy.dao
 */
@SpringBootApplication
@MapperScan("com.djy.dao")
public class GamerecApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamerecApplication.class, args);
    }

}
