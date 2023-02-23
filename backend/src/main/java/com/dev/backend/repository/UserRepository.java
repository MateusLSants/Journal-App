package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.backend.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{ }
