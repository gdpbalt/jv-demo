package solid_srp;

import solid_srp.dao.AccountDao;
import solid_srp.dao.AccountDaoImpl;
import solid_srp.db.Storage;
import solid_srp.model.Account;
import solid_srp.service.AccountService;
import solid_srp.service.AccountServiceImpl;
import solid_srp.service.BankService;
import solid_srp.service.BankServiceImpl;
import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {
    AccountDao accountDao = new AccountDaoImpl();
    AccountService accountService = new AccountServiceImpl(accountDao);
    BankService bankService = new BankServiceImpl(accountDao);

    createNewAccounts(accountService);

    Storage.accounts.forEach(System.out::println);
    bankService.transfer("910", "123", BigDecimal.valueOf(10));
    System.out.println("After transfer");
    Storage.accounts.forEach(System.out::println);
  }

  private static void createNewAccounts(AccountService accountService) {
    Account account;
    account = accountService.createNewAccount("123");
    account.setAmount(BigDecimal.valueOf(10));
    account = accountService.createNewAccount("345");
    account.setAmount(BigDecimal.valueOf(20));
    account = accountService.createNewAccount("678");
    account.setAmount(BigDecimal.valueOf(30));
    account = accountService.createNewAccount("910");
    account.setAmount(BigDecimal.valueOf(40));
  }
}
