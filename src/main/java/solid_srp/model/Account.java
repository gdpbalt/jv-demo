package solid_srp.model;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Account {
  private String number;
  private BigDecimal amount = new BigDecimal(0);

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
        .add("number='" + number + "'")
        .add("amount=" + amount)
        .toString();
  }
}
