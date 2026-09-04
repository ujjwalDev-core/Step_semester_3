package string_array_basics.assigment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        for (int quantity : sectionA) totalA += quantity;
        for (int quantity : sectionB) totalB += quantity;
        boolean hasMaximum = false;
        int highestQuantity = 0;
        String highestSection = "";
        int highestIndex = -1;
        for (int index = 0; index < sectionA.length; index++) {
            if (!hasMaximum || sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
                hasMaximum = true;
            }
            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestIndex + 1);
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
