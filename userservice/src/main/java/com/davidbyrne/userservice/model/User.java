package com.davidbyrne.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Collection;


@Entity //this annotation specifies that the class is an entity and is mapped to a database table
@Data //for getters and setters through Lombok
@NoArgsConstructor //Lombok
@AllArgsConstructor //Lombok
public class User { //spring security also has a User class so need to be careful with imports using the right one. common to name this class AppUser usually instead
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username; //would support normal username or email as username
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) //loads the roles at the same time as the user so never a time a user doesnt have roles loaded (good security)
    private Collection<Role> roles = new ArrayList<>();


}
