package com.ilies.trainingkatatdd.fraction;

public class Fraction {

    public static final int ZERO = 0;
    private final int nominator;
    private final int denominator;
    public static final int ONE = 1;
    public static final Fraction NULL = new Fraction(ZERO, ONE);
    public static final Fraction PLUS_INFINITY = new Fraction(ONE, ZERO);
    public static final Fraction MINUS_INFINITY = new Fraction(-ONE, ZERO);

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    private Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }
    public static Fraction createFraction(int nominator, int denominator) {
        if(denominator == ZERO) {
            return PLUS_INFINITY;
        }
        if(nominator == ZERO) {
            return NULL;
        }
        return new Fraction(nominator, denominator);
    }

    public Fraction plus(Fraction fraction) {
        int resultNominator = this.nominator* fraction.denominator + fraction.nominator*this.denominator;
        int resultDenominator = this.denominator * fraction.denominator;
        return simplifiedFraction(resultNominator, resultDenominator);
    }

    public Fraction minus(Fraction fraction) {
        if(isInfinityMinusInfinity(fraction)) {
            throw new IllegalArgumentException("Infinity minus infinity is mathematically undetermined.");
        }
        if(isSomethingMinusInfinity(fraction)) {
            return MINUS_INFINITY;
        }
        int nominator = this.nominator * fraction.denominator - fraction.nominator * this.denominator;
        int denominator = this.denominator * fraction.denominator;
        return simplifiedFraction(nominator, denominator);
    }

    private static boolean isSomethingMinusInfinity(Fraction fraction) {
        return fraction.getDenominator() == ZERO;
    }

    private boolean isInfinityMinusInfinity(Fraction fraction) {
        return fraction.getDenominator() == ZERO && this.denominator == ZERO;
    }

    private Fraction simplifiedFraction(int nominator, int denominator) {
        int pgcd = getPgcd(nominator, denominator);
        return  createFraction(nominator/pgcd, denominator/pgcd);
    }


    private int getPgcd(int numerator, int denominator) {
        if (denominator == ZERO) {
            return numerator;
        }
        return getPgcd(denominator, numerator % denominator);
    }
}
