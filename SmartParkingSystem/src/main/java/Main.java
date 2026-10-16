import model.*;
import service.ParkingManager;
import service.PricingService;
import service.ReportService;
import storage.FileStorage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PricingService pricingService = new PricingService();
        FileStorage fileStorage = new FileStorage("data");
        ParkingManager parkingManager = new ParkingManager(20, pricingService, fileStorage);
        ReportService reportService = new ReportService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.print("Enter car license plate: ");
                        String carPlate = scanner.nextLine();
                        ParkingTicket carTicket = parkingManager.parkVehicle(new Car(carPlate));
                        System.out.println("Successful entry! Ticket ID: " + carTicket.getTicketId());
                        break;
                    case 2:
                        System.out.print("Enter motorcycle license plate: ");
                        String motoPlate = scanner.nextLine();
                        ParkingTicket motoTicket = parkingManager.parkVehicle(new Motorcycle(motoPlate));
                        System.out.println("Successful entry! Ticket ID: " + motoTicket.getTicketId());
                        break;
                    case 3:
                        System.out.print("Enter truck license plate: ");
                        String truckPlate = scanner.nextLine();
                        ParkingTicket truckTicket = parkingManager.parkVehicle(new Truck(truckPlate));
                        System.out.println("Successful entry! Ticket ID: " + truckTicket.getTicketId());
                        break;
                    case 4:
                        System.out.print("Enter vehicle license plate for exit: ");
                        String exitPlate = scanner.nextLine();
                        ParkingTicket completed = parkingManager.removeVehicle(exitPlate);
                        System.out.println("Vehicle departed. Final fee: €" + completed.getFee());
                        break;
                    case 5:
                        List<ParkingTicket> active = parkingManager.getActiveTickets();
                        System.out.println("\n--- Active Vehicles (" + active.size() + ") ---");
                        if (active.isEmpty()) {
                            System.out.println("No vehicles in the parking.");
                        } else {
                            for (ParkingTicket t : active) {
                                System.out.println("ID: " + t.getTicketId() + " | Plate: " + t.getVehicle().getLicensePlate() +
                                        " | Type: " + t.getVehicle().getType() + " | Entry: " + t.getEntryTime());
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Enter Ticket ID or License Plate: ");
                        String query = scanner.nextLine();
                        ParkingTicket found = parkingManager.findTicketById(query);
                        if (found == null) {
                            found = parkingManager.findActiveTicket(query);
                        }
                        if (found != null) {
                            System.out.println("Found! ID: " + found.getTicketId() + " | Plate: " + found.getVehicle().getLicensePlate() +
                                    " | Active: " + found.isActive());
                        } else {
                            System.out.println("Ticket not found.");
                        }
                        break;
                    case 7:
                        List<ParkingTicket> compList = parkingManager.getCompletedTickets();
                        System.out.println("\n--- Completed Sessions History (" + compList.size() + ") ---");
                        if (compList.isEmpty()) {
                            System.out.println("History is empty.");
                        } else {
                            for (ParkingTicket t : compList) {
                                System.out.println("ID: " + t.getTicketId() + " | Plate: " + t.getVehicle().getLicensePlate() +
                                        " | Exit: " + t.getExitTime() + " | Fee: €" + t.getFee());
                            }
                        }
                        break;
                    case 8:
                        List<ParkingTicket> allCompleted = parkingManager.getCompletedTickets();
                        BigDecimal revenue = reportService.getTotalRevenue(allCompleted);
                        long count = reportService.getCompletedSessionCount(allCompleted);
                        double avgDuration = reportService.getAverageDurationMinutes(allCompleted);
                        System.out.println("\n--- Statistics ---");
                        System.out.println("Total Revenue: €" + revenue);
                        System.out.println("Completed Sessions: " + count);
                        System.out.println("Average Duration: " + String.format("%.2f", avgDuration) + " minutes");
                        System.out.println("Cars (Completed): " + reportService.countByVehicleType(allCompleted, VehicleType.CAR));
                        System.out.println("Motorcycles (Completed): " + reportService.countByVehicleType(allCompleted, VehicleType.MOTORCYCLE));
                        System.out.println("Trucks (Completed): " + reportService.countByVehicleType(allCompleted, VehicleType.TRUCK));
                        break;
                    case 9:
                        System.out.println("\n--- Capacity Status ---");
                        System.out.println("Total Capacity: " + parkingManager.getTotalCapacity() + " units");
                        System.out.println("Occupied Capacity: " + parkingManager.getOccupiedCapacity() + " units");
                        System.out.println("Available Capacity: " + parkingManager.getAvailableCapacity() + " units");
                        System.out.println("Occupancy Percentage: " + String.format("%.2f", parkingManager.getOccupancyPercentage()) + "%");
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select from 0 to 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid choice number.");
            } catch (Exception e) {
                System.out.println("Operation error: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========== SMART PARKING SYSTEM ==========");
        System.out.println("1. Park car");
        System.out.println("2. Park motorcycle");
        System.out.println("3. Park truck");
        System.out.println("4. Remove vehicle");
        System.out.println("5. View active vehicles");
        System.out.println("6. Search ticket");
        System.out.println("7. View history");
        System.out.println("8. View statistics");
        System.out.println("9. View capacity");
        System.out.println("0. Exit application");
    }
}