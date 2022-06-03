package solid_ocp.service;

import solid_ocp.model.Account;
import solid_ocp.service.commission.CommissionHandler;

public interface CommissionStrategy {
  CommissionHandler get(Account.Type type);
}
