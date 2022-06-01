package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println(new ParentServiceImpl().getFatherList());
  }

  private static List<String> getListUserAgeOlderThan(List<User> list, int age) {
    return list.stream()
            .filter(u -> u.getAge() >= age)
            .map(User::getName)
            .collect(Collectors.toList());
  }

  private static List<String> getAllSubjects(List<User> list) {
    return list.stream()
            .flatMap(l -> l.getSubjects().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
  }
}
