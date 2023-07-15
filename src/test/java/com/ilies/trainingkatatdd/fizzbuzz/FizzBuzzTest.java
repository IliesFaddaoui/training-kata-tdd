package com.ilies.trainingkatatdd.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FizzBuzzTest {

    @Test
    void shouldReturn0If0() {
        assertEquals("0", FizzBuzz.process(0));
    }

    @Test
    void shouldReturn1If1() {
        assertEquals("1", FizzBuzz.process(1));
    }

    @Test
    void shouldReturnFizzIf3() {
        assertEquals("Fizz", FizzBuzz.process(3));
    }

    @Test
    void shouldReturnFizzIf6() {
        assertEquals("Fizz", FizzBuzz.process(6));
    }

    @Test
    void shouldReturnBuzzIf5() {
        assertEquals("Buzz", FizzBuzz.process(5));
    }

    @Test
    void shoudlReturnBuzzIf10() {
        assertEquals("Buzz",FizzBuzz.process(10));
    }

    @Test
    void shouldReturnFizzBuzzIf15() {
        assertEquals("FizzBuzz", FizzBuzz.process(15));
    }
}