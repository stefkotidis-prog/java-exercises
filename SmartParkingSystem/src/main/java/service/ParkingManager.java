package service;

import exception.DuplicateVehicleException;
import exception.ParkingFullException;
import exception.VehicleNotFoundException;
import model.*;
import storage.FileStorage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingManager {
    private final int totalCapacity;
    private int occupiedCapacity;
    private final Map<String, ParkingTicket> activeTickets;
    private final List<ParkingTicket> completedTickets;
    private final PricingService pricingService;
    private final FileStorage fileStorage;

    public ParkingManager(int totalCapacity, PricingService pricingService, FileStorage fileStorage) {
        if (totalCapacity <= 0) {
            throw new IllegalArgumentException("Parking capacity must be greater than 0.");
        }
        this.totalCapacity = totalCapacity;
        this.occupiedCapacity = 0;
        this.activeTickets = new LinkedHashMap<>();
        this.completedTickets = new ArrayList<>();
        this.pricingService = pricingService;
        this.fileStorage = fileStorage;

        restoreState();
    }

    private void restoreState() {
        try {
            List<ParkingTicket> loadedActive = fileStorage.loadActiveTickets();
            for (ParkingTicket ticket : loadedActive) {
                activeTickets.put(ticket.getVehicle().getLicensePlate(), ticket);
                occupiedCapacity += ticket.getVehicle().getCapacityUnits();
            }
            List<ParkingTicket> loadedCompleted = fileStorage.loadCompletedTickets();
            completedTickets.addAll(loadedCompleted);
        } catch (Exception e) {
            throw new RuntimeException("Failed to restore state from storage: " + e.getMessage(), e);
        }
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws ParkingFullException, DuplicateVehicleException {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        String plate = vehicle.getLicensePlate();
        if (activeTickets.containsKey(plate)) {
            throw new DuplicateVehicleException("Vehicle with license plate " + plate + " is already parked.");
        }

        int requiredUnits = vehicle.getCapacityUnits();
        if (getAvailableCapacity() < requiredUnits) {
            throw new ParkingFullException("Not enough capacity. Required units: " + requiredUnits + ", Available: " + getAvailableCapacity());
        }

        String ticketId = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(Locale.ROOT);
        LocalDateTime now = LocalDateTime.now();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, now);

        activeTickets.put(plate, ticket);
        occupiedCapacity += requiredUnits;

        saveState();

        return ticket;
    }

    public synchronized ParkingTicket removeVehicle(String licensePlate) throws VehicleNotFoundException {
        if (licensePlate == null || licensePlate.isBlank()) {
            throw new IllegalArgumentException("License plate cannot be blank.");
        }
        String normalizedPlate = licensePlate.trim().toUpperCase(Locale.ROOT);
        ParkingTicket ticket = activeTickets.get(normalizedPlate);
        if (ticket == null) {
            throw new VehicleNotFoundException("No active ticket found for license plate: " + normalizedPlate);
        }

        LocalDateTime exitTime = LocalDateTime.now();
        BigDecimal fee = pricingService.calculateFee(ticket.getVehicle(), ticket.getEntryTime(), exitTime);

        int previousOccupied = occupiedCapacity;
        
        try {
            ticket.complete(exitTime, fee);
            activeTickets.remove(normalizedPlate);
            occupiedCapacity -= ticket.getVehicle().getCapacityUnits();
            
            saveState();
        } catch (Exception e) {
            occupiedCapacity = previousOccupied;
            throw new RuntimeException("Failed to complete vehicle exit and save state: " + e.getMessage(), e);
        }

        completedTickets.add(ticket);
        return ticket;
    }

    private void saveState() {
        try {
            fileStorage.saveActiveTickets(activeTickets.values());
            fileStorage.saveCompletedTickets(completedTickets);
        } catch (Exception e) {
            throw new RuntimeException(new exception.StorageException("Failed to save data to storage.", e));
        }
    }

    public ParkingTicket findActiveTicket(String licensePlate) {
        if (licensePlate == null) return null;
        return activeTickets.get(licensePlate.trim().toUpperCase(Locale.ROOT));
    }

    public ParkingTicket findTicketById(String ticketId) {
        if (ticketId == null) return null;
        for (ParkingTicket t : activeTickets.values()) {
            if (t.getTicketId().equalsIgnoreCase(ticketId)) return t;
        }
        for (ParkingTicket t : completedTickets) {
            if (t.getTicketId().equalsIgnoreCase(ticketId)) return t;
        }
        return null;
    }

    public List<ParkingTicket> getActiveTickets() {
        return List.copyOf(activeTickets.values());
    }

    public List<ParkingTicket> getCompletedTickets() {
        return List.copyOf(completedTickets);
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getOccupiedCapacity() {
        return occupiedCapacity;
    }

    public int getAvailableCapacity() {
        return totalCapacity - occupiedCapacity;
    }

    public double getOccupancyPercentage() {
        if (totalCapacity == 0) return 0.0;
        return ((double) occupiedCapacity / totalCapacity) * 100.0;
    }
}