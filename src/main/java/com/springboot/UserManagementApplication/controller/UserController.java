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
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable ("id") int id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable ("id") int userId) {
		User existingUser = userService.getUserById(userId);
		userService.updateUser(existingUser, user);
		userService.saveUser(existingUser);
		return new ResponseEntity<User>(existingUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable ("id") int userId) {
		User existingUser = userService.getUserById(userId);
		userService.deleteUser(existingUser);
		return new ResponseEntity<String>("user Deleted", HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllUsers() {
		userService.deleteAllUser();
		return new ResponseEntity<String>("all user Deleted", HttpStatus.OK);
	}

}
