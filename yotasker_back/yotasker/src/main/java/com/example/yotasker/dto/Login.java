package com.example.yotasker.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}