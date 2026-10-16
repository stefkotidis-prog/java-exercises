package service;

import model.Vehicle;
import model.VehicleType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

public class PricingService {

    private static final BigDecimal FIRST_HOUR_RATE = new BigDecimal("2.00");
    private static final BigDecimal EXTRA_HOUR_RATE = new BigDecimal("1.50");
    private static final BigDecimal DAILY_CAP = new BigDecimal("20.00");

    public Duration calculateDuration(LocalDateTime entryTime, LocalDateTime exitTime) {
        if (exitTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("Exit time cannot precede entry time.");
        }
        return Duration.between(entryTime, exitTime);
    }

    public BigDecimal calculateFee(Vehicle vehicle, LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration = calculateDuration(entryTime, exitTime);
        long totalMinutes = duration.toMinutes();

        if (totalMinutes == 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        long fullDays = totalMinutes / 1440;
        long remainingMinutes = totalMinutes % 1440;

        BigDecimal baseFee = BigDecimal.ZERO;

        if (fullDays > 0) {
            baseFee = baseFee.add(DAILY_CAP.multiply(BigDecimal.valueOf(fullDays)));
        }

        if (remainingMinutes > 0) {
            BigDecimal dayFee = calculatePeriodFee(remainingMinutes);
            baseFee = baseFee.add(dayFee);
        }

        BigDecimal finalFee = applyVehicleMultiplier(baseFee, vehicle.getType());
        return finalFee.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculatePeriodFee(long minutes) {
        long hours = (minutes + 59) / 60;
        if (hours <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal fee = FIRST_HOUR_RATE;
        if (hours > 1) {
            BigDecimal extraHours = BigDecimal.valueOf(hours - 1);
            fee = fee.add(extraHours.multiply(EXTRA_HOUR_RATE));
        }

        if (fee.compareTo(DAILY_CAP) > 0) {
            return DAILY_CAP;
        }
        return fee;
    }

    private BigDecimal applyVehicleMultiplier(BigDecimal baseFee, VehicleType type) {
        switch (type) {
            case MOTORCYCLE:
                return baseFee.multiply(new BigDecimal("0.80"));
            case TRUCK:
                return baseFee.multiply(new BigDecimal("1.50"));
            case CAR:
            default:
                return baseFee;
        }
    }
}