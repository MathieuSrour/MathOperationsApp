package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testAddition() {
        double result = App.calculate(10, "+", 5);
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = App.calculate(20, "-", 8);
        assertEquals(12.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = App.calculate(7, "*", 6);
        assertEquals(42.0, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = App.calculate(50, "/", 5);
        assertEquals(10.0, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        //String[] args = {"10", "/", "0"};
        //String output = executeApp(args);
        //assertTrue(output.contains("Error: Division by zero is not allowed."));

        Exception exception = assertThrows(ArithmeticException.class, () -> App.calculate(10, "/", 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testInvalidOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> App.calculate(10, "x", 5));
        assertEquals("Invalid operation. Use +, -, *, or /.", exception.getMessage());
    }

    @Test
    public void testInvalidNumber() throws UnsupportedEncodingException {
        String[] args = {"abc", "+", "5"};
        String output = executeApp(args);
        
        assertTrue(output.contains("Error: Both number1 and number2 must be valid numbers."));
    }

    @Test
    public void testMissingArguments() throws UnsupportedEncodingException {
        String[] args = {"10", "+"};
        String output = executeApp(args);
        assertTrue(output.contains("Usage: java -jar App.jar <number1> <operation> <number2>"));
    }

    @Test
    public void testTooManyArguments() throws UnsupportedEncodingException {
        String[] args = {"10", "+", "5", "extra"};
        String output = executeApp(args);
        assertTrue(output.contains("Usage: java -jar App.jar <number1> <operation> <number2>"));
    }

    /**
     * Helper method to execute the App.main method and capture its output.
     *
     * @param args Command-line arguments to pass to App.main
     * @return Captured output as a string
     * @throws UnsupportedEncodingException 
     */
    private String executeApp(String[] args) throws UnsupportedEncodingException {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8.name()));
    
        try {
            App.main(args);
        } finally {
            System.setOut(originalOut);
        }
    
        String output = outputStream.toString(StandardCharsets.UTF_8.name());
        System.out.println("Captured Output: " + output); // Debugging
        return output;
    }
}
