package com.ilies.trainingkatatdd.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzTest {

    @Spy
    private FizzBuzz fizzBuzz;

    @Test
    void shouldReturn0If0() {
        assertEquals("0", fizzBuzz.process(0));
    }

    @Test
    void shouldReturn1If1() {
        assertEquals("1", fizzBuzz.process(1));
    }

    @Test
    void shouldReturnFizzIf3() {
        assertEquals("Fizz", fizzBuzz.process(3));
    }

    @Test
    void shouldReturnFizzIf6() {
        assertEquals("Fizz", fizzBuzz.process(6));
    }

    @Test
    void shouldReturnBuzzIf5() {
        assertEquals("Buzz", fizzBuzz.process(5));
    }

    @Test
    void shoudlReturnBuzzIf10() {
        assertEquals("Buzz",fizzBuzz.process(10));
    }

    @Test
    void shouldReturnFizzBuzzIf15() {
        assertEquals("FizzBuzz", fizzBuzz.process(15));
    }
}