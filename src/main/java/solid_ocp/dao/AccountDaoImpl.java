package solid_ocp.dao;

import solid_ocp.db.Storage;
import solid_ocp.model.Account;

public class AccountDaoImpl implements AccountDao {
  @Override
  public void add(Account account) {
    Storage.accounts.add(account);
  }

  @Override
  public Account get(String accountNumber) {
    return Storage.accounts.stream()
        .filter(a -> a.getNumber().equals(accountNumber))
        .findFirst()
        .orElseThrow(
            () ->
                new RuntimeException(
                    String.format("Account number '%s' not found", accountNumber)));
  }

  @Override
  public void update(Account account) {
    Account accountFromDB = get(account.getNumber());
    Storage.accounts.remove(accountFromDB);
    add(account);
  }
}
