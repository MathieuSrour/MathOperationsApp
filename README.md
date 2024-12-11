# Math Operations App

The **Math Operations App** is a simple command-line application designed to perform basic mathematical operations such as addition, subtraction, multiplication, and division. It enables users to provide inputs directly from the command line, making calculations fast and straightforward.

---

## Description
This repository contains the source code and configurations for the **Math Operations App**, a Java-based application built using Gradle. The app features structured logging, unit testing, and a well-defined architecture to simplify its use and maintenance.

---

## Usage
The application takes three arguments:
1. A number.
2. An operator (`+`, `-`, `*`, or `/`).
3. Another number.

It then performs the requested operation and displays the result. The app also includes robust error handling for invalid inputs or operations, with detailed logs and error messages.

---

This repository is suitable for:
- Developers learning Java and Gradle.
- Students or individuals looking for a basic yet functional calculator example.
- Engineers needing a template for building and debugging small Java-based CLI tools.



---

## Installation, Building and Testing The Project

### Clone the Repository
```bash
git clone https://github.com/<your-username>/MathOperationsApp.git
cd MathOperationsApp
```

### Build the Project
To build the application:
```bash
gradle clean clean shadowjar
```

### Run the Application
To execute the program:
```bash
java -jar build/libs/App-1.0.0.jar <number1> <operation> <number2>
```
Example:
```bash
java -jar build/libs/App-1.0.0.jar 10 + 5
```

### Run Unit Tests
To run the tests and verify functionality:
```bash
gradle test
```

---

## Contribution
You can contribute to this project by:
1. Reporting issues via GitHub's "Issues" tab.
2. Suggesting features or improvements.
3. Submitting pull requests with bug fixes, enhanced functionality, or documentation updates.
4. Writing additional test cases to improve test coverage.

---

## License
This project is licensed under the **MIT License**. See the [LICENSE](https://github.com/MathieuSrour/MathOperationsApp/blob/main/LICENSE.txt) file for more details.

---

## Contact Information
- **Email**: mathieu.srour4@gmail.com
- **GitHub Repository**: [Math Operations App](https://github.com/MathieuSrour/MathOperationsApp.git)
- For questions or issues, please open a ticket in the GitHub Issues tab.

---

