package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple command-line application for performing basic mathematical operations.
 * Supported operations: addition, subtraction, multiplication, and division.
 */

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    /**
     * The main method that serves as the entry point for the application.
     *
     * @param args Command-line arguments: number1, operation (+, -, *, /), and number2.
     */
    
    public static void main(String[] args) {
        if (args.length != 3) {
            logger.error("Invalid number of arguments. Expected 3, got {}", args.length);
            System.out.println("Usage: java -jar App.jar <number1> <operation> <number2>");
            System.out.println("Example: java -jar App.jar 10 + 5");
            return;
        }
        
        try {
            // Parse the arguments
            double number1 = Double.parseDouble(args[0]);
            String operation = args[1];
            double number2 = Double.parseDouble(args[2]);
            double result = calculate(number1, operation, number2);

            // Print the result
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", number1, operation, number2, result);
            logger.info("Operation successful. Result: {} {} {} = {}", number1, operation, number2, result);
        } catch (NumberFormatException e) {
            logger.warn("Invalid number format: {}", e.getMessage());
            System.out.println("Error: Both number1 and number2 must be valid numbers.");
        } catch (Exception e) {
            logger.error("Error occurred: {}", e.getMessage(), e);
            System.out.println("Error: " + e.getMessage());
        }
        logger.info("Application terminated.");
        
    }
    
    /**
     * Performs the specified mathematical operation on two numbers.
     *
     * @param number1  The first number.
     * @param operation The operation to perform (+, -, *, /).
     * @param number2  The second number.
     * @return The result of the operation.
     * @throws ArithmeticException If division by zero is attempted.
     * @throws IllegalArgumentException If the operation is invalid.
     */
    
    public static double calculate (double number1, String operation, double number2) {
        double result;
        switch (operation) {
            case "+":
                result = number1 + number2;
                logger.debug("Addition performed: {} + {} = {}", number1, number2, result);
                return result;
            case "-":
                result = number1 - number2;
                logger.debug("Subtraction performed: {} - {} = {}", number1, number2, result);
                return result;
            case "*":
                result = number1 * number2;
                logger.debug("Multiplication performed: {} * {} = {}", number1, number2, result);
                return result;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result = number1 / number2;
                logger.debug("Division performed: {} / {} = {}", number1, number2, result);
                return result;
            default:
                throw new IllegalArgumentException("Invalid operation. Use +, -, *, or /.");
        }
    }
    
}
