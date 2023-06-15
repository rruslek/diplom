package com.example.yotasker.service;

import com.example.yotasker.dto.AuthRequest;
import com.example.yotasker.dto.User;
import com.example.yotasker.repo.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepo;

}
