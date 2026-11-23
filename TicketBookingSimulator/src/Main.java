import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int INITIAL_TICKETS = 10;
    private static final int CUSTOMER_COUNT = 8;

    public static void main(String[] args) throws InterruptedException {
        TicketCounter counter = new TicketCounter(INITIAL_TICKETS);
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= CUSTOMER_COUNT; i++) {
            String name = "Customer-" + i;
            int requested = (i % 3) + 1;
            Thread t = new Thread(new CustomerTask(counter, name, requested), name);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Initial tickets: " + INITIAL_TICKETS);
        System.out.println("Sold tickets:    " + counter.getSoldTickets());
        System.out.println("Remaining:       " + counter.getAvailableTickets());
        System.out.println("Failed attempts: " + counter.getFailedAttempts());
    }
}