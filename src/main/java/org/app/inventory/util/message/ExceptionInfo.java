package org.app.inventory.util.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionInfo {
  NOT_FOUND("NOT_FOUND", "Resource not found"),
  BAD_REQUEST("BAD_REQUEST", "Bad request"),
  UNAUTHORIZED("UNAUTHORIZED", ""),
  FORBIDDEN("FORBIDDEN", ""),
  SERVER_ERROR("SERVER_ERROR", "");

  private final String code;
  private final String message;

}
