package solid_srp.dao;

import solid_srp.model.Account;

public interface AccountDao {
  void add(Account account);

  Account get(String accountNumber);

  void update(Account account);
}
