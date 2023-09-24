package com.springboot.UserManagementApplication.service;


import com.springboot.UserManagementApplication.Entity.User;

import java.util.List;

public interface UserService {
	
	User saveUser(User user);


//	User getAllUsers(User user);


	List<User> getAllUsers();


	User findById(long userId);


	User delete(User existingUser);




	

}
