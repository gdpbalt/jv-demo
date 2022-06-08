package di.service;

import di.model.User;

public interface AuthenticationManager {
  void sedCurrentUser(User user);

  boolean hasPermission(String accountNumber);
}
