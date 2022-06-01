package stream;

public class Parent {
    private final String sex;
    private final String name;

    public Parent(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
