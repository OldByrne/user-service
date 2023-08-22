package com.davidbyrne.userservice.service;

import com.davidbyrne.userservice.model.Role;
import com.davidbyrne.userservice.model.User;
import java.util.List;

public interface UserService { //interface used to define methods
    User saveUser(User user); //to save a user
    Role saveRole(Role role); //to save a role
    void addRoleToUser(String username, String roleName); //to add a role to a user, doesnt return anything, just actions so void
    User getUser(String username); //pass a username to get a certain user
    List<User> getUsers(); // get list of users. not usually used in real world as there can be thousands. would be filtered for fewer results for instance

}
