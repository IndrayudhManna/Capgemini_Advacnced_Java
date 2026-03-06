package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTesting3 {
    @ParameterizedTest
    @CsvSource({
            "10,12,22",
            "abc,15,20",
            "'12',15,27",
            "2,5,10"
    })
    void addTest(String a, String b, double exp) {
        Calc calc = new Calc();

        try {
            double res = calc.add(a, b);  // ❌ Throws exception
            assertEquals(exp, res);  // ⛔ SKIPPED
        } catch (IllegalArgumentException e) {
            // ✅ THIS RUNS
            System.out.println("Exception message: " + e.getMessage());
            assertEquals("Enter Numbers", e.getMessage());  // ✅ PASSES
            // Test passes because exception was caught and message matches
        }
    }
}