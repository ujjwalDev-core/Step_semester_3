package constructors_and_java_keywords.class_problems;

import java.util.Arrays;

public class FareSplitter {
    private final String tripId;
    private final double totalFare;
    private final int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (tripId == null || tripId.trim().isEmpty() || totalFare < 0 || passengerCount <= 0) throw new IllegalArgumentException("Invalid split details");
        this.tripId = tripId.trim(); this.totalFare = totalFare; this.passengerCount = passengerCount;
    }
    // Constructor chaining keeps all setup and validation in one place.
    public FareSplitter(String tripId, double totalFare) { this(tripId, totalFare, 2); }
    public FareSplitter(String tripId) { this(tripId, 0.0, 2); }

    public double[] fareBreakdown() {
        long paisa = Math.round(totalFare * 100);
        long each = paisa / passengerCount, remainder = paisa % passengerCount;
        double[] shares = new double[passengerCount];
        for (int index = 0; index < passengerCount; index++) shares[index] = (each + (index >= passengerCount - remainder ? 1 : 0)) / 100.0;
        return shares;
    }
    public boolean isConfirmationOverdue(int confirmed, int expected) { return expected > 0 && confirmed < expected; }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FareSplitter("TRIP001", 100000, 3).fareBreakdown()));
        System.out.println(Arrays.toString(new FareSplitter("TRIP003").fareBreakdown()));
    }
}
