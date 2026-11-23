public class TicketCounter {
    private int availableTickets;
    private int soldTickets;
    private int failedAttempts;

    public TicketCounter(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public synchronized boolean bookTickets(String customerName, int requested) {
        if (availableTickets >= requested) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            availableTickets -= requested;
            soldTickets += requested;
            System.out.printf("[%s] Booked %d ticket(s). Remaining: %d%n",
                    customerName, requested, availableTickets);
            return true;
        }

        failedAttempts++;
        System.out.printf("[%s] Failed to book %d ticket(s). Remaining: %d%n",
                customerName, requested, availableTickets);
        return false;
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }

    public synchronized int getSoldTickets() {
        return soldTickets;
    }

    public synchronized int getFailedAttempts() {
        return failedAttempts;
    }
}