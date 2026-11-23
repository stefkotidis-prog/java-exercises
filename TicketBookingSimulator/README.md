# Ticket Booking Simulator

A Java multithreading exercise simulating concurrent ticket bookings. Demonstrates thread creation, race condition prevention using `synchronized`, and thread coordination with `join()`.

## Core Concepts

* `Thread` & `Runnable`
* `synchronized` methods (preventing overselling / race conditions)
* `Thread.sleep()` & `Thread.join()`

## Project Structure

```text
TicketBookingSimulator/
├── pom.xml
└── src/
    ├── TicketCounter.java
    ├── CustomerTask.java
    └── Main.java
```

## How to Run
```bash
mvn compile -pl TicketBookingSimulator
mvn exec:java -pl TicketBookingSimulator
```

