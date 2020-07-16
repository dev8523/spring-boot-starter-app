package com.debasish.springbootstarter.user.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.debasish.springbootstarter.user.models.User;
import com.debasish.springbootstarter.user.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userService.updateUser(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(String id) {
		userService.deleteUser(id);
	}
}
