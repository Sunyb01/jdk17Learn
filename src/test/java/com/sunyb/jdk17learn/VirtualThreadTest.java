package com.sunyb.jdk17learn;

import org.junit.jupiter.api.Test;

/**
 * @author yb.Sun
 * @date 2023/10/12 10:42
 */
public class VirtualThreadTest {

    @Test
    void create_vt(){
        Thread thread = Thread.startVirtualThread(() -> System.out.println("This is virtual thread!"));
        thread.start();
    }
}
