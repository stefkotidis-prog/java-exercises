public class CustomerTask implements Runnable {
    private final TicketCounter counter;
    private final String customerName;
    private final int ticketsToBook;

    public CustomerTask(TicketCounter counter, String customerName, int ticketsToBook) {
        this.counter = counter;
        this.customerName = customerName;
        this.ticketsToBook = ticketsToBook;
    }

    @Override
    public void run() {
        counter.bookTickets(customerName, ticketsToBook);
    }
}