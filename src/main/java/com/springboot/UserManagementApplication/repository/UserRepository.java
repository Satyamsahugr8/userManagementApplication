package com.springboot.UserManagementApplication.repository;

import com.springboot.UserManagementApplication.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
