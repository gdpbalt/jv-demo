package di;

import di.app.ClientApp;
import di.lib.Injector;
import di.service.impl.AccountServiceImpl;
import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {
    Injector injector = Injector.getInjector();
    ClientApp clientApp = (ClientApp) injector.getInstance(ClientApp.class);

    clientApp.login("bob");
    clientApp.sendMoney("5678", BigDecimal.valueOf(100));

    AccountServiceImpl.accounts.forEach(System.out::println);
  }
}
