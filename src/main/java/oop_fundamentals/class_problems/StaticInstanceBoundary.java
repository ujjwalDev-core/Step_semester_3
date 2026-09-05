package oop_fundamentals.class_problems;

/** Contrasts shared static state with independent object state. */
public class StaticInstanceBoundary {
    public static void main(String[] args) {
        new BrokenStudent("Ravi", 82); new BrokenStudent("Meera", 74);
        System.out.println("Broken version:\n" + BrokenStudent.name + "\n" + BrokenStudent.name);
        FixedStudent ravi = new FixedStudent("Ravi", 82); FixedStudent meera = new FixedStudent("Meera", 74);
        ravi.printIdCard(); meera.printIdCard(); FixedStudent.printTotalAdmissions();
    }
}
class BrokenStudent {
    // Wrong: name, regNo, and attendance describe each individual, so static makes every student overwrite them.
    static String name; static String regNo; static int attendance;
    BrokenStudent(String name, int attendance) { BrokenStudent.name = name; BrokenStudent.attendance = attendance; }
}
class FixedStudent {
    String name; String regNo; int attendance; static String university = "SRM"; static int admissionCount;
    FixedStudent(String name, int attendance) { this.name = name; this.attendance = attendance; this.regNo = "RA2311003010" + String.format("%02d", ++admissionCount); }
    void printIdCard() { System.out.println(name + " | " + regNo); }
    static void printTotalAdmissions() { System.out.println("Students admitted so far: " + admissionCount); }
}
