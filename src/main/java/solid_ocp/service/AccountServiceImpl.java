package solid_ocp.service;

import solid_ocp.dao.AccountDao;
import solid_ocp.model.Account;

public class AccountServiceImpl implements AccountService {
  private final AccountDao accountDao;

  public AccountServiceImpl(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  @Override
  public Account createNewAccount(String accountNumber) {
    Account account = new Account();
    account.setNumber(accountNumber);
    accountDao.add(account);
    return account;
  }
}
