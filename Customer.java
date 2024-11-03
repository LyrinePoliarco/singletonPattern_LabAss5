public class Customer {
    private final String name;
    private final int queueNumber;

    public Customer(String name, int queueNumber) {
        this.name = name;
        this.queueNumber = queueNumber;
    }

    public String getName() {
        return name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }
}
