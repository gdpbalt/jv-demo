package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static Map<User, List<Parent>> getParents() {
        User bob = new User("Bob", 23);
        bob.setSubjects(List.of("Math", "Geography", "Geometry", "Psychical Education"));

        User bruce = new User("Bruce", 25);
        bruce.setSubjects(List.of("Math", "Geography", "Psychical Education"));

        User alice = new User("Alice", 30);
        alice.setSubjects(List.of("Geography", "Geometry", "Psychical Education"));

        Map<User, List<Parent>> users = new HashMap<>();
        users.put(bob, List.of(new Parent("male", "Bob"), new Parent("female", "Marry")));
        users.put(bruce, List.of(new Parent("male", "Bruce"), new Parent("female", "Marry")));
        users.put(alice, List.of(new Parent("male", "Bob"), new Parent("female", "Marry")));


        return users;
    }
}
