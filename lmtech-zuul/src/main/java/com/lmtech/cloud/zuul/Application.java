package com.lmtech.cloud.zuul;

import com.lmtech.http.interceptor.LoggingRequestInterceptor;
import com.lmtech.util.RestTemplateBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(value = {"com.lmtech"})
@EnableZuulProxy
@SpringBootApplication
public class Application  {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = RestTemplateBuilder.buildRestTemplate();
        LoggingRequestInterceptor loggingRequestInterceptor = new LoggingRequestInterceptor();
        restTemplate.getInterceptors().add(loggingRequestInterceptor);
        return restTemplate;
    }

    /*@Bean
    public IRule ribbonRule() {
        return new WeightedResponseTimeRule();
    }*/

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}