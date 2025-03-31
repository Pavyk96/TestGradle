package com.pavyk96.TestGradle.hw5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class Config {
    @Value("${app.name}")
    private String appName;

    @Value("${app.config.values}")
    private List<String> configValues;

    @Value("${app.example.env}")
    private String exampleEnv;

    @Bean
    @Profile("test")
    public String testProfileBean() {
        return "This bean is only for TEST profile";
    }

    @Bean
    @ConditionalOnBean(name = "testProfileBean")
    public String dependentBean() {
        return "This bean depends on testProfileBean";
    }

    @Bean
    @ConditionalOnExpression("'${app.example.env}' != 'default'")
    public String envSpecificBean() {
        return "This bean is created when example.env is not default";
    }

    @PostConstruct
    public void init() {
        System.out.println("App Name: " + appName);
        System.out.println("Config Values: " + configValues);
        System.out.println("Example Env: " + exampleEnv);
    }
}
