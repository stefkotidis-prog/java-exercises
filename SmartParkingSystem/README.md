# Smart Parking System

A Java CLI application for managing parking operations.

## Features
- Vehicle management using inheritance and polymorphism
- Parking capacity and spot allocation
- Ticket generation and vehicle entry/exit
- Dynamic pricing based on duration and vehicle type
- File-based persistence
- Revenue and occupancy reports
- Custom exceptions and input validation
- Unit testing

## Project Structure
- model: Domain classes
- service: Parking and pricing business logic
- storage: File persistence
- exception: Custom exceptions
- Main.java: CLI entry point

## Requirements
- Java 17+
- No external dependencies for the initial version

## Run
Compile and run the application using javac or an IDE.

## Development Milestones
1. Implement the domain model.
2. Implement parking entry and exit.
3. Implement pricing rules.
4. Implement file persistence.
5. Implement reports and tests.

## Business Rules
- A vehicle cannot enter twice while already parked.
- A vehicle cannot exit without a valid active ticket.
- Parking capacity cannot be exceeded.
- Parking fees must never be negative.
- Invalid input must be handled safely.
- Data should persist between application runs.

