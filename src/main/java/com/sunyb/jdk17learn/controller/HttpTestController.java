package com.sunyb.jdk17learn.controller;

import com.sunyb.jdk17learn.remote.DataSyncRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yb.Sun
 * @date 2023/7/31 16:39
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/htc")
public class HttpTestController {

    private final DataSyncRemoteService remoteService;

    @GetMapping("/m1")
    public Object getToken() {
        return remoteService.getToken("bbk24").block();
    }
}
