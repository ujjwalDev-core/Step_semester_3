package constructors_and_java_keywords.class_problems;

import java.util.HashSet;
import java.util.Set;

/** A parameterized constructor is the validation gate for a ticket. */
public class BusTicket {
    private final String passengerName;
    private final String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty() || !passengerName.trim().matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Passenger name must contain letters and spaces only");
        }
        if (destination == null || destination.trim().isEmpty() || !destination.trim().matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Destination must contain letters and spaces only");
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
    }

    public void markCheckedIn() {
        if (checkedIn) System.out.println("Ticket already checked in.");
        else { checkedIn = true; System.out.println("Checked in: " + passengerName); }
    }

    public static void processBatch(String[][] rawBookings) {
        int valid = 0, rejected = 0, duplicates = 0;
        Set<String> accepted = new HashSet<>();
        if (rawBookings != null) for (String[] booking : rawBookings) {
            try {
                if (booking == null || booking.length != 2) throw new IllegalArgumentException();
                BusTicket ticket = new BusTicket(booking[0], booking[1]);
                String key = ticket.passengerName.toLowerCase() + "|" + ticket.destination.toLowerCase();
                if (accepted.add(key)) valid++; else duplicates++;
            } catch (IllegalArgumentException exception) { rejected++; }
        }
        System.out.printf("Valid: %d | Rejected: %d | Duplicates skipped: %d%n", valid, rejected, duplicates);
    }

    public static void main(String[] args) {
        processBatch(new String[][]{{"Divya", "Chennai"}, {"", "Bangalore"}, {"Ravi123", "Pune"}, {"Divya", "Chennai"}, {" ", " "}});
    }
}
