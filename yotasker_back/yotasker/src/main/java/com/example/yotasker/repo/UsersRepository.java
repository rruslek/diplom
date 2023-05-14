package com.example.yotasker.repo;

import com.example.yotasker.dto.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByLogin(String login);
}