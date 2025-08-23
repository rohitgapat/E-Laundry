package com.Service;

import java.util.List;

import com.entity.User;

public interface UserService {

	public User addNewUser(User user);
	public User findUserById(Long user_id);
	public List<User> getAllUesr();
}
