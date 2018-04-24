package com.alearner.system.dao;

import java.util.List;


import com.alearner.common.config.MyMapper;
import com.alearner.system.domain.Role;
import com.alearner.system.domain.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}