package com.davidbyrne.userservice;

import com.davidbyrne.userservice.model.Role;
import com.davidbyrne.userservice.model.User;
import com.davidbyrne.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	//this is instead of using postman basically. making new roles and users. adding roles to the users.
	CommandLineRunner run(UserService userService){ //injecting the UserService interface into this command line
		return args -> { //everything in these curly braces will run when the app is initialised
			userService.saveRole(new Role(null, "ROLE_USER")); //id is null as JPA will create the ID (@GeneratedValue(strategy = GenerationType.AUTO))
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Dave Byrne", "davidthegoliath", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Eoin Hassett", "eoingoal", "4321", new ArrayList<>()));
			userService.saveUser(new User(null, "Gavin Smith", "gavinator", "5678", new ArrayList<>()));
			userService.saveUser(new User(null, "Tom Drennan", "bigtom", "8765", new ArrayList<>()));

			userService.addRoleToUser("davidthegoliath", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("davidthegoliath", "ROLE_USER");
			userService.addRoleToUser("eoingoal", "ROLE_USER");
			userService.addRoleToUser("gavinator", "ROLE_ADMIN");
			userService.addRoleToUser("bigtom", "ROLE_MANAGER");
			userService.addRoleToUser("bigtom", "ROLE_USER");

		};
	}

}
