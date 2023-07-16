package com.ilies.trainingkatatdd.fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @Test
    void shouldReturn0_0Plus0() {
        Fraction zero = Fraction.createFraction(0,1);
        Fraction result = zero.plus(zero);
        assertEquals(zero, result);
    }

    @Test
    void shouldReturn1_1Plus0() {
        Fraction zero = Fraction.createFraction(0,1);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = one.plus(zero);
        assertEquals(1, result.getNominator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void shouldReturn1_0Plus1() {
        Fraction zero = Fraction.createFraction(0,1);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = zero.plus(one);
        assertEquals(1, result.getNominator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void shouldReturn3_2Plus1() {
        Fraction two = Fraction.createFraction(2,1);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = two.plus(one);
        assertEquals(3, result.getNominator());
    }

    @Test
    void shouldReturn2d3_1d3Plus1d3() {
        Fraction oneTier = Fraction.createFraction(1,3);
        Fraction result = oneTier.plus(oneTier);
        assertEquals(2, result.getNominator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void shouldReturn3d2_1d2Plus1d1(){
        Fraction oneHalf = Fraction.createFraction(1,2);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = oneHalf.plus(one);
        assertEquals(3,result.getNominator());
        assertEquals(2,result.getDenominator());
    }

    @Test
    void shouldReturn1d1_2d4Plus2d4() {
        Fraction twoQuarter = Fraction.createFraction(2,4);
        Fraction result = twoQuarter.plus(twoQuarter);
        assertEquals(1,result.getNominator());
        assertEquals(1,result.getDenominator());
    }

    @Test
    void shouldReturn5d3_2d3Plus5d5() {
        Fraction twoTier = Fraction.createFraction(2,3);
        Fraction fiveFiver = Fraction.createFraction(5,5);
        Fraction result = twoTier.plus(fiveFiver);
        assertEquals(5,result.getNominator());
        assertEquals(3,result.getDenominator());
    }

    @Test
    void shouldReturnPositiveInfinity_1d0Plus1000d1(){
        Fraction oneZero = Fraction.createFraction(1,0);
        Fraction one = Fraction.createFraction(1000,1);
        Fraction result = oneZero.plus(one);
        assertEquals(Fraction.PLUS_INFINITY,result);
    }

    @Test
    void shouldReturn1d2_3d2Minus2d2() {
        Fraction threeHalf = Fraction.createFraction(3,2);
        Fraction twoHalf = Fraction.createFraction(2,2);
        Fraction result = threeHalf.minus(twoHalf);
        assertEquals(1,result.getNominator());
        assertEquals(2,result.getDenominator());
    }

    @Test
    void shouldReturn3d2_5d2Minus1d1() {
        Fraction fiveHalf = Fraction.createFraction(5,2);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = fiveHalf.minus(one);
        assertEquals(3,result.getNominator());
        assertEquals(2,result.getDenominator());
    }

    @Test
    void shouldReturn3d2_10d4Minus1d1() {
        Fraction tenQuarter = Fraction.createFraction(10,4);
        Fraction one = Fraction.createFraction(1,1);
        Fraction result = tenQuarter.minus(one);
        assertEquals(3,result.getNominator());
        assertEquals(2,result.getDenominator());
    }

    @Test
    void shouldReturnPlusInfity_1d0Minus10d3(){
        Fraction oneZero = Fraction.createFraction(1,0);
        Fraction tenTier = Fraction.createFraction(10,3);
        Fraction result = oneZero.minus(tenTier);
        assertEquals(Fraction.PLUS_INFINITY, result);
    }

    @Test
    void shouldReturnMinusInfity_10d3Minus1d0(){
        Fraction oneZero = Fraction.createFraction(1,0);
        Fraction tenTier = Fraction.createFraction(10,3);
        Fraction result = tenTier.minus(oneZero);
        assertEquals(Fraction.MINUS_INFINITY, result);
    }

    @Test
    void shouldRaiseException_infinityMinusInfinity() {
        assertThrows(IllegalArgumentException.class, () -> Fraction.PLUS_INFINITY.minus(Fraction.PLUS_INFINITY));
    }

}