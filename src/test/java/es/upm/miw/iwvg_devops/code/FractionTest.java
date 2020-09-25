package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before () {
        this.fraction = new Fraction();
    }

    @Test
    void createFraction() {
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(1, this.fraction.getDenominator());
    }

    @Test
    void checkSetNumerator() {
        this.fraction.setNumerator(3);
        assertEquals(3, this.fraction.getNumerator());
    }

    @Test
    void checkSetDenominator() {
        this.fraction.setDenominator(3);
        assertEquals(3, this.fraction.getDenominator());
    }

    @Test
    void checkDecimal() {
        this.fraction.setNumerator(4);
        this.fraction.setDenominator(2);
        assertEquals(2, this.fraction.decimal());
    }

    @Test
    void checkIsProper() {
        this.fraction.setNumerator(2);
        this.fraction.setDenominator(4);
        assertEquals(true, this.fraction.isProper());
    }

    @Test
    void checkIsImproper() {
        this.fraction.setNumerator(4);
        this.fraction.setDenominator(2);
        assertEquals(true, this.fraction.isImproper());
    }

    @Test
    void checkIsEquivalent() {
        Fraction equivalent = new Fraction(6, 3);
        this.fraction.setNumerator(4);
        this.fraction.setDenominator(2);
        assertEquals(true, this.fraction.isEquivalent(equivalent));
    }

    @Test
    void checkMCD() {
        assertEquals(5, this.fraction.MCD(10, 15));
    }

    @Test
    void checkMCM() {
        assertEquals(30, this.fraction.MCM(10, 15));
    }

    @Test
    void checkAddFraction() {
        this.fraction.setNumerator(5);
        this.fraction.setDenominator(10);
        this.fraction.add(new Fraction(6, 15));

        assertEquals(27, this.fraction.getNumerator());
        assertEquals(30, this.fraction.getDenominator());
    }

    @Test
    void checkDivideFraction() {
        this.fraction.setNumerator(5);
        this.fraction.setDenominator(10);
        this.fraction.divide(new Fraction(6, 15));

        assertEquals(75, this.fraction.getNumerator());
        assertEquals(60, this.fraction.getDenominator());
    }
}
