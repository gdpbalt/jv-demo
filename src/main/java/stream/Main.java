package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    User bob = new User("Bob", 23);
    bob.setSubjects(List.of("Math", "Geography", "Geometry", "Psychical Education"));
    User bruce = new User("Bruce", 25);
    bruce.setSubjects(List.of("Math", "Geography", "Psychical Education"));
    User alice = new User("Alice", 30);
    alice.setSubjects(List.of("Geography", "Geometry", "Psychical Education"));
    List<User> users = List.of(bob, bruce, alice);

    List<String> subjects = getAllSubjects(users);
    subjects.forEach(System.out::println);
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
