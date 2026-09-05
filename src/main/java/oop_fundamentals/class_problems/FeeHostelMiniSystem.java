package oop_fundamentals.class_problems;

/** Composition: each student owns a fee account and may reference a room. */
public class FeeHostelMiniSystem {
    public static void main(String[] args) {
        MiniRoom firstRoom = new MiniRoom("C-214");
        MiniRoom secondRoom = new MiniRoom("C-507");

        MiniStudent ravi = new MiniStudent("Ravi", "RA01", new MiniHostelFeeAccount(200000));
        MiniStudent anitha = new MiniStudent("Anitha", "RA02", new MiniHostelFeeAccount(180000));
        MiniStudent karthik = new MiniStudent("Karthik", "RA03", new MiniHostelFeeAccount(200000));

        ravi.feeAccount.pay(60000);
        anitha.feeAccount.pay(-50);
        ravi.room = firstRoom;
        anitha.room = secondRoom;

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());
        System.out.println("Total students: " + MiniStudent.totalStudents);
    }
}

class MiniHostelFeeAccount {
    private final double fee;
    private double paid;

    MiniHostelFeeAccount(double fee) { this.fee = fee; }
    void pay(double amount) { if (amount > 0) { paid += amount; } else { System.out.println("Payment rejected"); } }
    double getDue() { return fee - paid; }
}

class MiniRoom {
    String roomNo;
    MiniRoom(String roomNo) { this.roomNo = roomNo; }
}

class MiniStudent {
    String name;
    String regNo;
    MiniHostelFeeAccount feeAccount;
    MiniRoom room;
    static int totalStudents;

    MiniStudent(String name, String regNo, MiniHostelFeeAccount feeAccount) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        totalStudents++;
    }

    String fullStatus() {
        String roomNumber = room == null ? "unallotted" : room.roomNo;
        return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + roomNumber;
    }
}
