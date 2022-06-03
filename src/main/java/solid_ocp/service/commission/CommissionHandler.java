package solid_ocp.service.commission;

import java.math.BigDecimal;

public interface CommissionHandler {
  BigDecimal getCommission(BigDecimal amount);
}
