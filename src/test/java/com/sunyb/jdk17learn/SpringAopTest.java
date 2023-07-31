package com.sunyb.jdk17learn;

import com.sunyb.jdk17learn.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yb.Sun
 * @date 2023/7/31 17:41
 */
@SpringBootTest
public class SpringAopTest {

    @Autowired
    private TestService testService;

    @Test
    void execute_method() {
        testService.t1(false);
    }

    @Test()
    void execute_method_with_fail() {
        IllegalArgumentException exc = Assertions.assertThrows(IllegalArgumentException.class, () -> testService.t1(true));

    }
}
