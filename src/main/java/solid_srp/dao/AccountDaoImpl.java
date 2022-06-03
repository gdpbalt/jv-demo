package solid_srp.dao;

import solid_srp.db.Storage;
import solid_srp.model.Account;
import java.util.List;

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
