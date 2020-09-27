package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersDatabaseTest {
    private UsersDatabase database;

    @BeforeEach
    void before() {
        this.database = new UsersDatabase();
    }

    @Test
    void findUserIdByAnyProperFractionChecker() {
        Stream<String> expected = Stream.of("1","2","3","5");
        assertEquals(expected.collect(Collectors.toList()),
                this.database.findUserIdByAnyProperFraction().collect(Collectors.toList()));
    }

    @Test
    void findFractionMultiplicationByUserFamilyNameChecker() {
        Fraction expectedFraction = new Fraction(0,1);
        assertEquals(expectedFraction.getNumerator(),
                this.database.findFractionMultiplicationByUserFamilyName("Fernandez").getNumerator());
        assertEquals(expectedFraction.getDenominator(),
                this.database.findFractionMultiplicationByUserFamilyName("Fernandez").getDenominator());
    }

    @Test
    void findFractionDivisionByUserIdChecker() {
        Fraction expectedFraction = new Fraction(-6,15);
        assertEquals(expectedFraction.getNumerator(),
                this.database.findFractionDivisionByUserId("3").getNumerator());
        assertEquals(expectedFraction.getDenominator(),
                this.database.findFractionDivisionByUserId("3").getDenominator());
    }

    @Test
    void findFirstFractionSubtractionByUserNameChecker() {
        Fraction expectedFraction = new Fraction(22,60);
        assertEquals(expectedFraction.getNumerator(),
                this.database.findFirstFractionSubtractionByUserName("Ana").getNumerator());
        assertEquals(expectedFraction.getDenominator(),
                this.database.findFirstFractionSubtractionByUserName("Ana").getDenominator());
    }
}
