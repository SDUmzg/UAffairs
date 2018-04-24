package com.alearner.system.service.impl;

import java.util.Arrays;
import java.util.List;

import com.alearner.common.service.impl.BaseService;
import com.alearner.system.domain.RoleMenu;
import com.alearner.system.service.RoleMenuServie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseService<RoleMenu> implements RoleMenuServie {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRoleMenusByRoleId(String roleIds) {
		List<String> list = Arrays.asList(roleIds.split(","));
		this.batchDelete(list, "roleId", RoleMenu.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRoleMenusByMenuId(String menuIds) {
		List<String> list = Arrays.asList(menuIds.split(","));
		this.batchDelete(list, "menuId", RoleMenu.class);
	}

}
