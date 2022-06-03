package solid_ocp.service;

import solid_ocp.model.Account;
import solid_ocp.service.commission.CommissionHandler;
import java.util.Map;

public class CommissionStrategyImpl implements CommissionStrategy {
  private final Map<Account.Type, CommissionHandler> commissionHandlerMap;

  public CommissionStrategyImpl(Map<Account.Type, CommissionHandler> commissionHandlerMap) {
    this.commissionHandlerMap = commissionHandlerMap;
  }

  @Override
  public CommissionHandler get(Account.Type type) {
    CommissionHandler commissionHandler = commissionHandlerMap.get(type);
    if (commissionHandler == null) {
      throw new RuntimeException(
          String.format("I don't now how to work with '%s' account type", type));
    }
    return commissionHandler;
  }
}
