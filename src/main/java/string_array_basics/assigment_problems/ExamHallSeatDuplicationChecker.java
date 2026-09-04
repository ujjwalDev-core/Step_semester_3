package string_array_basics.assigment_problems;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int index = 0; index < seatNumbers.length; index++) {
            for (int comparison = index + 1; comparison < seatNumbers.length; comparison++) {
                if (seatNumbers[index] == seatNumbers[comparison]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[index]);
                    foundDuplicate = true;
                    break;
                }
            }
        }
        if (!foundDuplicate) System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
    }
}
