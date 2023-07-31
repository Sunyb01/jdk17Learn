package com.sunyb.jdk17learn.config;

import com.sunyb.jdk17learn.remote.DataSyncRemoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author yb.Sun
 * @date 2023/7/31 16:45
 */
@Configuration
public class RemoteClientConfig {

    @Bean
    public DataSyncRemoteService postClient() {
        WebClient client = WebClient.builder()
                .baseUrl("http://112.124.10.222:8807")
                .build();
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client))
                        .build();
        return httpServiceProxyFactory.createClient(DataSyncRemoteService.class);
    }
}
