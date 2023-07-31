package com.sunyb.jdk17learn.remote;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * @author yb.Sun
 * @date 2023/7/31 16:32
 */
@HttpExchange("/datasync")
public interface DataSyncRemoteService {

    @PostExchange(url = "/system/login")
    Mono<Object> getToken(@RequestParam("userName") String userName);
}
