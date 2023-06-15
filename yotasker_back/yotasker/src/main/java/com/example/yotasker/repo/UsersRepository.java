package com.example.yotasker.repo;

import com.example.yotasker.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);
}