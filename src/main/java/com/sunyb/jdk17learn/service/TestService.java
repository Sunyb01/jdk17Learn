package com.sunyb.jdk17learn.service;

import org.springframework.stereotype.Service;

/**
 * @author yb.Sun
 * @date 2023/7/31 17:30
 */
@Service
public class TestService {

    public String t1(Boolean needErr){
        if (needErr) {
            throw new IllegalArgumentException("运行出错啦");
        }

        return "this is t1";
    }
}
