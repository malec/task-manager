package com.example.task.repository;

import com.example.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("update User u set u.task.id =?1 where u.id =?2")
    void updateUserTaskById(Long taskId, Long userId);
}
