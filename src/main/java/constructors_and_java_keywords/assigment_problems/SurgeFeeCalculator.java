package constructors_and_java_keywords.assigment_problems;

public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        if (minimumSurgePercent < 0) {
            throw new IllegalArgumentException("Minimum surge cannot be negative.");
        }
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Order value and delay cannot be negative.");
        }
        if (delayMinutes == 0) {
            return 0.0;
        }

        int firstBracketMinutes = Math.min(delayMinutes, 5);
        int secondBracketMinutes = Math.min(Math.max(delayMinutes - 5, 0), 10);
        int thirdBracketMinutes = Math.max(delayMinutes - 15, 0);
        double tieredFee = orderValue * (firstBracketMinutes * 0.005
                + secondBracketMinutes * 0.01 + thirdBracketMinutes * 0.02);
        double minimumFee = orderValue * minimumSurgePercent / 100;

        return Math.max(tieredFee, minimumFee);
    }

    public static void main(String[] args) {
        SurgeFeeCalculator calculator = new SurgeFeeCalculator(1);
        System.out.println(calculator.calculateSurgeFee(500, 0));
        System.out.println(calculator.calculateSurgeFee(500, 1));
        System.out.println(calculator.calculateSurgeFee(500, 16));
    }
}
