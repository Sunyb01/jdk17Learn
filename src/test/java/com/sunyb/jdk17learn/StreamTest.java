package com.sunyb.jdk17learn;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author yb.Sun  2023/5/15 16:51
 */
public class StreamTest {

    @Test
    void toListTest() {
        List<Integer> src = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> tar = src.stream()
                .filter(item -> 0 != item % 2)
                .toList();
        System.out.println(tar);
    }
}
