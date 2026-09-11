package access_modifiers_encapsulation_object_modeling.assigment_problems;

public class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;
    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            throw new IllegalArgumentException("Total copies must be positive.");
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }
    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory(3);
        for (int count = 0; count < 4; count++) {
            inventory.checkOut();
        }
        System.out.println(inventory.getCopiesAvailable());
    }
}
