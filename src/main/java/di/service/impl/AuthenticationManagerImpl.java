package di.service.impl;

import di.lib.Inject;
import di.model.Account;
import di.model.User;
import di.service.AccountService;
import di.service.AuthenticationManager;
import java.util.Optional;

public class AuthenticationManagerImpl implements AuthenticationManager {
  @SuppressWarnings("unused")
  @Inject
  private AccountService accountService;

  private User currentUser;

  @Override
  public void sedCurrentUser(User user) {
    currentUser = user;
  }

  @Override
  public boolean hasPermission(String accountNumber) {
    Optional<Account> byNumber = accountService.findByNumber(accountNumber);
    User owner =
        byNumber
            .orElseThrow(
                () ->
                    new RuntimeException(
                        String.format("Account with number %s not found", accountNumber)))
            .getOwner();
    return owner.equals(currentUser);
  }
}
