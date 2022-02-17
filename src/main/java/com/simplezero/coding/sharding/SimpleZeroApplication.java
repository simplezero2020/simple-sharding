package com.simplezero.coding.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.simplezero.coding.sharding.repository.dao"})
@SpringBootApplication(scanBasePackages = {"com.simplezero"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableTransactionManagement
public class SimpleZeroApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleZeroApplication.class, args);
    }
}


