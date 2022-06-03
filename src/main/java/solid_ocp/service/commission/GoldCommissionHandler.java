package solid_ocp.service.commission;

import java.math.BigDecimal;

public class GoldCommissionHandler implements CommissionHandler {
  @Override
  public BigDecimal getCommission(BigDecimal amount) {
    return new BigDecimal("3");
  }
}
