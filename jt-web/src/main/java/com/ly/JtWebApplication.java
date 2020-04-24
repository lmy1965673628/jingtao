package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//springboot项目启动时去除数据源启动
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class JtWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtWebApplication.class, args);
    }

}
