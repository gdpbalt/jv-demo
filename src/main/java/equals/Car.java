package equals;

public class Car implements Cloneable {
    private Engine engine;
    private String name;
    private String color;
    private String brand;
    private int issueYear;

    public Car() { //please don't remove this constructor!
    }

    @Override
    public Car clone() {
        try {
            Car object = (Car) super.clone();
            object.engine = this.engine.clone();
            return object;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Car", e);
        }
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(Engine engine, String name, String color, String brand, int issueYear) {
        this.engine = engine;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.issueYear = issueYear;
    }

    @Override
    public String toString() {
        return String.format("Car{engine='%s'(%d), name='%s', color='%s', brand='%s', issueYear='%d'}",
                engine, System.identityHashCode(engine), name, color, brand, issueYear);
    }
}
