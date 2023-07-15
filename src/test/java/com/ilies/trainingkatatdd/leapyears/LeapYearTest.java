package com.ilies.trainingkatatdd.leapyears;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {

    @Test
    void shouldReturnNotALeapYear_2023() {
        assertFalse(LeapYear.aLeapYear(2023));
    }

    @Test
    void shouldReturnALeapYear_400() {
        assertTrue(LeapYear.aLeapYear(400));
    }

    @Test
    void shouldReturnNotALeapYear_1000() {
        assertFalse(LeapYear.aLeapYear(1000));
    }

    @Test
    void shouldReturnALeapYear_2008() {
        assertTrue(LeapYear.aLeapYear(2008));
    }
}