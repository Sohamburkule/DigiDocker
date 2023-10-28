package com.DigiDocker.dao;

import com.DigiDocker.entity.User;

public interface UserDao {

    public int saveUser(User user);
	
	public User login(String email, String password);

}
