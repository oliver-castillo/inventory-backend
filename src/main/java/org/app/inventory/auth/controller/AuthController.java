package org.app.inventory.auth.controller;

import org.openapitools.api.AuthApi;
import org.openapitools.model.SignInRequest;
import org.openapitools.model.SignInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
  @Override
  public ResponseEntity<SignInResponse> signIn(SignInRequest signInRequest) {
    return AuthApi.super.signIn(signInRequest);
  }
}
