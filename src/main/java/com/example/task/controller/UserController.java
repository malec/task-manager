package com.example.task.controller;

import com.example.task.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {
    @PostMapping()
    public void create(@RequestBody User user);
    @DeleteMapping()
    public void delete(@RequestBody User user);
}
