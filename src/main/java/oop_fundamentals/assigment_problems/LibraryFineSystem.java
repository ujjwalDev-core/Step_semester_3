package oop_fundamentals.assigment_problems;

/** Calculates per-book fines and a class-wide fine total. */
public class LibraryFineSystem {
    public static void main(String[] args) {
        BookIssue[] issues = { new BookIssue("Clean Code", "A", 18), new BookIssue("Effective Java", "B", 5), new BookIssue("Refactoring", "C", 0), new BookIssue("DSA Handbook", "D", 21), new BookIssue("Design Patterns", "E", 9) };
        for (BookIssue issue : issues) System.out.println(issue.title + " - " + issue.daysOverdue + " days - " + (issue.isSeverelyOverdue() ? "Severely overdue" : "OK"));
        // Static because it sums the state of many issues, whereas fineAmount belongs to one issue.
        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));
    }
}
class BookIssue { String title, borrowerName; int daysOverdue; BookIssue(String title, String borrowerName, int daysOverdue) { this.title=title; this.borrowerName=borrowerName; this.daysOverdue=daysOverdue; } double fineAmount() { return daysOverdue > 0 ? daysOverdue * 5.0 : 0; } boolean isSeverelyOverdue() { return daysOverdue > 14; } static double totalFineCollected(BookIssue[] issues) { double total=0; for(BookIssue issue:issues) total+=issue.fineAmount(); return total; } }
