package com.springboot.UserManagementApplication.controller;

import com.springboot.UserManagementApplication.Entity.User;
import com.springboot.UserManagementApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existingUser = this.userService.findById(userId);
		     existingUser.setFirstName(user.getFirstName());
			 existingUser.setLastName(user.getLastName());
			 existingUser.setAge(user.getAge());
			 return this.userService.saveUser(existingUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId) {
		User existingUser = this.userService.findById(userId);
		User deleteUser = this.userService.delete(existingUser);
		return ResponseEntity.ok().build();
	}

}
