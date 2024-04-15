package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/user")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> editUser(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}