package di.service;

import di.model.Account;
import java.math.BigDecimal;
import java.util.Optional;

public interface AccountService {
  Optional<Account> findByNumber(String accountNumber);

  Optional<Account> findByUser(String userName);

  void setBalance(Account account, BigDecimal amount);
}
