package com.sunyb.jdk17learn;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @author yb.Sun
 * @date 2023/9/19 15:09
 */
public class CompletableFutureTest {

    @Test
    @SneakyThrows
    void testSupplyAsync(){
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello!");
        Assertions.assertEquals("hello!", f1.get());
    }

    @Test
    @SneakyThrows
    void testThenApply(){
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello")
                .thenApplyAsync(s1 -> s1 + " world!");
        Assertions.assertEquals("hello world!", f1.get());
    }

    @Test
    @SneakyThrows
    void testThenAccept(){
        CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(() -> "hello")
                .thenAcceptAsync(s1 -> System.out.println(s1 + " world!"));
        f1.get();
    }

    @Test
    @SneakyThrows
    void testWhenComplete(){
        // 任务完成时触发回调函数, 并正确处理异常
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello")
                .whenComplete((res, ex) -> {
            if (Objects.nonNull(ex)) {
                System.out.println("糟糕, 出现异常了!!!");
                return;
            }

            System.out.println("一起正常, 返回值为: " + res);
        });
        System.out.println(f1.get());
    }

    @Test
    @SneakyThrows
    void testExceptionProcess(){
        // 处理正常的返回结果和异常, 并返回一个新的结果; 而不让异常影响正常的业务逻辑;
        // 更像是thenApply()的加强版
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("糟糕, 出错了!");
            }

            return "hello";
        }).handleAsync((res, ex) -> Objects.nonNull(ex) ? ex.getMessage() : res);
        System.out.println(f1.get());

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "hello")
                .handleAsync((res, ex) -> Objects.nonNull(ex) ? ex.getMessage() : res + " world");
        System.out.println(f2.get());
    }

    @Test
    @SneakyThrows
    void testCombinationWithThenCompose(){
        // 自定义将前一个结果作为当前的参数
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello")
                .thenComposeAsync(res -> CompletableFuture.supplyAsync(() -> res + " world"));
        System.out.println(f1.get());
    }

    @Test
    @SneakyThrows
    void testCombinationWithThenCombine(){
        // 将两个的结果组合起来;
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> " world");
        CompletableFuture<String> f3 = f1.thenCombineAsync(f2, (r1, r2) -> r1 + r2);
        System.out.println(f3.get());
    }

    @Test
    @SneakyThrows
    void testAllOf(){
        // 和handle方法很像,
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> " world");
        CompletableFuture<Void> f3 = CompletableFuture.allOf(f1, f2);
        System.out.println(f3.join());
    }
}
