package string_array_basics.class_problems;

public class ReverseCustomerName {
    public static String reverseCustomerName(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    public static void main(String[] args) {
        String customerName = "Aarav Sharma";
        System.out.println("Original: " + customerName);
        System.out.println("Reversed: " + reverseCustomerName(customerName));
    }
}
