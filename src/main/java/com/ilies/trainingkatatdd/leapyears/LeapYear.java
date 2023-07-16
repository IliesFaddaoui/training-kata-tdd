 package com.ilies.trainingkatatdd.leapyears;

public class LeapYear {

    public static final int FOUR_HUNDRED = 400;
    public static final int FOUR = 4;
    public static final int HUNDRED = 100;
    private static final int ZERO = 0;

    public static boolean aLeapYear(int year) {
        return isMultiple(year, FOUR_HUNDRED) || isMultiple(year, FOUR) && !isMultiple(year,HUNDRED);
    }

    public static boolean isMultiple(int year, int divider) {
        return year % divider == ZERO;
    }
}
