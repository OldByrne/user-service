package com.davidbyrne.userservice.service;

import com.davidbyrne.userservice.model.Role;
import com.davidbyrne.userservice.model.User;
import com.davidbyrne.userservice.repository.RoleRepo;
import com.davidbyrne.userservice.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //specifying this is a service class
@RequiredArgsConstructor //makes the below repo injections work. passes the 2 repos through a constructor. makes dependency injection work
@Transactional //"When you are manipulating data I would suggest using this annotation." could use more research into
@Slf4j //logging api that generate logs/traces to see whats happening and if anything goes wrong

public class UserServiceImpl implements UserService{
    private final UserRepo userRepo; //injecting the repos. communicating with JPA directly
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName()); //this is how you add log entries to trace when this method runs
        return userRepo.save(user); //save is a JPA method built in for use. again JPA doing the heavy DB lifting
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName()); //the {} is used to populate the result of "role.getName()"
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) { //this is a simple method. in real life there would be validation on the users etc (if exists type thing)
        log.info("Adding role {} to the user {}", roleName, username); //does brackets in order
        User user = userRepo.findByUsername(username); //getting user DB entry (by username) and mapping to User object
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role); //first gets all the roles already on the user and then just adds on this new one
        //since we have the @Transactional annotation above, once this method runs it will also save to the DB. no need for more code to save to DB.
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username); //return User object that has the provided username
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
