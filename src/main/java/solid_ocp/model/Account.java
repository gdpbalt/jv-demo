package solid_ocp.model;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Account {
  private String number;
  private BigDecimal amount = new BigDecimal(0);
  private Type type;

  public String getNumber() {
    return number;
  }

  public Account setNumber(String number) {
    this.number = number;
    return this;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Account setAmount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  public Type getType() {
    return type;
  }

  public Account setType(Type type) {
    this.type = type;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
        .add("number='" + number + "'")
        .add("amount=" + amount)
        .add("type=" + type)
        .toString();
  }

  public enum Type {
    REGULAR,
    GOLD,
    PLATINUM,
    USUAL,
    ULTRA
  }
}
