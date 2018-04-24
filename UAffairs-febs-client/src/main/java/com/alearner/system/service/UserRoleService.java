package com.alearner.system.service;


import com.alearner.common.service.IService;
import com.alearner.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
