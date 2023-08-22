package com.davidbyrne.userservice.repository;

import com.davidbyrne.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository; //does the heavy lifting with DB transactions etc

public interface UserRepo extends JpaRepository<User, Long> { //specifying it'll be a repo for User model class of primary key type Long
    User findByUsername(String username); //method name format import here, interpreted by spring data JPA as a select statement. returns User type

    //think you add methods here that require sending something into the DB, like adding entries or passing a certain ID to get an entry (could be wrong, need to check this)
    //also seems to be where JPA will try to interpret a method name and perform the action it interprets
}
