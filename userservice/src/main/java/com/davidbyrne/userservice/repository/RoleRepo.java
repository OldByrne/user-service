package com.davidbyrne.userservice.repository;

import com.davidbyrne.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> { //specifying it'll be a repo for User model class of primary key type Long
    Role findByName(String name);
}
