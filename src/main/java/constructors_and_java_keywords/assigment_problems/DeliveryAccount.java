package constructors_and_java_keywords.assigment_problems;

public class DeliveryAccount {
    protected final String studentId;
    protected final double orderValue;
    protected static final double SURGE_RATE;
    static { SURGE_RATE = 0.01; }
    public DeliveryAccount(String studentId, double orderValue) { if (studentId == null || studentId.isBlank() || orderValue < 0) throw new IllegalArgumentException("Invalid account"); this.studentId = studentId; this.orderValue = orderValue; }
    public DeliveryAccount(String studentId) { this(studentId, 0.0); }
    public final double calculateSurgeFee(int delayMinutes) { if (delayMinutes < 0) throw new IllegalArgumentException("Negative delay"); return orderValue * SURGE_RATE * delayMinutes; }
    public void processAccount(DeliveryAccount account, double amount, int delayMinutes) { System.out.printf("%s surge: %.2f%n", account.studentId, account.calculateSurgeFee(delayMinutes)); }
    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null || amounts == null || delayMinutesArray == null || accounts.length != amounts.length || accounts.length != delayMinutesArray.length) throw new IllegalArgumentException("Parallel arrays must match");
        int processed = 0, nulls = 0, premium = 0; double total = 0;
        for (int i = 0; i < accounts.length; i++) { DeliveryAccount account = accounts[i]; if (account == null) { nulls++; continue; } processed++; if (account instanceof PremiumDeliveryAccount) premium++; total += account.calculateSurgeFee(delayMinutesArray[i]); }
        System.out.printf("%d processed | %d null skipped | %d premium | %d regular | grand total surge fees = %.2f%n", processed, nulls, premium, processed - premium, total);
    }
    public static class PremiumDeliveryAccount extends DeliveryAccount { public PremiumDeliveryAccount(String studentId, double orderValue) { super(studentId, orderValue); } }
    public static void main(String[] args) { processBatch(new DeliveryAccount[]{new PremiumDeliveryAccount("STU001", 500), null, new DeliveryAccount("STU002", 300)}, new double[]{500, 400, 300}, new int[]{10, 5, 0}); }
}
