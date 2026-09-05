package oop_fundamentals.class_problems;

/** Extends a tested base account without modifying it. */
public class FeeAccountInheritance {
    public static void main(String[] args) {
        FeeAccount[] accounts = { new FeeAccount("RA01", 150000), new HostelFeeAccount("RA02", 200000), new ScholarshipFeeAccount("RA03", 180000, 20) };
        accounts[0].pay(150000);
        ((HostelFeeAccount) accounts[1]).payInTwoInstallments(60000);
        for (FeeAccount account : accounts) {
            if (account instanceof ScholarshipFeeAccount scholarship) System.out.println("Scholarship account effective due: Rs " + scholarship.effectiveDue());
            else if (account instanceof HostelFeeAccount) System.out.println("Hostel account due: Rs " + account.getDue());
            else System.out.println("Plain account due: Rs " + account.getDue());
        }
    }
}

class FeeAccount {
    private final String regNo; private final double totalFee; private double amountPaid;
    FeeAccount(String regNo, double totalFee) { this.regNo = regNo; this.totalFee = totalFee; }
    void pay(double amount) { if (amount > 0) amountPaid += amount; else System.out.println("Payment rejected"); }
    double getDue() { return totalFee - amountPaid; }
}
class HostelFeeAccount extends FeeAccount {
    HostelFeeAccount(String regNo, double totalFee) { super(regNo, totalFee); }
    void payInTwoInstallments(double amount) { pay(amount / 2); pay(amount / 2); }
}
class ScholarshipFeeAccount extends FeeAccount {
    private final double scholarshipPercent;
    ScholarshipFeeAccount(String regNo, double totalFee, double scholarshipPercent) { super(regNo, totalFee); this.scholarshipPercent = Math.max(0, Math.min(100, scholarshipPercent)); }
    double effectiveDue() { return getDue() * (100 - scholarshipPercent) / 100; }
}
