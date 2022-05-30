enum DayOfWeek {
  FRIDAY(4, "friday"),
  SATURDAY(5, "saturday"),
  SUNDAY(6, "sunday");

  private final int index;
  private final String value;

  DayOfWeek(int index, String value) {
    this.index = index;
    this.value = value;
  }

  public int getIndex() {
    return index;
  }

  @Override
  public String toString() {
    return value;
  }
}
