package com.example.task.service;

import com.example.task.dto.UserDto;
import com.example.task.dto.UserDto;
import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        this.userRepository.save(user);
    }
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
    public void assignTask(Long userId, String taskId) {
        var userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()) {
            var user = userOptional.get();
            user.setTaskId(taskId);
            this.userRepository.save(user);
        }
    }
    public void deleteAssignment(Long userId) {
//        this.userRepository..get(userId).setTaskId(null);
    }
}
