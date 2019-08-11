package com.onekook.ddns.aliyun.domain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author kook
 */
@SpringBootApplication
@EnableScheduling
public class AliyunDomainApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliyunDomainApplication.class, args);
    }
}
