package com.alearner.system.service.impl;

import java.util.Arrays;
import java.util.List;

import com.alearner.system.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alearner.common.service.impl.BaseService;
import com.alearner.system.domain.UserRole;

@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserRolesByRoleId(String roleIds) {
		List<String> list = Arrays.asList(roleIds.split(","));
		this.batchDelete(list, "roleId", UserRole.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserRolesByUserId(String userIds) {
		List<String> list = Arrays.asList(userIds.split(","));
		this.batchDelete(list, "userId", UserRole.class);
	}

}
