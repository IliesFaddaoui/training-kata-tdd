package com.ilies.trainingkatatdd.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzTest {

    @Spy
    private FizzBuzz fizzBuzz;
    // 1st test for fizzBuzz: We take the more general solution which is the default case and the most basic solution as required by TDD methodology, here return the int by default
    @Test
    void shouldReturn0If0(){
        assertEquals("0", fizzBuzz.process(0));
    }

}