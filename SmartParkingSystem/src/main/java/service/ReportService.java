package service;

import model.ParkingTicket;
import model.VehicleType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ReportService {

    public BigDecimal getTotalRevenue(List<ParkingTicket> completedTickets) {
        if (completedTickets == null || completedTickets.isEmpty()) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal total = BigDecimal.ZERO;
        for (ParkingTicket t : completedTickets) {
            if (t.getFee() != null) {
                total = total.add(t.getFee());
            }
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public long getCompletedSessionCount(List<ParkingTicket> completedTickets) {
        if (completedTickets == null) return 0;
        return completedTickets.stream().filter(t -> !t.isActive()).count();
    }

    public double getAverageDurationMinutes(List<ParkingTicket> completedTickets) {
        if (completedTickets == null || completedTickets.isEmpty()) {
            return 0.0;
        }
        long totalMinutes = 0;
        long count = 0;
        for (ParkingTicket t : completedTickets) {
            if (t.getExitTime() != null) {
                totalMinutes += java.time.Duration.between(t.getEntryTime(), t.getExitTime()).toMinutes();
                count++;
            }
        }
        if (count == 0) return 0.0;
        return (double) totalMinutes / count;
    }

    public long countByVehicleType(List<ParkingTicket> tickets, VehicleType type) {
        if (tickets == null || type == null) return 0;
        return tickets.stream().filter(t -> t.getVehicle().getType() == type).count();
    }

    public BigDecimal getRevenueByVehicleType(List<ParkingTicket> tickets, VehicleType type) {
        if (tickets == null || type == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal total = BigDecimal.ZERO;
        for (ParkingTicket t : tickets) {
            if (t.getVehicle().getType() == type && t.getFee() != null) {
                total = total.add(t.getFee());
            }
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}