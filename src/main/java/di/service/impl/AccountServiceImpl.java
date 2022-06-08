package di.service.impl;

import di.model.Account;
import di.model.User;
import di.service.AccountService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
  public static final List<Account> accounts = new ArrayList<>();

  static {
    User bob = new User("bob", 23);
    User alice = new User("alice", 19);

    Account accountBob = new Account("1234", bob);
    accountBob.setBalance(BigDecimal.valueOf(500));
    Account accountAlice = new Account("5678", alice);
    accountAlice.setBalance(BigDecimal.valueOf(500));

    accounts.add(accountBob);
    accounts.add(accountAlice);
  }

  @Override
  public Optional<Account> findByNumber(String accountNumber) {
    return accounts.stream().filter(u -> u.getAccountNumber().equals(accountNumber)).findFirst();
  }

  @Override
  public Optional<Account> findByUser(String userName) {
    return accounts.stream().filter(u -> u.getOwner().name().equals(userName)).findFirst();
  }

  @Override
  public void setBalance(Account account, BigDecimal amount) {
    Account foundAccount =
        accounts.stream()
            .filter(a -> a.equals(account))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Account not found"));
    foundAccount.setBalance(amount);
  }
}
