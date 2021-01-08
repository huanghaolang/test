package com.ac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"com.ac.dao","com.ac.ext.dao"})
//@SpringBootApplication(scanBasePackages={"com.ac.aop"})
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class, args);
    }

}
