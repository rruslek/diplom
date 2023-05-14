package com.example.yotasker.service;

import com.example.yotasker.dto.Login;
import com.example.yotasker.dto.User;
import com.example.yotasker.repo.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepo;
    @Transactional
    public boolean signIn(Login loginDto) {

        User user = usersRepo.findByLogin(loginDto.getLogin());
        return user != null && user.getPassword() == loginDto.getPassword();
    }
}
