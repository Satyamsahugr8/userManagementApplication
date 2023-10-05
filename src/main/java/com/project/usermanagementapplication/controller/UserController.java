package com.project.usermanagementapplication.controller;

import com.project.usermanagementapplication.entity.User;
import com.project.usermanagementapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable ("id") int id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable ("id") int userId) {
		User existingUser = userService.getUserById(userId);
		userService.updateUser(existingUser, user);
		userService.saveUser(existingUser);
		return new ResponseEntity<>(existingUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable ("id") int userId) {
		User existingUser = userService.getUserById(userId);
		userService.deleteUser(existingUser);
		return new ResponseEntity<>("user Deleted", HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllUsers() {
		userService.deleteAllUser();
		return new ResponseEntity<>("all user Deleted", HttpStatus.OK);
	}

}
