package com.dillo.hireme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.dillo.hireme.config"})
public class HireMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HireMeApplication.class, args);
    }

}
