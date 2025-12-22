package org.app.inventory.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.app.inventory.util.message.ExceptionInfo;

@Slf4j
public class NotFoundException extends RuntimeException {
  public NotFoundException() {
    super(ExceptionInfo.NOT_FOUND.getMessage());
  }

  public NotFoundException(String resource) {
    super(ExceptionInfo.NOT_FOUND.getMessage() + ": " + resource);
    log.error("{}: {}", ExceptionInfo.NOT_FOUND.getMessage(), resource);
  }
}
