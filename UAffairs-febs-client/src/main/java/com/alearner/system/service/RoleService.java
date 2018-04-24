package com.alearner.system.service;


import com.alearner.common.service.IService;
import com.alearner.system.domain.Role;
import com.alearner.system.domain.RoleWithMenu;

import java.util.List;

public interface RoleService extends IService<Role> {

	List<Role> findUserRole(String userName);

	List<Role> findAllRole(Role role);
	
	RoleWithMenu findRoleWithMenus(Long roleId);

	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);
	
	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);
}
