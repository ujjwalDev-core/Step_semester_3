package constructors_and_java_keywords.class_problems;

public class BusTicketAccount {
    protected static final double BASE_RATE;
    protected final String bookingId;
    protected final double ticketFare;

    static {
        BASE_RATE = 0.01;
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        if (bookingId == null || bookingId.isBlank() || ticketFare < 0) {
            throw new IllegalArgumentException("Invalid account.");
        }
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 0.0);
    }

    public final double calculatePenalty(int minutesLate) {
        if (minutesLate < 0) {
            throw new IllegalArgumentException("Delay cannot be negative.");
        }
        return ticketFare * BASE_RATE * minutesLate;
    }

    public void processAccount(BusTicketAccount account, double amount, int minutesLate) {
        System.out.printf("%s penalty: %.2f%n", account.bookingId, account.calculatePenalty(minutesLate));
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        validateParallelArrays(accounts, amounts, minutesLateArray);
        int processed = 0;
        int nulls = 0;
        int sleepers = 0;
        double total = 0;

        for (int index = 0; index < accounts.length; index++) {
            BusTicketAccount account = accounts[index];
            if (account == null) {
                nulls++;
                continue;
            }
            processed++;
            if (account instanceof SleeperCoachAccount) {
                sleepers++;
            }
            total += account.calculatePenalty(minutesLateArray[index]);
        }
        System.out.printf("%d processed | %d null skipped | %d sleeper | %d regular | grand total penalties = %.2f%n", processed, nulls, sleepers, processed - sleepers, total);
    }

    private static void validateParallelArrays(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null || amounts == null || minutesLateArray == null
                || accounts.length != amounts.length || accounts.length != minutesLateArray.length) {
            throw new IllegalArgumentException("Parallel arrays must match.");
        }
    }

    public static class SleeperCoachAccount extends BusTicketAccount {
        public SleeperCoachAccount(String bookingId, double ticketFare) {
            super(bookingId, ticketFare);
        }
    }

    public static void main(String[] args) {
        BusTicketAccount[] accounts = {new SleeperCoachAccount("BK001", 2000), null, new BusTicketAccount("BK002", 1200)};
        processBatch(accounts, new double[]{1200, 900, 700}, new int[]{10, 5, 0});
    }
}
