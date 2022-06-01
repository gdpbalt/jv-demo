package stream;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final int age;
    private List<String> subjects;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        subjects = new ArrayList<>();
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                '}';
    }
}
