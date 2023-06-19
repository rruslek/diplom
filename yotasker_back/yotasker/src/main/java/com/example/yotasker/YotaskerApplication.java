package com.example.yotasker;

import com.example.yotasker.dto.RegisterRequest;
import com.example.yotasker.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.yotasker.dto.Role.ADMIN;
import static com.example.yotasker.dto.Role.MANAGER;

@SpringBootApplication
public class YotaskerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YotaskerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admina")
					.lastname("Admina")
					.email("admin@mail.com")
					.password("password123")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}

}
