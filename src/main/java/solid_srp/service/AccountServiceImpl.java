package solid_srp.service;

import solid_srp.dao.AccountDao;
import solid_srp.model.Account;

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
