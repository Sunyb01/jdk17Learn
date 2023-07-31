package com.sunyb.jdk17learn;

import com.sunyb.jdk17learn.m1.SwitchLearn;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author yb.Sun  2023/5/15 14:52
 */
public class SwitchTest {

    @Test
    void testReturnSwitch() {
        String msg = SwitchLearn.switchDayFrom(LocalDate.now().getDayOfWeek());
        System.out.println(msg);
    }

    @Test
    void testPrintSwitch() {
        SwitchLearn.printDayFrom(LocalDate.now().getDayOfWeek());
    }

    @Test
    void testInstance() {
        Object obj = 3;
        SwitchLearn.printInstanceOfValue(obj);
        obj = "sss";
        SwitchLearn.printInstanceOfValue(obj);
        obj = 1L;
        SwitchLearn.printInstanceOfValue(obj);
        // null
        SwitchLearn.printInstanceOfValue(null);
        obj = new Object();
        SwitchLearn.printInstanceOfValue(obj);
    }

}
