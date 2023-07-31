package com.sunyb.jdk17learn.controller;

import com.sunyb.jdk17learn.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author yb.Sun
 * @date 2023/7/31 17:31
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/aop/test")
public class AopTestController {

    private final TestService testService;

    @GetMapping("/t1")
    public Object t1(Boolean needErr) {
        return testService.t1(Optional.ofNullable(needErr).orElse(false));
    }
}
