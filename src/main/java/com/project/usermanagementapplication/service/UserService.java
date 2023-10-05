package com.project.usermanagementapplication.service;


import com.project.usermanagementapplication.entity.User;

import java.util.List;

public interface UserService {
	
	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(int userId);

	void deleteUser(User existingUser);

	void deleteAllUser();

	User updateUser(User user, User existingUser);
}
