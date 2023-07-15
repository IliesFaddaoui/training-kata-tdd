package com.ilies.trainingkatatdd.fizzbuzz;

public class FizzBuzz {

    public static final int ZERO = 0;
    public static final int THREE = 3;
    public static final int FIVE = 5;

    public static String process(int value) {
        if (value == ZERO) {
            return "0";
        }
        var result = "";
        if (value % THREE == ZERO) {
            result += "Fizz";
        }
        if (value % FIVE == ZERO) {
            result += "Buzz";
        }
        if (result.isBlank()) {
            return String.valueOf(value);
        } else {
            return result;
        }
    }
}
