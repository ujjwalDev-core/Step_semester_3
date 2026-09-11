package constructors_and_java_keywords.class_problems;

public class BusTicketAccount {
    protected final String bookingId;
    protected final double ticketFare;
    protected static final double BASE_RATE;
    static { BASE_RATE = 0.01; } // One-time class-level initialization.
    public BusTicketAccount(String bookingId, double ticketFare) { if (bookingId == null || bookingId.isBlank() || ticketFare < 0) throw new IllegalArgumentException("Invalid account"); this.bookingId = bookingId; this.ticketFare = ticketFare; }
    public BusTicketAccount(String bookingId) { this(bookingId, 0.0); }
    public final double calculatePenalty(int minutesLate) { if (minutesLate < 0) throw new IllegalArgumentException("Negative delay"); return ticketFare * BASE_RATE * minutesLate; }
    public void processAccount(BusTicketAccount account, double amount, int minutesLate) { System.out.printf("%s penalty: %.2f%n", account.bookingId, account.calculatePenalty(minutesLate)); }
    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null || amounts == null || minutesLateArray == null || accounts.length != amounts.length || accounts.length != minutesLateArray.length) throw new IllegalArgumentException("Parallel arrays must match");
        int processed = 0, nulls = 0, sleeper = 0; double total = 0;
        for (int i = 0; i < accounts.length; i++) { BusTicketAccount account = accounts[i]; if (account == null) { nulls++; continue; } processed++; if (account instanceof SleeperCoachAccount) sleeper++; total += account.calculatePenalty(minutesLateArray[i]); }
        System.out.printf("%d processed | %d null skipped | %d sleeper | %d regular | grand total penalties = %.2f%n", processed, nulls, sleeper, processed - sleeper, total);
    }
    public static class SleeperCoachAccount extends BusTicketAccount { public SleeperCoachAccount(String bookingId, double ticketFare) { super(bookingId, ticketFare); } }
    public static void main(String[] args) { processBatch(new BusTicketAccount[]{new SleeperCoachAccount("BK001", 2000), null, new BusTicketAccount("BK002", 1200)}, new double[]{1200, 900, 700}, new int[]{10, 5, 0}); }
}
