package com.sunyb.jdk17learn;

import org.junit.jupiter.api.Test;

/**
 * @author yb.Sun  2023/5/15 16:43
 */
public class StringTest {

    @Test
    void testTextBlock() {
        String block1 = """
                {
                    "name": "zs",
                    "age": 13
                }
                """;

        System.out.println(block1);
    }

    @Test
    void test_method_intern() {
        // jdk6字符串常量池还在永久代中, 执行intern()方法后会将值复制一份到常量池中; 而StringBuilder会在堆区创建一个实例, 所以返回false
        // jdk7开始字符串常量池迁移到堆, 执行intern()方法后, 会将当前字符串的首次出现实例引用记录到常量池即可
        // 所以第一个print打印true, str12直接使用的是字符串常量池中的引用, 与str1是统一个实例所以返回true
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str12 = "计算机软件";
        System.out.println(str12 == str1);

        String str2 = new StringBuilder("软件").append("计算机").toString();
        System.out.println(str2.intern() == str2);
    }

    @Test
    void test_method_intern2() {
        // 将字符串值放入字符串常量池中, str1是在堆区生成了一个新的实例, 不是同一个实例所以返回false
        String str12 = "计算机软件";
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str12 == str1);
        System.out.println(str1.intern() == str1);
    }

    @Test
    void test_method_intern3() {
        // 将字符串值放入字符串常量池中, str1是在堆区生成了一个新的实例, 不是同一个实例所以返回false
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str12 = "计算机" + "软件";
        System.out.println(str12 == str1);
    }

    @Test
    void test_stirng() {
        String h1 = "hello";
        String h2 = "hello";
        System.out.println(h1 == h2);
        String s1 = h1 + "Hydra";
        String s2 = h2 + "Hydra";
        System.out.println((s1 == "helloHydra"));
        System.out.println((s2 == "helloHydra"));
        System.out.println(s1 == s2);
    }
}
