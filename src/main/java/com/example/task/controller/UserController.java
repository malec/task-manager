package com.example.task.controller;

import com.example.task.dto.User;
import com.example.task.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void create(User user) {
        this.userService.createUser(user);
    }

    @Override
    public void delete(User user) {
        this.userService.deleteUser(user.getId());
    }
}
