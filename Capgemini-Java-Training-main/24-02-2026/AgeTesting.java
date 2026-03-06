package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AgeTesting
{@ParameterizedTest
    @CsvSource({

            "True,'Success'",
            "'20','Success'",
            "-10,'Too low'",
            "150,'Too high'",
            "'abc','Success'"

    })

    void checking(String a,String exp){
    Age b=new Age();
    try {
        String s=b.age(a);
        assertEquals(exp,s);
    }catch(IllegalArgumentException e){
        System.out.println("Enter a valid number");
        assertEquals("Enter Numbers", e.getMessage());
    }
}
}
