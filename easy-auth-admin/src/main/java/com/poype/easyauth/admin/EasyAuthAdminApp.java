package com.poype.easyauth.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication(scanBasePackages = "com.poype.easyauth")
@MapperScan("com.poype.easyauth.core.repository")
public class EasyAuthAdminApp {

    public static void main(String[] args) {
        SpringApplication.run(EasyAuthAdminApp.class, args);
    }

}
