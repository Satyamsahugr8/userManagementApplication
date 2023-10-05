package com.project.usermanagementapplication.repository;

import com.project.usermanagementapplication.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
