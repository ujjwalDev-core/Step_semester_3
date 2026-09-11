package constructors_and_java_keywords.assigment_problems;

public class FoodOrder {
    private final String studentName;
    private final String dishName;
    private boolean delivered;

    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty()
                || dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name and dish name are required.");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
    }

    public void markDelivered() {
        if (delivered) {
            System.out.println("Order already delivered.");
            return;
        }
        delivered = true;
        System.out.println("Delivered: " + dishName);
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;

        if (rawOrders != null) {
            for (String[] order : rawOrders) {
                try {
                    if (order == null || order.length != 2) {
                        throw new IllegalArgumentException("An order needs two values.");
                    }
                    new FoodOrder(order[0], order[1]);
                    valid++;
                } catch (IllegalArgumentException exception) {
                    rejected++;
                }
            }
        }
        System.out.printf("Valid: %d | Rejected: %d%n", valid, rejected);
    }

    public static void main(String[] args) {
        String[][] orders = {
            {"Ravi", "Paneer Butter Masala"}, {"", "Chole Bhature"},
            {"Meera", " "}, {"Divya", "Veg Biryani"}
        };
        processBatch(orders);
    }
}
