package oop_fundamentals.class_problems;

/** Demonstrates instance data and a class-wide calculation. */
public class AttendanceSystem {
    public static void main(String[] args) {
        SrmStudent[] students = {
            new SrmStudent("Ravi", "RA231100301011", 82),
            new SrmStudent("Anitha", "RA231100301012", 68),
            new SrmStudent("Karthik", "RA231100301013", 91),
            new SrmStudent("Meera", "RA231100301014", 74),
            new SrmStudent("Suresh", "RA231100301015", 60)
        };

        for (SrmStudent student : students) {
            String status = student.isEligible() ? "Eligible" : "Detained";
            System.out.println(student.name + " - " + student.attendance + "% - " + status);
        }

        // Static: this calculation uses an array of students, not one student's state.
        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }
}

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    void addAttendanceUpdate(int newAttendance) {
        attendance = newAttendance;
    }

    boolean isEligible() {
        return attendance >= 75;
    }

    static double classAverage(SrmStudent[] students) {
        int totalAttendance = 0;
        for (SrmStudent student : students) {
            totalAttendance += student.attendance;
        }
        return (double) totalAttendance / students.length;
    }
}
