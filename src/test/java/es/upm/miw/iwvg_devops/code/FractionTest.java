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
}
