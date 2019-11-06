package com.ac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.ac.dao"})
@SpringBootApplication
public class demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class, args);
    }

}
