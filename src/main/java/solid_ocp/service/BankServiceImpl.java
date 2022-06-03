package solid_ocp.service;

import solid_ocp.dao.AccountDao;
import solid_ocp.model.Account;
import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
  private final AccountDao accountDao;
  private final CommissionStrategy commissionStrategy;

  public BankServiceImpl(AccountDao accountDao, CommissionStrategy commissionStrategy) {
    this.accountDao = accountDao;
    this.commissionStrategy = commissionStrategy;
  }

  @Override
  public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
    Account fromAccount = accountDao.get(fromAccountNumber);
    Account toAccount = accountDao.get(toAccountNumber);

    BigDecimal commission = commissionStrategy.get(fromAccount.getType()).getCommission(amount);
    System.out.printf("Get commission '%s'%n", commission);

    BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount).subtract(commission);
    fromAccount.setAmount(newValueFrom);

    BigDecimal newValueTo = toAccount.getAmount().add(amount);
    toAccount.setAmount(newValueTo);

    accountDao.update(toAccount);
    accountDao.update(fromAccount);
  }
}
