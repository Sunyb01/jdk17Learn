package com.sunyb.jdk17learn;

import org.junit.jupiter.api.Test;

/**
 * @author yb.Sun  2023/5/15 14:54
 */
public class InstanceOfTest {

    @Test
    void instanceOfTest() {
        Object obj = 3;
        if (obj instanceof Integer s) {
            System.out.println("Integer value is " + s);
        }
        else if (obj instanceof String s) {
            System.out.println("String value is " + s);
        }
        else if (obj instanceof Long s) {
            System.out.println("Long value is " + s);
        }
        else {
            System.out.println("No match");
        }
    }


}
