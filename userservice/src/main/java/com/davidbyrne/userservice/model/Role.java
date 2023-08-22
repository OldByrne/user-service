package com.davidbyrne.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //this annotation specifies that the class is an entity and is mapped to a database table
@Data //for getters and setters through Lombok
@NoArgsConstructor //Lombok
@AllArgsConstructor //Lombok
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
