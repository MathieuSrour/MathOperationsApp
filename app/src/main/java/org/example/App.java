package org.example;

public class App {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar App.jar <number1> <operation> <number2>");
            System.out.println("Example: java -jar App.jar 10 + 5");
            return;
        }
        
        try {
            // Parse the arguments
            double number1 = Double.parseDouble(args[0]);
            String operation = args[1];
            double number2 = Double.parseDouble(args[2]);
            double result;
            // Perform the operation
            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation. Use +, -, *, or /.");
            }

            // Print the result
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", number1, operation, number2, result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Both number1 and number2 must be valid numbers.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
    }
}
