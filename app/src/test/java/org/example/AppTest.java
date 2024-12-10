package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testAddition() {
        String[] args = {"10", "+", "5"};
        String output = executeApp(args);
        assertTrue(output.trim().contains("Result: 10,00 + 5,00 = 15,00"));
    }

    @Test
    public void testSubtraction() {
        String[] args = {"20", "-", "8"};
        String output = executeApp(args);
        assertTrue(output.contains("Result: 20,00 - 8,00 = 12,00"));
    }

    @Test
    public void testMultiplication() {
        String[] args = {"7", "*", "6"};
        String output = executeApp(args);
        assertTrue(output.contains("Result: 7,00 * 6,00 = 42,00"));
    }

    @Test
    public void testDivision() {
        String[] args = {"50", "/", "5"};
        String output = executeApp(args);
        assertTrue(output.contains("Result: 50,00 / 5,00 = 10,00"));
    }

    @Test
    public void testDivisionByZero() {
        String[] args = {"10", "/", "0"};
        String output = executeApp(args);
        assertTrue(output.contains("Error: Division by zero is not allowed."));
    }

    @Test
    public void testInvalidOperation() {
        String[] args = {"10", "x", "5"};
        String output = executeApp(args);
        assertTrue(output.contains("Error: Invalid operation. Use +, -, *, or /."));
    }

    @Test
    public void testInvalidNumber() {
        String[] args = {"abc", "+", "5"};
        String output = executeApp(args);
        assertTrue(output.contains("Error: Both number1 and number2 must be valid numbers."));
    }

    @Test
    public void testMissingArguments() {
        String[] args = {"10", "+"};
        String output = executeApp(args);
        assertTrue(output.contains("Usage: java -jar App.jar <number1> <operation> <number2>"));
    }

    @Test
    public void testTooManyArguments() {
        String[] args = {"10", "+", "5", "extra"};
        String output = executeApp(args);
        assertTrue(output.contains("Usage: java -jar App.jar <number1> <operation> <number2>"));
    }

    /**
     * Helper method to execute the App.main method and capture its output.
     *
     * @param args Command-line arguments to pass to App.main
     * @return Captured output as a string
     */
    private String executeApp(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    
        try {
            App.main(args);
        } finally {
            System.setOut(originalOut);
        }
    
        String output = outputStream.toString();
        System.out.println("Captured Output: " + output); // Debugging
        return output;
    }
}
