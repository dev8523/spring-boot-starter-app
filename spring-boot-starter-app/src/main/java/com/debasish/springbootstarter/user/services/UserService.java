package com.debasish.springbootstarter.user.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.debasish.springbootstarter.user.models.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<>( Arrays.asList(
			new User("1", "Debasish", "Welcome to Spring Boot"),
			new User("2", "Ashish", "Welcome to Java"), 
			new User("3", "Salemon", "Welcome to Python")
			));

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserById(String id) {
		return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void updateUser(String id, User user) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.set(i, user);
				return;
			}
		}
	}
	
	public void deleteUser(String id) {
		users.removeIf(u -> u.getId().equals(id));
	}
}
