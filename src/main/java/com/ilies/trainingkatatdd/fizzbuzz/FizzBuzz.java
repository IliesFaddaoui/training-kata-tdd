package com.ilies.trainingkatatdd.fizzbuzz;

public class FizzBuzz {

    public static final int ZERO = 0;
    public static final int THREE = 3;
    public static final int FIVE = 5;
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static String process(int value) {
        if (value == ZERO) {
            return String.valueOf(ZERO);
        }
        var result = "";
        if (isMultiple(value, THREE)) {
            result += FIZZ;
        }
        if (isMultiple(value, FIVE)) {
            result += BUZZ;
        }
        if (result.isBlank()) {
            return String.valueOf(value);
        } else {
            return result;
        }
    }

    public static boolean isMultiple(int value, int divider) {
        return value % divider == ZERO;
    }
}
