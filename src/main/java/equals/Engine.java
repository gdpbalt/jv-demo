package equals;

public class Engine implements Cloneable {
    private String type;
    private int issueYear;
    private String brand;
    private String fuelName;
    private int power;

    public Engine() { //please don't remove this constructor!
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Engine object", e);
        }
    }

    public Engine(String type, int issueYear, String brand, String fuelName, int power) {
        this.type = type;
        this.issueYear = issueYear;
        this.brand = brand;
        this.fuelName = fuelName;
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("Engine{type='%s'(%d), issueYear='%d', brand='%s', fuelName='%s, power='%d'}",
                type, System.identityHashCode(type), issueYear, brand, fuelName, power);
    }
}
