package constructors_and_java_keywords.assigment_problems;

public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;
    public SurgeFeeCalculator(double minimumSurgePercent) { if (minimumSurgePercent < 0) throw new IllegalArgumentException("Negative floor"); this.minimumSurgePercent = minimumSurgePercent; }
    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) throw new IllegalArgumentException("Negative input");
        if (delayMinutes == 0) return 0.0;
        int first = Math.min(delayMinutes, 5), second = Math.min(Math.max(delayMinutes - 5, 0), 10), third = Math.max(delayMinutes - 15, 0);
        double tiered = orderValue * (first * .005 + second * .01 + third * .02);
        return Math.max(tiered, orderValue * minimumSurgePercent / 100);
    }
    public static void main(String[] args) { SurgeFeeCalculator calculator = new SurgeFeeCalculator(1); System.out.println(calculator.calculateSurgeFee(500, 0)); System.out.println(calculator.calculateSurgeFee(500, 1)); System.out.println(calculator.calculateSurgeFee(500, 16)); }
}
