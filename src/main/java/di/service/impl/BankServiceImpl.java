package di.service.impl;

import di.lib.Inject;
import di.model.Account;
import di.service.AccountService;
import di.service.AuthenticationManager;
import di.service.BankService;
import di.service.LogService;
import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
  @SuppressWarnings("unused")
  @Inject
  private AuthenticationManager authenticationManager;

  @SuppressWarnings("unused")
  @Inject
  private AccountService accountService;

  @SuppressWarnings("unused")
  @Inject
  private LogService logService;

  @Override
  public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
    logService.log(
        String.format(
            "Method transfer. Transfer money %s from %s to %s", amount, accountFrom, accountTo));

    Optional<Account> sender = accountService.findByNumber(accountFrom);
    Optional<Account> receiver = accountService.findByNumber(accountTo);

    if (sender.isEmpty() || receiver.isEmpty()) {
      throw new RuntimeException(
          String.format("Can't send money from %s to %s", accountFrom, accountTo));
    }

    if (!authenticationManager.hasPermission(accountFrom)) {
      throw new RuntimeException("You can't permission to send money ...");
    }

    if (sender.get().getBalance().compareTo(amount) < 0) {
      throw new RuntimeException("Not enough money ...");
    }

    accountService.setBalance(sender.get(), sender.get().getBalance().subtract(amount));
    accountService.setBalance(receiver.get(), receiver.get().getBalance().add(amount));
  }
}
