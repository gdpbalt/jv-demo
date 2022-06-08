package di.app;

import di.lib.Inject;
import di.model.Account;
import di.model.User;
import di.service.AccountService;
import di.service.AuthenticationManager;
import di.service.BankService;
import java.math.BigDecimal;
import java.util.Optional;

public class ClientApp {
  @SuppressWarnings("unused")
  @Inject
  private BankService bankService;

  @SuppressWarnings("unused")
  @Inject
  private AccountService accountService;

  @SuppressWarnings("unused")
  @Inject
  private AuthenticationManager authenticationManager;

  private User currentUser;

  public void sendMoney(String to, BigDecimal amount) {
    Optional<Account> userAccount = accountService.findByUser(currentUser.name());
    if (userAccount.isEmpty()) {
      throw new RuntimeException(String.format("User %s does not have an account", to));
    }
    bankService.transfer(userAccount.get().getAccountNumber(), to, amount);
  }

  public void login(String login) {
    currentUser =
        accountService
            .findByUser(login)
            .orElseThrow(() -> new RuntimeException(String.format("User %s not found", login)))
            .getOwner();
    authenticationManager.sedCurrentUser(currentUser);
  }
}
