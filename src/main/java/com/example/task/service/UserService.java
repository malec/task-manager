package com.example.task.service;

import com.example.task.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {
    private final Map<String, User> users;
    public UserService() {
        this.users = new HashMap<>();
    }
    public void createUser(User user) {
        this.users.put(user.getId(), user);
    }
    public void deleteUser(String id) {
        this.users.remove(id);
    }
    public void assignTask(String userId, String taskId) {
        this.users.get(userId).setTaskId(taskId);
    }
    public void deleteAssignment(String userId) {
        this.users.get(userId).setTaskId(null);
    }
}
