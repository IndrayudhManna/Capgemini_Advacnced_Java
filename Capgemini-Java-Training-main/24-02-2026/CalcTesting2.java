package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalcTesting2 {

    @ParameterizedTest
    @CsvSource({
            "10,12,22",   // Valid & Correct
            "5,6,11"      // Valid & Correct
    })
    void testValidAndCorrect(double a, double b, double expected) {
        Calc calc = new Calc();
        double result = calc.add(a, b);
        assertEquals(expected, result, "Valid & Correct");
    }

    @ParameterizedTest
    @CsvSource({
            "10,12,25",   // Valid but Incorrect (10+12=22, not 25)
            "5,6,20"      // Valid but Incorrect (5+6=11, not 20)
    })
    void testValidButIncorrect(double a, double b, double expected) {
        Calc calc = new Calc();
        double result = calc.add(a, b);
        assertNotEquals(expected, result, "Valid but Incorrect");
        // Or use assertThrows if you want to check it DOESN'T throw
    }

    @ParameterizedTest
    @CsvSource({
            "10, ji",
            "abc, 20",
            "!, 30"
    })
    void testInvalid(String a, String b) {
        Calc calc = new Calc();
        assertThrows(IllegalArgumentException.class,
                () -> calc.add(a, b),
                "Invalid - Exception thrown");
    }
}