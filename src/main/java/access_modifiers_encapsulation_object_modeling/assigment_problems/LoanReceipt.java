package access_modifiers_encapsulation_object_modeling.assigment_problems;

/** Not final only because the required reference-only receipt must extend this type. */
public class LoanReceipt {
    protected static final String LEDGER_NAME;
    protected final String memberId;
    private final String[] bookIds;
    static { LEDGER_NAME = "PageTurner Nightly Ledger"; }
    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || memberId.isBlank() || bookIds == null || bookIds.length > 20) throw new IllegalArgumentException("Invalid receipt.");
        for (String bookId : bookIds) if (bookId == null || !bookId.matches("BK-\\d{3}")) throw new IllegalArgumentException("Invalid book ID: " + bookId);
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }
    public String[] getBookIds() { return bookIds.clone(); }
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] corrected = getBookIds();
        if (index < 0 || index >= corrected.length) throw new IndexOutOfBoundsException("Invalid book index.");
        corrected[index] = newId;
        return new LoanReceipt(memberId, corrected);
    }
    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nulls = 0, referenceOnly = 0;
        if (receipts != null) for (LoanReceipt receipt : receipts) { if (receipt == null) { nulls++; continue; } processed++; if (receipt instanceof ReferenceOnlyLoanReceipt) referenceOnly++; }
        return processed + " processed | " + nulls + " null skipped | " + referenceOnly + " reference-only | " + (processed - referenceOnly) + " regular";
    }
    public static void main(String[] args) { System.out.println(processNightlyCirculation(new LoanReceipt[]{new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"), null, new LoanReceipt("LIB-002", new String[]{"BK-201"})})); }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) { super(memberId, bookIds); this.roomNumber = roomNumber; }
}
