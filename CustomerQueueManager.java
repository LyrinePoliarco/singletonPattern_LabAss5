import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerQueueManager {
    private static CustomerQueueManager instance;
    private final AtomicInteger nextQueueNumber;
    private final List<Customer> customerList;

    // Private constructor to restrict instantiation
    private CustomerQueueManager(int initialQueueNumber) {
        this.nextQueueNumber = new AtomicInteger(initialQueueNumber);
        this.customerList = new ArrayList<>();
    }

    public static synchronized CustomerQueueManager getInstance(int initialQueueNumber) {
        if (instance == null) {
            instance = new CustomerQueueManager(initialQueueNumber);
        }
        return instance;
    }

    public String addCustomer(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }

        int queueNum = nextQueueNumber.get();
        Customer newCustomer = new Customer(customerName, queueNum);
        customerList.add(newCustomer);
        nextQueueNumber.incrementAndGet();
        return customerName + " has been assigned queue number: " + queueNum;
    }

    public String processNextCustomer() {
        if (customerList.isEmpty()) {
            throw new IllegalStateException("The queue is currently empty.");
        }

        Customer customerToServe = customerList.remove(0);
        return "Now serving: " + customerToServe.getName() + " (Queue number: " + customerToServe.getQueueNumber() + ")";
    }
}
