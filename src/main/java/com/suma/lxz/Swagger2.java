package com.suma.lxz;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author luxinzong
 * @date 2018/10/30
 * @description
 */
@Configuration
@EnableSwagger2
public class Swagger2 {


    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     * 接口文档默认访问路径http://localhost:8080/swagger-ui.html，
     *          配置文件中有配置此处为http://localhost:8080/springboot2/swagger-ui.html
     * 注解说明参考博客：https://blog.csdn.net/qq_28009065/article/details/79104103，
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().
                apis(RequestHandlerSelectors.basePackage("com.suma.lxz.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("陆新宗项目 USER APIS").description("用户api接口文档").version("1.0").build();
    }

}
