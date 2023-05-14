package com.example.yotasker.controllers;
import com.example.yotasker.dto.Login;
import com.example.yotasker.dto.User;
import com.example.yotasker.repo.UsersRepository;
import com.example.yotasker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowCredentials = "true")
public class AuthController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    ResponseEntity<String> signIn(@RequestBody Login loginDto) {
        boolean ok = usersService.signIn(loginDto);

        if (!ok) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}