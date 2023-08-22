package com.davidbyrne.userservice.api;

import com.davidbyrne.userservice.model.Role;
import com.davidbyrne.userservice.model.User;
import com.davidbyrne.userservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//The main difference between Controller and RestController Annotation is ResponseBody Annotation.
//Controller annotation does not call @ResponseBody to all Controller's method itself.
//Whereas @RestController combines Controller and @ResponseBody, which use @ResponseBody to all its methods by default.
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers()); //these returns first send a message of success/fail etc. then the body is what service method gets run
    }

    @PostMapping("/user/save") //this creates a new user
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user)); //sending status that something was created. can removed and replaced with null
    }

    @PostMapping("/role/save") //creates a new role
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName()); //no return type here (notice in service class that this method returns void, so here use "?")
        return ResponseEntity.ok().build(); //this is just returning status message is all, no value
    }

}

@Data //used for getters and setters
//this class is used just for the addRoleToUser method. just to group the username and roleName into one
//just a class used for when users are passing in username and roleName into addRoleToUser method
class RoleToUserForm{
    private String username;
    private String roleName;
}
