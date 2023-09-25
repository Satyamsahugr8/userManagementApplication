package com.springboot.UserManagementApplication.service;


import com.springboot.UserManagementApplication.Entity.User;

import java.util.List;

public interface UserService {
	
	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(int userId);

	void delete(User existingUser);

	void deleteAllUser();

	User updateUser(User user, User existingUser);
}
