package org.app.inventory.util.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperationMessage {
  CREATED("Resource created"),

  NOT_FOUND("Resource not found"),
  BAD_REQUEST("Bad request"),
  UNAUTHORIZED(""),
  FORBIDDEN(""),
  SERVER_ERROR("");

  private final String message;
}
