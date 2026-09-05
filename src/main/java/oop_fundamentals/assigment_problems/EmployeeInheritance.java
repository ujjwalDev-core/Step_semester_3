package oop_fundamentals.assigment_problems;

/** Uses inheritance to introduce pay rules without changing Employee. */
public class EmployeeInheritance {
    public static void main(String[] args) {
        Employee[] employees = { new Employee("E01", "Plain", 40000), new ManagerEmployee("E02", "Manager", 70000, 8000), new InternEmployee("E03", "Intern", 12000, 10000) };
        for (Employee employee : employees) {
            if (employee instanceof ManagerEmployee manager) System.out.println("Manager effective pay: Rs " + manager.effectiveSalary());
            else if (employee instanceof InternEmployee intern) System.out.println("Intern effective pay: Rs " + intern.effectiveSalary());
            else System.out.println("Plain employee pay: Rs " + employee.getSalary());
        }
    }
}
class Employee { private final String empId, empName; private final double salary; Employee(String empId,String empName,double salary){this.empId=empId;this.empName=empName;this.salary=salary;} double getSalary(){return salary;} }
class ManagerEmployee extends Employee { private final double teamBonus; ManagerEmployee(String id,String name,double salary,double bonus){super(id,name,salary);teamBonus=bonus;} double effectiveSalary(){return getSalary()+teamBonus;} }
class InternEmployee extends Employee { private final double stipendCap; InternEmployee(String id,String name,double salary,double cap){super(id,name,salary);stipendCap=cap;} double effectiveSalary(){return Math.min(getSalary(),stipendCap);} }
