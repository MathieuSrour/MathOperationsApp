# Math Operations App Tutorial

Welcome to the **Math Operations App Tutorial**! This tutorial will guide you step-by-step through downloading, running, and using the app to perform basic mathematical operations.

---

## Prerequisites

Before starting, ensure you have the following installed on your system:
- **Java**: JDK 11 or later.
- **Gradle**: Installed for building the project. [Installation Guide](https://gradle.org/install/).

---

## Step 1: Download the Project

1. Clone the repository from GitHub:
   ```bash
   git clone https://github.com/MathieuSrour/MathOperationsApp.git
   cd MathOperationsApp
   ```

2. Verify the project directory contains the following structure:
   ```
   MathOperationsApp/
   ├── app/
   ├── build.gradle.kts
   ├── settings.gradle.kts
   ├── src/
   ├── README.md
   └── docs/
   ```

---

## Step 2: Build the Project

1. Clean and build the project using Gradle:
   ```bash
   gradle clean build shadowJar
   ```

2. Verify that the build was successful. The output should indicate `BUILD SUCCESSFUL`.

3. Locate the generated JAR file:
   ```
   build/libs/App-1.0.0.jar
   ```

---

## Step 3: Run the Application

1. Execute the application with the following syntax:
   ```bash
   java -jar build/libs/App-1.0.0.jar <number1> <operation> <number2>
   ```

2. Example:
   ```bash
   java -jar build/libs/App-1.0.0.jar 10 + 5
   ```
   Output:
   ```
   Result: 10.00 + 5.00 = 15.00
   ```

---

## Step 4: Explore Logging

The app uses **Log4j** to log important events. Logs are stored in `logs/app.log`. Follow these steps to check the logs:

1. Open the `logs/app.log` file:
   ```bash
   cat logs/app.log
   ```

2. Example log output:
   ```
   2024-12-10 15:30:45 [main] INFO  org.example.App - Application started with arguments: [10, +, 5]
   2024-12-10 15:30:45 [main] DEBUG org.example.App - Addition performed: 10.0 + 5.0 = 15.0
   2024-12-10 15:30:45 [main] INFO  org.example.App - Operation successful. Result: 10.0 + 5.0 = 15.0
   2024-12-10 15:30:45 [main] INFO  org.example.App - Application terminated.
   ```

---

## Step 5: Experiment with Different Operations

Try different operations:
- Subtraction: `java -jar build/libs/App-1.0.0.jar 20 - 8`
- Multiplication: `java -jar build/libs/App-1.0.0.jar 7 * 6`
- Division: `java -jar build/libs/App-1.0.0.jar 50 / 5`

### Invalid Inputs
- Division by zero:
   ```bash
   java -jar build/libs/App-1.0.0.jar 10 / 0
   ```
   Output:
   ```
   Error: Division by zero is not allowed.
   ```

- Invalid operation:
   ```bash
   java -jar build/libs/App-1.0.0.jar 10 x 5
   ```
   Output:
   ```
   Error: Invalid operation. Use +, -, *, or /.
   ```

---

## Step 6: Modify and Test the Code

1. Open the `App.java` file in your favorite IDE (e.g., VS Code).
2. Make changes to the logic or add new features.
3. Run the tests to ensure the app works as expected:
   ```bash
   gradle test
   ```

4. Check the test report at:
   ```
   build/reports/tests/test/index.html
   ```

---

Congratulations! You've successfully completed this tutorial and now have a working Math Operations App.

For additional help, refer to:
- [Project README](../../README.md)
- [Log4j Documentation](https://logging.apache.org/log4j/2.x/)

---
