package di.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Account {
  private final String accountNumber;
  private final User user;
  private BigDecimal balance;

  public Account(String accountNumber, User user) {
    this.accountNumber = accountNumber;
    this.user = user;
    balance = BigDecimal.valueOf(0);
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public User getOwner() {
    return user;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equals(accountNumber, account.accountNumber)
        && Objects.equals(user, account.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, user);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
        .add("accountNumber='" + accountNumber + "'")
        .add("balance=" + balance)
        .add("user=" + user)
        .toString();
  }
}
