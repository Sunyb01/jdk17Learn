package com.sunyb.jdk17learn;

import org.junit.jupiter.api.Test;

/**
 * @author yb.Sun  2023/5/15 16:45
 */
public class RecordTest {

    @Test
    void testRecord() {
        User u = new User("zs", 14);
        System.out.println(u.toString());
        System.out.println(new RecordUser("ls", 15).toString());
    }


    public static class User {
        private String name;

        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static record RecordUser(String name, Integer age) {}

}
