package com.lmtech.server.all;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang.jb on 2017-7-28.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.ui.enable}") //该配置项在配置中心管理
    private boolean environmentSpecificBooleanFlag;

    @Bean
    public Docket docketFactory() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("接口文档")
                .description("接口列表")
                .version("1.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();

        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("AppType").defaultValue("").description("小程序传wxApplet，其他接口留空").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ea"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .globalOperationParameters(aParameters)
                .enable(environmentSpecificBooleanFlag);
    }
}
