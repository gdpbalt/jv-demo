public class Plane {
  private final String type;
  private final String brand;
  private final int issueYear;
  private final int nextServicesYear;
  private final int places;

  private Plane(PlaneBuilder builder) {
    this.type = builder.type;
    this.brand = builder.brand;
    this.issueYear = builder.issueYear;
    this.nextServicesYear = builder.nextServicesYear;
    this.places = builder.places;
  }

  @Override
  public String toString() {
    return "Plane{"
        + "type='"
        + type
        + '\''
        + ", brand='"
        + brand
        + '\''
        + ", issueYear="
        + issueYear
        + ", nextServicesYear="
        + nextServicesYear
        + ", places="
        + places
        + '}';
  }

  public static class PlaneBuilder {
    private String type;
    private String brand;
    private int issueYear;
    private int nextServicesYear;
    private int places;

    public PlaneBuilder setType(String type) {
      this.type = type;
      return this;
    }

    public PlaneBuilder setBrand(String brand) {
      this.brand = brand;
      return this;
    }

    public PlaneBuilder setIssueYear(int issueYear) {
      this.issueYear = issueYear;
      return this;
    }

    public PlaneBuilder setNextServicesYear(int nextServicesYear) {
      this.nextServicesYear = nextServicesYear;
      return this;
    }

    public PlaneBuilder setPlaces(int places) {
      this.places = places;
      return this;
    }

    public Plane build() {
      return new Plane(this);
    }
  }
}
