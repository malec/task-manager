package com.example.task.controller;

import com.example.task.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface IUserController {
    @PostMapping()
    UserDto create(@RequestBody UserDto user);
    @DeleteMapping()
    void delete(@RequestBody UserDto user);
}
