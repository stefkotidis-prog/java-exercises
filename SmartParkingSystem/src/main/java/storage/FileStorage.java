package storage;

import exception.StorageException;
import model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileStorage {
    private final Path activeSessionsPath;
    private final Path completedSessionsPath;

    public FileStorage(String dataDir) {
        Path dir = Path.of(dataDir);
        this.activeSessionsPath = dir.resolve("active_sessions.csv");
        this.completedSessionsPath = dir.resolve("completed_sessions.csv");
        initializeFiles();
    }

    private void initializeFiles() {
        try {
            Path parent = activeSessionsPath.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            if (!Files.exists(activeSessionsPath)) {
                Files.createFile(activeSessionsPath);
            }
            if (!Files.exists(completedSessionsPath)) {
                Files.createFile(completedSessionsPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(new StorageException("Failed to initialize storage files.", e));
        }
    }

    public void saveActiveTickets(Collection<ParkingTicket> tickets) throws StorageException {
        List<String> lines = new ArrayList<>();
        for (ParkingTicket t : tickets) {
            String line = String.join(",",
                    t.getTicketId(),
                    t.getVehicle().getLicensePlate(),
                    t.getVehicle().getType().name(),
                    t.getEntryTime().toString()
            );
            lines.add(line);
        }
        writeToFile(activeSessionsPath, lines);
    }

    public void saveCompletedTickets(Collection<ParkingTicket> tickets) throws StorageException {
        List<String> lines = new ArrayList<>();
        for (ParkingTicket t : tickets) {
            String exitTimeStr = t.getExitTime() != null ? t.getExitTime().toString() : "";
            String feeStr = t.getFee() != null ? t.getFee().toPlainString() : "0.00";
            String line = String.join(",",
                    t.getTicketId(),
                    t.getVehicle().getLicensePlate(),
                    t.getVehicle().getType().name(),
                    t.getEntryTime().toString(),
                    exitTimeStr,
                    feeStr
            );
            lines.add(line);
        }
        writeToFile(completedSessionsPath, lines);
    }

    public List<ParkingTicket> loadActiveTickets() throws StorageException {
        List<ParkingTicket> tickets = new ArrayList<>();
        if (!Files.exists(activeSessionsPath)) return tickets;

        try {
            List<String> lines = Files.readAllLines(activeSessionsPath);
            for (String line : lines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length < 4) continue;

                String ticketId = parts[0];
                String plate = parts[1];
                VehicleType type = VehicleType.valueOf(parts[2]);
                LocalDateTime entryTime = LocalDateTime.parse(parts[3]);

                Vehicle vehicle = createVehicleByType(plate, type);
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, entryTime);
                tickets.add(ticket);
            }
        } catch (Exception e) {
            throw new StorageException("Error reading active tickets file (file might be corrupted).", e);
        }
        return tickets;
    }

    public List<ParkingTicket> loadCompletedTickets() throws StorageException {
        List<ParkingTicket> tickets = new ArrayList<>();
        if (!Files.exists(completedSessionsPath)) return tickets;

        try {
            List<String> lines = Files.readAllLines(completedSessionsPath);
            for (String line : lines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length < 6) continue;

                String ticketId = parts[0];
                String plate = parts[1];
                VehicleType type = VehicleType.valueOf(parts[2]);
                LocalDateTime entryTime = LocalDateTime.parse(parts[3]);
                LocalDateTime exitTime = LocalDateTime.parse(parts[4]);
                BigDecimal fee = new BigDecimal(parts[5]);

                Vehicle vehicle = createVehicleByType(plate, type);
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, entryTime, exitTime, fee);
                tickets.add(ticket);
            }
        } catch (Exception e) {
            throw new StorageException("Error reading completed tickets file.", e);
        }
        return tickets;
    }

    private Vehicle createVehicleByType(String plate, VehicleType type) {
        switch (type) {
            case CAR: return new Car(plate);
            case MOTORCYCLE: return new Motorcycle(plate);
            case TRUCK: return new Truck(plate);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    private void writeToFile(Path path, List<String> lines) throws StorageException {
        try {
            Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("Failed to write to file: " + path, e);
        }
    }
}