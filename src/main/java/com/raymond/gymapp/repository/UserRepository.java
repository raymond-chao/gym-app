package com.raymond.gymapp.repository;

import com.raymond.gymapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
