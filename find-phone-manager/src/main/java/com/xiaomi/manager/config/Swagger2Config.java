package com.xm.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**

 * @Description
 * @date 2021 年 02 月 20 日 20:51
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 配置摘要
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.xm.manager.controller"))
                .build();
    }

    /**
     * 配置api的说明信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .description("手机资产管理系统")
                .contact(new Contact("林永健",null,"lyj@xm.com"))
                .title("手机资产管理系统")
                .version("1.0.0")
                .build();
    }
}
