package com.hw.todo.repository;

import com.hw.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // For registration
    boolean existsByEmailAddress(String emailAddress);

    // For login
    User findUserByEmailAddress(String emailAddress);
}
