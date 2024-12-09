# Math Operations App

A simple command-line application that performs basic mathematical operations (addition, subtraction, multiplication, division) using numbers provided directly via command-line arguments. Built using Java and Gradle.

---

## Features
- **Command-Line Arguments**: Input two numbers and an operation directly on the command line for instant results.
- **Dependency Management**: Uses Apache Commons Math for precision rounding.
- **Error Handling**: Provides meaningful error messages for invalid input or unsupported operations.
- **Automated Build and Run**: Managed entirely with Gradle.

---

## Prerequisites
- **Java Development Kit (JDK)**: Version 11 or later.
- **Gradle**: Installed on your system. [Installation guide](https://gradle.org/install/).

---

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/MathieuSrour/MathOperationsApp.git
cd MathOperationsApp
```

### Build the Project
To compile the application and resolve dependencies:
```bash
gradle build
```

### Run the Application
To execute the program interactively:
```bash
java -jar app/build/libs/App-1.0.0.jar <number1> <operation> <number2>
```

### Create a Deployable JAR
To package the application as a JAR file:
```bash
gradle jar
```
Run the JAR file:
```bash
java -jar app/build/libs/App-1.0.0.jar
```

---

## Project Structure

```
MathOperationsApp/
├── app/                     # Application-specific code and configuration
│   ├── src/                 # Source files
│   │   ├── main/            # Main application code
│   │   │   └── java/        # Java source files
│   │   │       └── org/
│   │   │           └── example/
│   │   │               └── App.java  # Main application class
│   │   └── test/            # Test files
│   │       └── java/
│   │           └── org/
│   │               └── example/
│   │                   └── AppTest.java  # Unit tests
│   ├──build.gradle.kts     # Gradle build configuration for the app module
│   └──config/
│      ├── checkstyle/ 
│      │   └──checkstyle.xml
│      └── pmd/
│          ruleset.xml
├── build/                   # Directory for build outputs (generated)
├── gradle/                  # Gradle wrapper files
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── .gitignore               # Files and directories to ignore in Git
├── gradlew                  # Gradle wrapper script for UNIX
├── gradlew.bat              # Gradle wrapper script for Windows
├── settings.gradle.kts      # Project-level Gradle configuration
└── README.md                # Project documentation
```

---

## How Gradle is Used in This Project

1. **Dependency Management**:
   - External libraries (e.g., Apache Commons Math) are automatically managed by Gradle.
   - Declared in `build.gradle.kts`:
     ```kotlin
     dependencies {
         implementation("org.apache.commons:commons-math3:3.6.1")
         testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
     }
     ```

2. **Compilation**:
   - Source code is automatically compiled during the `gradle build` process.
   - Manually trigger compilation with:
     ```bash
     gradle compileJava
     ```

3. **Version Management**:
   - The project version is defined in `build.gradle.kts`:
     ```kotlin
     version = "1.0.0"
     ```

4. **Packaging**:
   - Gradle generates a deployable JAR file using the `jar` task:
     ```bash
     gradle jar
     ```

---

## Testing
Unit tests are included and executed with Gradle:
```bash
gradle test
```

---

## Static Code Analysis

### Install and Run Analysis

1. **Checkstyle**:
   - Install Checkstyle by ensuring it is included in `build.gradle.kts`:
     ```kotlin
     plugins {
         id("checkstyle")
     }

     checkstyle {
         toolVersion = "10.12.0"
         configFile = file("config/checkstyle/checkstyle.xml")
     }
     ```
   - Run Checkstyle analysis:
     ```bash
     gradle checkstyleMain
     ```
   - Output:
     - Results are displayed in the console and saved as an HTML report in `build/reports/checkstyle/main.html`.

2. **PMD**:
   - Install PMD by ensuring it is included in `build.gradle.kts`:
     ```kotlin
     plugins {
         id("pmd")
     }

     pmd {
         toolVersion = "6.56.0"
         ruleSetFiles = files("config/pmd/ruleset.xml")
         isConsoleOutput = true
     }
     ```
   - Run PMD analysis:
     ```bash
     gradle pmdMain
     ```
   - Output:
     - Results are displayed in the console and saved as an HTML report in `build/reports/pmd/main.html`.

---
