package com.example.springboottodo;

import com.example.springboottodo.auth.RegisterRequest;
import com.example.springboottodo.user.Role;
import com.example.springboottodo.user.User;
import com.example.springboottodo.user.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			PasswordEncoder passwordEncoder
	) {
		return args -> {
			var admin = User.builder()
					.email("admin@mail.com")
					.password(passwordEncoder.encode("password"))
					.role(Role.ADMIN)
					.build();

			userRepository.save(admin);
		};
	}
}
