package com.example.task.controller;

import com.example.task.dto.User;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController implements IUserController {
    @Override
    public void create(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
