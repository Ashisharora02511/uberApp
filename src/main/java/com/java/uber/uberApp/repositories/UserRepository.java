package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
