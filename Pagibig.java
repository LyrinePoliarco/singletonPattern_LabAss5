public class Pagibig {
    public static void main(String[] args) {
        // This sets the start point of the queue
        CustomerQueueManager queueManager = CustomerQueueManager.getInstance(1);
        
        // Automatically create customers
        createCustomers(queueManager);
        
        // Automatically serve customers
        serveCustomers(queueManager);
    }

    // Customer creation
    private static void createCustomers(CustomerQueueManager queueManager) {
        printCustomerCreation(queueManager, "Lyrine Poliarco");
        printCustomerCreation(queueManager, "Erlyn Deleon");
        printCustomerCreation(queueManager, "Angelica Toquero");
    }

    private static void printCustomerCreation(CustomerQueueManager queueManager, String customerName) {
        try {
            System.out.println(queueManager.addCustomer(customerName));
        } catch (Exception e) {
            System.err.println("Error creating customer: " + e.getMessage());
        }
    }

    // Serve customers
    private static void serveCustomers(CustomerQueueManager queueManager) {
        for (int i = 0; i < 3; i++) { // Adjust the loop based on how many customers you expect to serve
            serveNextCustomer(queueManager);
        }
    }

    private static void serveNextCustomer(CustomerQueueManager queueManager) {
        try {
            String message = queueManager.processNextCustomer();
            System.out.println(message);
        } catch (IllegalStateException e) {
            System.err.println("Error serving customer: " + e.getMessage());
        }
    }
}
