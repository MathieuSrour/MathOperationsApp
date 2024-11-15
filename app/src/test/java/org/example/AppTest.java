package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testAddition() {
        double a = 10.5;
        double b = 4.5;
        assertEquals(15.0, a + b, 0.01);
    }
}
