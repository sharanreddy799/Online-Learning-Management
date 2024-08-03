package com.example.lms;

import com.example.lms.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.lms.entity.*;

@SpringBootApplication
public class LmsApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main( String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdminUser() {
		return args -> {
			if (userRepository.findByUsername("admin") == null) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin")); // Change to a secure password
				admin.setEmail("admin@example.com");
				admin.setRole(Role.ADMIN);
				admin.setEnabled(true);
				userRepository.save(admin);
				System.out.println("Admin user created: admin/adminpassword");
			}
		};
	}
}
