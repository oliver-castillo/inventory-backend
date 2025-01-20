package com.app.inventory.api.user;

import com.app.inventory.api.user.dto.request.UserRequest;
import com.app.inventory.api.user.dto.response.UserResponse;
import com.app.inventory.api.user.mapper.UserApiMapper;
import com.app.inventory.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;
    private final UserApiMapper userApiMapper;

    @PostMapping
    ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userApiMapper.toModel(userRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        userService.updateUser(id, userApiMapper.toModel(userRequest));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService
                .findAll()
                .stream()
                .map(userApiMapper::toResponse)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userApiMapper.toResponse(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userApiMapper.toResponse(userService.findByEmail(email)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
