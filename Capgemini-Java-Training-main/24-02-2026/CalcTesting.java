package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcTesting{
    @ParameterizedTest
        @CsvSource(
                {

                        "10,20,30",
                        "5,7,12",
                        "5.1,4.9,10"


                }

        )

        void addTest(String a,String b, double expected){
            Calc calc = new Calc();//auto converts to double
                                    //we need to  take String as input cuz even if it is wrong
                                    //it at least takes the input so it can check the error
            double result = calc.add(a,b);
            assertEquals(expected,result);





//    @Test
//    void addInvalidStringTest(){//checks for error
//        Calc calc = new Calc(); //will show CORRECT if error is found
//        assertThrows(IllegalArgumentException.class,
//                () -> calc.add("11","abc"));



//
//    @ParameterizedTest
//        @CsvSource(
//                {
//                "10,ji,30",
//                "20,hb,50",
//                "sv,20,70"
//
//        }
//        )
//    void addInvalidString(String a,String b){
//        Calc calc = new Calc();
//        assertThrows(IllegalArgumentException.class,
//                () -> calc.add(a,b));
}

}
