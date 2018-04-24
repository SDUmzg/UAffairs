package com.alearner.system.service;


import com.alearner.common.service.IService;
import com.alearner.system.domain.User;
import com.alearner.system.domain.UserWithRole;

import java.util.List;

public interface UserService extends IService<User> {

	UserWithRole findById(Long userId);
	
	User findByName(String userName);

	List<User> findUserWithDept(User user);

	void registUser(User user);

	void updateTheme(String theme, String userName);

	void addUser(User user, Long[] roles);

	void updateUser(User user, Long[] roles);
	
	void deleteUsers(String userIds);

	void updateLoginTime(String userName);
	
	void updatePassword(String password);
	
	User findUserProfile(User user);
	
	void updateUserProfile(User user);
}
