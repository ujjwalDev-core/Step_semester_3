package session_2_strings.assigment_problems;

/** Parses a three-field inventory CSV record. */
public class ProductInventoryCsvParser {
    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + fields[0] + " | SKU: " + fields[1]
                + " | Qty: " + fields[2]);
    }
}
