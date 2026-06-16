# Java Programming Exercises

A collection of Java exercises ranging from basic syntax to object-oriented programming (OOP). This repository contains standalone programs for practicing core Java concepts, logic, and basic UI development.

## Project Highlights

| File / Folder | Core Concepts | Description |
| :--- | :--- | :--- |
| **`Canteen.java`** | CLI Menus, Input Validation, Basic Logic | **Canteen Ordering System:** A terminal-based ordering system. Includes user input validation with `Scanner`, an undo function, discount calculation, and receipt printing. |
| **`MusicManager/`** <br>*(Menu, Singer, Song)* | OOP, Static Members, Arrays | **Music Management System:** A CLI application to manage singers and their songs. Uses object linking, static arrays, and terminal menus. |
| **`InsuranceApp/`** | OOP, Inheritance, Downcasting | **Insurance Management System:** A CLI application simulating an insurance database. Uses inheritance (`Life` and `Health` extending `Insurance`) and object downcasting (`instanceof`) to manage customer policies. |
| **`UniversitySystem/`** <br>*(Student, UnderStudent, GradStudent, ExamsTest2)* | OOP, Inheritance, Polymorphism | **University Grading System:** A grading system demonstrating class inheritance, method overriding (`calcGrade`, `toString`), and polymorphic arrays. Uses `instanceof` to check graduation eligibility. |
| **`AtmSimulator/`** <br>*(Atm, OptionMenu)* | OOP, Encapsulation, Exception Handling | **ATM Terminal Simulator:** An ATM simulator. Includes login validation, checking and savings accounts, standard transactions, and `try-catch` blocks for input error handling. |
| **`GameUI.java`** & **`BinaryEngine.java`** | Swing GUI, Logic | **Binary Game:** A simple Swing GUI application where users toggle bit tiles (0/1) to match a target decimal number. |
| **`DiceSimulator.java`** | Arrays, Loops | Simulates rolling two dice 36,000 times and tracks the sum frequencies using arrays. Prints a terminal-based histogram. |
| **`DeckOfCards.java`** | OOP, Arrays | Simulates a standard 52-card deck. Includes a custom `Card` class and a basic array shuffling algorithm. |
| **`ResponseTracker.java`** | Array Indexing | Uses direct array indexing to count and store data frequencies instead of nested loops. |

## Tech Stack
* **Language:** Java 17+
* **Frameworks:** Java Swing (Standard Library)
* **Environment:** Command Line & Graphical User Interface (GUI)
* **Key Skills:** OOP (Inheritance, Polymorphism), Exception Handling, Arrays, GUI Basics.

## How to Run

### 1. Single-File Terminal Programs
To run standard logic exercises, compile and execute the specific file:
```bash
javac FileName.java
java FileName
