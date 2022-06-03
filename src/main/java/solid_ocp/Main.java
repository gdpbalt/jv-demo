package solid_ocp;

import solid_ocp.service.AccountService;
import solid_ocp.dao.AccountDao;
import solid_ocp.dao.AccountDaoImpl;
import solid_ocp.db.Storage;
import solid_ocp.model.Account;
import solid_ocp.service.AccountServiceImpl;
import solid_ocp.service.BankService;
import solid_ocp.service.BankServiceImpl;
import solid_ocp.service.CommissionStrategy;
import solid_ocp.service.CommissionStrategyImpl;
import solid_ocp.service.commission.CommissionHandler;
import solid_ocp.service.commission.GoldCommissionHandler;
import solid_ocp.service.commission.PlatinumCommissionHandler;
import solid_ocp.service.commission.RegularCommissionHandler;
import solid_ocp.service.commission.UltraCommissionHandler;
import solid_ocp.service.commission.UsualCommissionHandler;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<Account.Type, CommissionHandler> commissionHandlerMap = new HashMap<>();

    AccountDao accountDao = new AccountDaoImpl();
    AccountService accountService = new AccountServiceImpl(accountDao);
    CommissionStrategy commissionStrategy = new CommissionStrategyImpl(commissionHandlerMap);
    BankService bankService = new BankServiceImpl(accountDao, commissionStrategy);

    createNewAccounts(accountService);
    createCommissionHandlerMap(commissionHandlerMap);

    Storage.accounts.forEach(System.out::println);
    bankService.transfer("910", "123", BigDecimal.valueOf(10));
    System.out.println("After transfer");
    Storage.accounts.forEach(System.out::println);
  }

  private static void createNewAccounts(AccountService accountService) {
    Account account;
    account = accountService.createNewAccount("123");
    account.setAmount(BigDecimal.valueOf(10)).setType(Account.Type.USUAL);
    account = accountService.createNewAccount("345");
    account.setAmount(BigDecimal.valueOf(20)).setType(Account.Type.USUAL);
    account = accountService.createNewAccount("678");
    account.setAmount(BigDecimal.valueOf(30)).setType(Account.Type.USUAL);
    account = accountService.createNewAccount("910");
    account.setAmount(BigDecimal.valueOf(40)).setType(Account.Type.USUAL);
  }

  private static void createCommissionHandlerMap(Map<Account.Type, CommissionHandler> map) {
    map.put(Account.Type.REGULAR, new RegularCommissionHandler());
    map.put(Account.Type.GOLD, new GoldCommissionHandler());
    map.put(Account.Type.PLATINUM, new PlatinumCommissionHandler());
    map.put(Account.Type.USUAL, new UsualCommissionHandler());
    map.put(Account.Type.ULTRA, new UltraCommissionHandler());
  }
}
