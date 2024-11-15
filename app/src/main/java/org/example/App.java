package org.example;

import org.apache.commons.math3.util.Precision;

public class App {
    public static void main(String[] args) {
        double a = 15.7;
        double b = 3.2;
        System.out.println("Addition: " + Precision.round(a + b, 2));
        System.out.println("Subtraction: " + Precision.round(a - b, 2));
        System.out.println("Multiplication: " + Precision.round(a * b, 2));
        System.out.println("Division: " + Precision.round(a / b, 2));
    }
}
