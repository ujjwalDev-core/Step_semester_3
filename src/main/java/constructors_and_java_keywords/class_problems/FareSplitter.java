package constructors_and_java_keywords.class_problems;

import java.util.Arrays;

public class FareSplitter {
    private final String tripId;
    private final double totalFare;
    private final int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (tripId == null || tripId.trim().isEmpty() || totalFare < 0 || passengerCount <= 0) {
            throw new IllegalArgumentException("Invalid fare split details.");
        }
        this.tripId = tripId.trim();
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    // Chaining keeps construction and validation in exactly one constructor.
    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public double[] fareBreakdown() {
        long totalPaisa = Math.round(totalFare * 100);
        long baseSharePaisa = totalPaisa / passengerCount;
        long extraPaisa = totalPaisa % passengerCount;
        double[] shares = new double[passengerCount];

        for (int index = 0; index < passengerCount; index++) {
            boolean receivesExtraPaisa = index >= passengerCount - extraPaisa;
            shares[index] = (baseSharePaisa + (receivesExtraPaisa ? 1 : 0)) / 100.0;
        }
        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return expected > 0 && confirmed < expected;
    }

    public static void main(String[] args) {
        FareSplitter regularSplit = new FareSplitter("TRIP001", 100000, 3);
        System.out.println(Arrays.toString(regularSplit.fareBreakdown()));
        System.out.println(Arrays.toString(new FareSplitter("TRIP003").fareBreakdown()));
    }
}
