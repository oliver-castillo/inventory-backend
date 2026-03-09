package org.app.inventory.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.app.inventory.util.message.OperationMessage;

@Slf4j
public class NotFoundException extends RuntimeException {

  public NotFoundException(String resource) {
    super(OperationMessage.NOT_FOUND.getMessage() + ": " + resource);
    log.error("{}: {}", OperationMessage.NOT_FOUND.getMessage(), resource);
  }
}
