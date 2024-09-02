package com.project.usermanagementapplication.service.impl;

import com.project.usermanagementapplication.entity.User;
import com.project.usermanagementapplication.repository.UserRepository;
import com.project.usermanagementapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(@RequestBody int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void deleteUser(User existingUser) {
		userRepository.delete(existingUser);
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
	}

	@Override
	public User updateUser(User existingUser, User user) {
		existingUser.setfirstName(user.getfirstName());
		existingUser.setlastName(user.getlastName());
		existingUser.setAge(user.getAge());
		return existingUser;
	}

}
