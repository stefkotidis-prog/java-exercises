# Java Programming Exercises

A collection of Java exercises ranging from basic syntax to object-oriented programming (OOP). This repository includes programs for practicing core Java concepts, logic, and for basic user interface development.

## Project Highlights

| File / Folder | Core Concepts | Description |
| :--- | :--- | :--- |
| **`UniversitySystem/`** <br>*(Student, UnderStudent, GradStudent, ExamsTest2)* | OOP, Inheritance, Polymorphism | **University Grading System:** A grading system demonstrating class inheritance, method overriding, and polymorphic arrays. Uses `instanceof` to check graduation eligibility. |
| **`InsuranceApp/`** | OOP, Inheritance, Downcasting | **Insurance Management System:** A CLI application simulating an insurance database. Uses inheritance and object downcasting to manage customer policies. |
| **`AtmSimulator/`** <br>*(Atm, OptionMenu)* | OOP, Encapsulation, Exception Handling | **ATM Terminal Simulator:** Includes login validation, checking and savings accounts, standard transactions, and `try-catch` blocks for input error handling. |
| **`MusicManager/`** <br>*(Menu, Singer, Song)* | OOP, Static Members, Arrays | **Music Management System:** A CLI application to manage singers and their songs. Uses object linking, static arrays, and terminal menus. |
| **`GameUI.java`** & **`BinaryEngine.java`** | Swing GUI, Logic | **Binary Game:** A simple Swing GUI application where users toggle bit tiles to match a target decimal number. |
| **`SlotMachine.java`** | CLI, Arrays, Exception Handling | **Slot Machine Simulator:** A terminal-based betting game featuring dynamic payout calculations using switch expressions, random symbol array generation, and rigorous input validation. |
| **`Canteen.java`** | CLI Menus, Input Validation | **Canteen Ordering System:** A terminal-based ordering system featuring user input validation, an undo function, discount calculation, and receipt printing. |
| **`DeckOfCards.java`** | OOP, Arrays | **Deck Simulation:** Simulates a standard 52-card deck. Includes a custom `Card` class and a basic array shuffling algorithm. |
| **`DiceSimulator.java`** | Arrays, Loops | **Dice Statistics:** Simulates rolling two dice 36,000 times, tracks sum frequencies using arrays, and prints a terminal-based histogram. |
| **`ResponseTracker.java`** | Array Indexing | **Frequency Tracker:** Uses direct array indexing to count and store data frequencies instead of nested loops. |

## Tech Stack

* **Language:** Java 17+
* **Frameworks:** Java Swing (Standard Library)
* **Environment:** Command Line & Graphical User Interface
* **Key Skills:** OOP (Inheritance, Polymorphism), Exception Handling, Arrays, GUI Basics

## How to Run

### 1. Single-File Terminal Programs
To run standard logic exercises, compile and execute the specific file from your terminal:
```bash
javac FileName.java
java FileName
```

### 2. Multi-File Projects (Folders)
For projects organized in folders containing multiple interconnected files (e.g., `UniversitySystem/` or `AtmSimulator/`), navigate into the specific project directory, compile all `.java` files together, and run the file containing the main method:
```bash
cd ProjectFolderName
javac *.java
java MainClassName
```
