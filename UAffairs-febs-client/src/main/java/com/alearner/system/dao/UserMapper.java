package com.alearner.system.dao;

import java.util.List;


import com.alearner.common.config.MyMapper;
import com.alearner.system.domain.User;
import com.alearner.system.domain.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}