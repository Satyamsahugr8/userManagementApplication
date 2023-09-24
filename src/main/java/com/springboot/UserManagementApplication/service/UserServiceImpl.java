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
	public User findById(@RequestBody int userId) {
		User s = userRepository.findById(userId).get();
		return s;
	}
//	@Override
//	public User delete(User existingUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public User delete(User existingUser) {
		userRepository.delete(existingUser);
		return existingUser;
	}

	

}
