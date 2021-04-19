package com.example.task.controller;

import com.example.task.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface IUserController {
    @PostMapping()
    void create(@RequestBody User user);
    @DeleteMapping()
    void delete(@RequestBody User user);
}
