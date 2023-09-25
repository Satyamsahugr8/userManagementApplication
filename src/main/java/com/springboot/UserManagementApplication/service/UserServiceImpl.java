package com.springboot.UserManagementApplication.service;

import com.springboot.UserManagementApplication.Entity.User;
import com.springboot.UserManagementApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
	
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
		User s = userRepository.findById(userId).get();
		return s;
	}
	
	@Override
	public void delete(User existingUser) {
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
