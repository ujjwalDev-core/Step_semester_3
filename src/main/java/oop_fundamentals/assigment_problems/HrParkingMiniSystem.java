package oop_fundamentals.assigment_problems;

/** Independent capstone inferred from the supplied HR + parking title. */
public class HrParkingMiniSystem {
    public static void main(String[] args) {
        CompanyParkingSlot slot = new CompanyParkingSlot("P-12");
        CompanyEmployee priya = new CompanyEmployee("Priya", 60000), arun = new CompanyEmployee("Arun", 45000);
        priya.assignSlot(slot); arun.assignSlot(null);
        System.out.println(priya.status()); System.out.println(arun.status());
        System.out.println("Total employees: " + CompanyEmployee.totalEmployees);
    }
}
class CompanyParkingSlot { private final String slotNo; CompanyParkingSlot(String slotNo){this.slotNo=slotNo;} String getSlotNo(){return slotNo;} }
class CompanyEmployee { private final String name; private final double salary; private CompanyParkingSlot slot; static int totalEmployees; CompanyEmployee(String name,double salary){this.name=name;this.salary=salary;totalEmployees++;} void assignSlot(CompanyParkingSlot slot){this.slot=slot;} String status(){return name+" | Salary: Rs "+salary+" | Slot: "+(slot==null?"unallotted":slot.getSlotNo());} }
