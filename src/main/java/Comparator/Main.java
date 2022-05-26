package Comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Employee bob1 = new Employee("bob", 22, "male", "911");
    Employee bob2 = new Employee("bob", 25, "male", "522");
    Employee alice = new Employee("alice", 25, "female", "922");
    Employee jenny = new Employee("jenny", 30, "female", "422");
    List<Employee> list = new ArrayList<>(List.of(bob1, bob2, alice, jenny));

    Set<Employee> orderedList = new EmployeeService().getEmployeesByOrder(list);

    System.out.println(list);
    System.out.println(orderedList);
    System.out.println("Ok");
  }
}
