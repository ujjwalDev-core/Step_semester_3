package constructors_and_java_keywords.class_problems;

import java.util.HashSet;
import java.util.Set;

/** Its parameterized constructor prevents an invalid ticket existing. */
public class BusTicket {
    private final String passengerName;
    private final String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (!isMeaningfulName(passengerName)) {
            throw new IllegalArgumentException("Passenger name must contain letters and spaces only.");
        }
        if (!isMeaningfulPlace(destination)) {
            throw new IllegalArgumentException("Destination must contain letters and spaces only.");
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
    }

    private static boolean isMeaningfulName(String value) {
        return value != null && !value.trim().isEmpty() && value.trim().matches("[A-Za-z ]+");
    }

    private static boolean isMeaningfulPlace(String value) {
        return value != null && !value.trim().isEmpty() && value.trim().matches("[A-Za-z ]+");
    }

    public void markCheckedIn() {
        if (checkedIn) {
            System.out.println("Ticket already checked in.");
            return;
        }
        checkedIn = true;
        System.out.println("Checked in: " + passengerName);
    }

    public static void processBatch(String[][] rawBookings) {
        int valid = 0;
        int rejected = 0;
        int duplicates = 0;
        Set<String> acceptedBookings = new HashSet<>();

        if (rawBookings != null) {
            for (String[] booking : rawBookings) {
                try {
                    if (booking == null || booking.length != 2) {
                        throw new IllegalArgumentException("A booking needs two values.");
                    }
                    BusTicket ticket = new BusTicket(booking[0], booking[1]);
                    String key = ticket.passengerName.toLowerCase() + "|" + ticket.destination.toLowerCase();

                    if (acceptedBookings.add(key)) {
                        valid++;
                    } else {
                        duplicates++;
                    }
                } catch (IllegalArgumentException exception) {
                    rejected++;
                }
            }
        }
        System.out.printf("Valid: %d | Rejected: %d | Duplicates skipped: %d%n", valid, rejected, duplicates);
    }

    public static void main(String[] args) {
        String[][] bookings = {
            {"Divya", "Chennai"}, {"", "Bangalore"}, {"Ravi123", "Pune"},
            {"Divya", "Chennai"}, {" ", " "}
        };
        processBatch(bookings);
    }
}
