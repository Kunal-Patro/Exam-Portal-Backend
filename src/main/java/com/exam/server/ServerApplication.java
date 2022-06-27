package com.exam.server;

import com.exam.server.models.Role;
import com.exam.server.models.User;
import com.exam.server.models.UserRole;
import com.exam.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Function testing
		User usr = new User();
		usr.setFirstName("Kunal");
		usr.setLastName("Sharma");
		usr.setUsername("patro30");
		usr.setPassword("password");
		usr.setPhone("89476XXXXX");
		usr.setProfile("default.png");
		usr.setEmail("impagal@gmail.com");

		Role role1 = new Role();
		role1.setId(44L);
		role1.setRole("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(usr);
		userRoles.add(userRole);

		User user1 = userService.createUser(usr, userRoles);
		System.out.println(user1);
	}
}
