package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.Component.User;
import com.eduhub.eduhub_backend.Exceptions.MethodNotAllowedException;
import com.eduhub.eduhub_backend.Exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    List<User> userList = new ArrayList<>();

    // Global static list with 5 entries
    public UserController() {

        userList.add(new User(1, "Ram", "ram123"));
        userList.add(new User(2, "Sam", "sam123"));
        userList.add(new User(3, "Arun", "arun123"));
        userList.add(new User(4, "Kumar", "kumar123"));
        userList.add(new User(5, "John", "john123"));
    }

    // 3. Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<>(
                userList,
                HttpStatus.OK
        );
    }

    // 4 & 5. Get user using PathVariable
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(
            @PathVariable String userId) {

        // Check special characters
        if (!userId.matches("[0-9]+")) {

            throw new IllegalArgumentException(
                    "User ID contains special characters"
            );
        }

        int id = Integer.parseInt(userId);

        for (User user : userList) {

            if (user.getUserId() == id) {

                return new ResponseEntity<>(
                        user,
                        HttpStatus.OK
                );
            }
        }

        throw new ResourceNotFoundException(
                "User",
                "userId",
                userId
        );
    }

    // 5. Get user using RequestParam
    @GetMapping("/search")
    public ResponseEntity<User> searchUser(
            @RequestParam String userId) {

        if (!userId.matches("[0-9]+")) {

            throw new IllegalArgumentException(
                    "User ID contains special characters"
            );
        }

        int id = Integer.parseInt(userId);

        for (User user : userList) {

            if (user.getUserId() == id) {

                return new ResponseEntity<>(
                        user,
                        HttpStatus.OK
                );
            }
        }

        throw new ResourceNotFoundException(
                "User",
                "userId",
                userId
        );
    }

    // 6. Add new user
    @PostMapping
    public ResponseEntity<User> addUser(
            @RequestBody User user) {

        userList.add(user);

        return new ResponseEntity<>(
                user,
                HttpStatus.CREATED
        );
    }

    // 7. Update password
    @PutMapping("/{userId}")
    public ResponseEntity<User> updatePassword(
            @PathVariable int userId,
            @RequestBody User updatedUser) {

        for (User user : userList) {

            if (user.getUserId() == userId) {

                user.setPassword(updatedUser.getPassword());

                return new ResponseEntity<>(
                        user,
                        HttpStatus.OK
                );
            }
        }

        throw new ResourceNotFoundException(
                "User",
                "userId",
                String.valueOf(userId)
        );
    }

    // 8. Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(
            @PathVariable int userId) {

        for (User user : userList) {

            if (user.getUserId() == userId) {

                userList.remove(user);

                return new ResponseEntity<>(
                        "User deleted successfully",
                        HttpStatus.OK
                );
            }
        }

        throw new MethodNotAllowedException(
                "Delete operation failed"
        );
    }
}