# Java Programming Exercises

A collection of Java exercises ranging from basic syntax to object-oriented programming (OOP), custom data structures, multithreading, file persistence, and basic GUI development.

## Project Highlights

| Module | Core Concepts | Description |
| :--- | :--- | :--- |
| **`SmartParkingSystem/`** <br>*(model, service, storage, exception, Main)* | Layered Architecture, OOP, Enums, Custom Exceptions, File I/O | **Smart Parking System:** A multi-package CLI parking management application structured into `model`, `service`, `storage`, and `exception` layers. Handles vehicle types (`Car`, `Motorcycle`, `Truck`), ticket pricing, reporting, and file-based persistence. |
| **`TicketBookingSimulator/`** <br>*(TicketCounter, CustomerTask, Main)* | Multithreading, `Runnable`, `synchronized`, `join()` | **Ticket Booking Simulator:** A concurrent CLI simulation of multiple customers booking tickets simultaneously. Demonstrates thread creation, race condition prevention using `synchronized`, and thread coordination via `join()`. |
| **`GenericLinkedList/`** <br>*(CustomLinkedList, Main)* | Generics (`<E>`), Recursion, Data Structures | **Generic Linked List:** An immutable singly linked list implemented from scratch using Java Generics. Includes recursive `toString`, `size`, `contains`, `get`, and `reverse` operations. |
| **`HoopsTrainingTracker/`** <br>*(Athlete, BasketballPlayer, TrainingSession, RosterManager, Main)* | OOP, Inheritance, ArrayLists, Exception Handling | **Hoops Training Tracker:** A CLI application managing a basketball team roster. Tracks player stats (like vertical jump), records training sessions via object composition, and features an interactive menu with input validation. |
| **`EcommercePricing/`** <br>*(PricedItem, Discountable, ProductBundle, StandardProduct, ClearanceProduct, Main)* | Interfaces, Multiple Implementation, Inheritance, Method Overriding | **E-commerce Pricing System:** An OOP-based system calculating product prices and applying coupons using interfaces. Demonstrates multiple interface implementation, class inheritance, and static counters. |
| **`UniversitySystem/`** <br>*(Student, UnderStudent, GradStudent, ExamsTest2)* | OOP, Inheritance, Polymorphism | **University Grading System:** A grading system demonstrating class inheritance, method overriding, and polymorphic arrays. Uses `instanceof` to check graduation eligibility. |
| **`InsuranceApp/`** <br>*(Customer, Insurance, Health, Life)* | OOP, Inheritance, Downcasting | **Insurance Management System:** A CLI application simulating an insurance database. Uses inheritance and object downcasting to manage customer policies. |
| **`AtmSimulator/`** <br>*(Atm, OptionMenu)* | OOP, Encapsulation, Exception Handling | **ATM Terminal Simulator:** Includes login validation, checking and savings accounts, standard transactions, and `try-catch` blocks for input error handling. |
| **`MusicManager/`** <br>*(Menu, Singer, Song)* | OOP, Static Members, Arrays | **Music Management System:** A CLI application to manage singers and their songs. Uses object linking, static arrays, and terminal menus. |
| **`BinaryGame/`** <br>*(GameUI, BinaryEngine)* | Swing GUI, Logic | **Binary Game:** A simple Swing GUI application where users toggle bit tiles to match a target decimal number. |
| **`CanteenSystem/`** <br>*(Canteen, Product)* | CLI Menus, OOP, Input Validation | **Canteen Ordering System:** A terminal-based ordering system featuring user input validation, an undo function, discount calculation, and receipt printing. |
| **`SlotMachine/`** <br>*(SlotMachine)* | CLI, Arrays, Exception Handling | **Slot Machine Simulator:** A terminal-based betting game featuring dynamic payout calculations using switch expressions, random symbol array generation, and input validation. |
| **`DeckSimulation/`** <br>*(DeckOfCards)* | OOP, Arrays | **Deck Simulation:** Simulates a standard 52-card deck. Includes a custom `Card` class and a basic array shuffling algorithm. |
| **`DiceSimulation/`** <br>*(DiceSimulator)* | Arrays, Loops | **Dice Statistics:** Simulates rolling two dice 36,000 times, tracks sum frequencies using arrays, and prints a terminal-based histogram. |

## Tech Stack

* **Language:** Java 17+
* **Build Tool:** Apache Maven (Multi-Module)
* **Frameworks:** Java Swing (Standard Library)
* **Environment:** Command Line & Graphical User Interface
* **Key Skills:** OOP (Inheritance, Polymorphism, Interfaces), Generics, Recursion, Multithreading & Synchronization, File I/O, Custom Exceptions, GUI Basics

## Build Instructions

This repository is structured as a **Maven Multi-Module Project**.

To compile all modules simultaneously from the root directory:
```bash
mvn clean package
```

To run a specific module configured with exec-maven-plugin (e.g., TicketBookingSimulator or GenericLinkedList):
```