package constructors_and_java_keywords.class_problems;

/** final protects the calculator, its setting, and calculation rule. */
public final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        if (minimumPenaltyPercent < 0) {
            throw new IllegalArgumentException("Minimum penalty cannot be negative.");
        }
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Fare and delay cannot be negative.");
        }
        if (minutesLate == 0) {
            return 0.0;
        }

        int firstBracketMinutes = Math.min(minutesLate, 5);
        int secondBracketMinutes = Math.min(Math.max(minutesLate - 5, 0), 10);
        int thirdBracketMinutes = Math.max(minutesLate - 15, 0);
        double tieredPenalty = ticketFare * (firstBracketMinutes * 0.005
                + secondBracketMinutes * 0.01 + thirdBracketMinutes * 0.02);
        double minimumPenalty = ticketFare * minimumPenaltyPercent / 100;

        return Math.max(tieredPenalty, minimumPenalty);
    }

    public static void main(String[] args) {
        BoardingPenaltyCalculator calculator = new BoardingPenaltyCalculator(1);
        System.out.println(calculator.calculatePenalty(1000, 0));
        System.out.println(calculator.calculatePenalty(1000, 1));
        System.out.println(calculator.calculatePenalty(1000, 16));
    }
}
