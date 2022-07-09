package com.poype.easyauth.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.poype.easyauth")
@MapperScan("com.poype.easyauth.core.repository")
public class EasyAuthAdminApp {

    public static void main(String[] args) {
        SpringApplication.run(EasyAuthAdminApp.class, args);
    }

}
