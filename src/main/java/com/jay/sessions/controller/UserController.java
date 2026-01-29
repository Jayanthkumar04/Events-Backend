package com.jay.sessions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jay.sessions.entity.Role;
import com.jay.sessions.entity.User;
import com.jay.sessions.service.UserService;

@RestController
@RequestMapping("/users")

@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        user.setUserId(id);
        return userService.updateUser(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    // CHANGE ROLE ONLY
    @PatchMapping("/{id}/role")
    public User changeRole(
            @PathVariable Long id,
            @RequestParam Role role) {

        return userService.changeRole(id, role);
    }
}
