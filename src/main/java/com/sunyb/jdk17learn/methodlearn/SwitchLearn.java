package com.sunyb.jdk17learn.methodlearn;

import java.time.DayOfWeek;

/**
 * @author yb.Sun  2023/5/15 14:48
 */
public class SwitchLearn {

    public static String switchDayFrom(DayOfWeek dk) {
        return switch (dk) {
            case null -> "Null";
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };
    }

    public static void printDayFrom(DayOfWeek dk) {
        switch (dk) {
            case null -> System.out.println("Null");
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Working Day");
            case SATURDAY, SUNDAY -> System.out.println("Day Off");
        }
    }

    public static void printInstanceOfValue(Object obj) {
        switch (obj) {
            case null -> System.out.println("Empty obj");
            case Integer s -> System.out.println("Integer value is " + s);
            case String s -> System.out.println("String value is " + s);
            case Long s -> System.out.println("Long value is " + s);
            default -> System.out.println("No match");
        }
    }
}
