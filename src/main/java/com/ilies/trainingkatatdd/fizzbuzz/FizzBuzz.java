package com.ilies.trainingkatatdd.fizzbuzz;

public class FizzBuzz {
    public String process(int i) {
        if (i == 0) {
            return "0";
        }
        var result = "";
        if (i % 3 == 0) {
            result += "Fizz";
        }
        if (i % 5 == 0) {
            result += "Buzz";
        }
        if (result.isBlank()) {
            return String.valueOf(i);
        } else {
            return result;
        }
    }
}
