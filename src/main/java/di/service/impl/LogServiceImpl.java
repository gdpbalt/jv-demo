package di.service.impl;

import di.service.LogService;

public class LogServiceImpl implements LogService {
  @Override
  public void log(String message) {
    System.out.println(message);
  }
}
