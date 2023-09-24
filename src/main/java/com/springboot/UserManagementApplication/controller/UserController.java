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

	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable ("id") int userId) {
		User existingUser = userService.findById(userId);
		     existingUser.setfirstName(user.getfirstName());
			 existingUser.setlastName(user.getlastName());
			 existingUser.setAge(user.getAge());
			 userService.saveUser(existingUser);
			 return new ResponseEntity<User>(existingUser,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") int userId) {
		User existingUser = userService.findById(userId);
		User deleteUser = userService.delete(existingUser);
		return new ResponseEntity<User>(existingUser, HttpStatus.OK);
	}

}
