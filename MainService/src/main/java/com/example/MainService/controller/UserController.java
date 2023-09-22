package com.example.MainService.controller;

import com.example.MainService.model.User;
import com.example.MainService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity saveUser(
            @RequestBody User user
    ) {

        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity updateUser(
            @RequestBody User user
    ) {
        userService.update(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity updateUser(
            @RequestParam("id") Long id
    ) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
