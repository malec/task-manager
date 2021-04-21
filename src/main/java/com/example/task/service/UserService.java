package com.example.task.service;

import com.example.task.dto.TaskDto;
import com.example.task.dto.UserDto;
import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import lombok.var;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder =  passwordEncoder;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        var createResult = this.userRepository.save(user);
        userDto.setId(createResult.getId());
        return userDto;
    }

    public void deleteUser(Long id) {
        var optUser = this.userRepository.findById(id);
        optUser.ifPresent(this.userRepository::delete);
    }

    @Transactional
    public void assignTask(Long userId, Long taskId) {
        var userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()) {
            userRepository.updateUserTaskById(taskId, userId);
        }
    }

    public void deleteAssignment(Long userId) {
        var optUser = this.userRepository.findById(userId);
        if(optUser.isPresent()) {
            var user = optUser.get();
            user.setTask(null);
            this.userRepository.save(user);
        }
    }

    /**
     * @param userId id of the user to login
     * @param password plaintext password of the user
     * @return boolean indicating if the login succeeds
     */
    public boolean login(Long userId, String password) {
        var optUser = this.userRepository.findById(userId);
        return optUser.filter(user -> passwordEncoder.matches(password, user.getPassword())).isPresent();
    }
}
