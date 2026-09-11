package constructors_and_java_keywords.class_problems;

/** final prevents the class, its configuration and its calculation rule changing. */
public final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;
    public BoardingPenaltyCalculator(double minimumPenaltyPercent) { if (minimumPenaltyPercent < 0) throw new IllegalArgumentException("Negative floor"); this.minimumPenaltyPercent = minimumPenaltyPercent; }
    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) throw new IllegalArgumentException("Negative input");
        if (minutesLate == 0) return 0.0;
        int first = Math.min(minutesLate, 5), second = Math.min(Math.max(minutesLate - 5, 0), 10), third = Math.max(minutesLate - 15, 0);
        double tiered = ticketFare * (first * .005 + second * .01 + third * .02);
        return Math.max(tiered, ticketFare * minimumPenaltyPercent / 100);
    }
    public static void main(String[] args) { BoardingPenaltyCalculator calculator = new BoardingPenaltyCalculator(1); System.out.println(calculator.calculatePenalty(1000, 0)); System.out.println(calculator.calculatePenalty(1000, 1)); System.out.println(calculator.calculatePenalty(1000, 16)); }
}
