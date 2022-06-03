package solid_ocp.dao;

import solid_ocp.model.Account;

public interface AccountDao {
  void add(Account account);

  Account get(String accountNumber);

  void update(Account account);
}
