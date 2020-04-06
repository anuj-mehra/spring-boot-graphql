package com.poc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.poc.springboot")
public class SpringBootApplicationStarter //extends SpringBootServletInitializer
{
    public static void main( String[] args ){
    	SpringApplication.run(SpringBootApplicationStarter.class, args);
    }
}
