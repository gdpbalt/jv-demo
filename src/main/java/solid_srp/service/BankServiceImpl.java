package solid_srp.service;

import solid_srp.dao.AccountDao;
import solid_srp.model.Account;
import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
  private final AccountDao accountDao;

  public BankServiceImpl(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  @Override
  public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
    Account fromAccount = accountDao.get(fromAccountNumber);
    Account toAccount = accountDao.get(toAccountNumber);

    BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
    fromAccount.setAmount(newValueFrom);

    BigDecimal newValueTo = toAccount.getAmount().add(amount);
    toAccount.setAmount(newValueTo);

    accountDao.update(toAccount);
    accountDao.update(fromAccount);
  }
}
