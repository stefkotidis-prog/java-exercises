package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private BigDecimal fee;

    public ParkingTicket(String ticketId, Vehicle vehicle, LocalDateTime entryTime) {
        if (ticketId == null || ticketId.isBlank()) {
            throw new IllegalArgumentException("Ticket ID cannot be blank.");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (entryTime == null) {
            throw new IllegalArgumentException("Entry time cannot be null.");
        }
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.exitTime = null;
        this.fee = null;
    }

    public ParkingTicket(String ticketId, Vehicle vehicle, LocalDateTime entryTime, LocalDateTime exitTime, BigDecimal fee) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public boolean isActive() {
        return exitTime == null && fee == null;
    }

    public Duration getParkingDuration(LocalDateTime referenceTime) {
        if (referenceTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("Reference time cannot precede entry time.");
        }
        return Duration.between(entryTime, referenceTime);
    }

    public void complete(LocalDateTime exitTime, BigDecimal fee) {
        if (!isActive()) {
            throw new IllegalStateException("Ticket has already been completed.");
        }
        if (exitTime == null || exitTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("Exit time cannot precede entry time.");
        }
        if (fee == null || fee.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Fee cannot be negative.");
        }
        this.exitTime = exitTime;
        this.fee = fee.setScale(2, java.math.RoundingMode.HALF_UP);
    }
}