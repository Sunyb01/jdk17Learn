package com.sunyb.jdk17learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author yb.Sun
 * @date 2023/5/15 11:18
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class Jdk17LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jdk17LearnApplication.class, args);
    }
}
