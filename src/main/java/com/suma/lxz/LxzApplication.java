package com.suma.lxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.suma.lxz.dao")
@EnableWebMvc
public class LxzApplication {
    public static void main(String[] args) {
        SpringApplication.run(LxzApplication.class, args);
    }
}
