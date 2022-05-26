package Comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeService {
  public Set<Employee> getEmployeesByOrder(List<Employee> employees) {
    Comparator<Employee> useComparator =
        new Comparator<Employee>() {
          @Override
          public int compare(Employee first, Employee second) {
            int compareAge = Integer.compare(first.getAge(), second.getAge());
            if (compareAge == 0) {
              return first.getName().compareTo(second.getName());
            }
            return compareAge;
          }
        };
    Set<Employee> set = new TreeSet<>(useComparator);
    set.addAll(employees);
    return set;
  }
}
