package com.kit.service;

import com.kit.entity.User;

public interface UserService {

	public User saveUser(User user);
	public void removeSessionMessage();
}
