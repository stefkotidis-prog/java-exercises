# Java Programming Exercises ☕

A collection of Java standalone programs and logic challenges ranging from basic syntax to object-oriented programming (OOP). This repository serves as a sandbox for practicing core Java concepts, algorithm optimization, and interactive UI development.

## 📁 Project Highlights

| File / Folder | Core Concepts | Description |
| :--- | :--- | :--- |
| **`Canteen.java`** | CLI Menus, Input Validation, Business Logic | **Canteen Ordering System:** An interactive terminal-based point-of-sale (POS) system. Features robust user input validation (`Scanner` checks), an undo function for the last item added, stacked dynamic discount logic (capped at 15%), a payment handling loop, and formatted receipt generation. |
| **`MusicManager/`** <br>*(Menu, Singer, Song)* | OOP, Static Members, Array Management | **Music Management System:** A CLI application to manage singers and their discography. Demonstrates object linking, static arrays across classes, and interactive terminal menus using `Scanner` loops. |
| **`InsuranceApp/`** | OOP, Inheritance, Downcasting | **Insurance Management System:** A multi-file CLI application simulating an insurance database. Uses inheritance (`Life` and `Health` extending `Insurance`) and object downcasting (`instanceof`) to manage and search customer policies. |
| **`GameUI.java`** & **`BinaryEngine.java`** | Swing GUI, Binary Logic | **Binary Master:** An interactive 8-bit game. Users toggle bit tiles (0/1) to match a random target decimal number. Features real-time sum calculation and visual feedback. |
| **`DiceSimulator.java`** | Statistics, Array Indexing | Rolls two dice 36,000 times and tracks the sum frequencies using direct array access. Outputs a terminal-based bell curve histogram. |
| **`DeckOfCards.java`** | OOP, Arrays, Algorithms | Simulates a standard 52-card deck. Includes custom object creation (`Card` class) and implements a Fisher-Yates style shuffling algorithm. |
| **`ResponseTracker.java`** | Data Mapping | Demonstrates efficient data tracking by replacing nested loops with zero-based direct array indexing for frequency counting. |

## 🛠️ Tech Stack
* **Language:** Java 17+
* **Frameworks:** Java Swing (Standard Library)
* **Environment:** Command Line & Graphical User Interface (GUI)
* **Key Skills:** OOP Architecture (Inheritance, Polymorphism), GUI Event Handling, Binary Math, Array Indexing, and Logic Optimization.

## 🚀 How to Run

### 1. Single-File Terminal Programs
To run standard logic exercises, compile and execute the specific file:
```bash
javac FileName.java
java FileName
