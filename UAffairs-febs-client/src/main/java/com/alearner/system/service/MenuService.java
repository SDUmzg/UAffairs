package com.alearner.system.service;


import com.alearner.common.domain.Tree;
import com.alearner.common.service.IService;
import com.alearner.system.domain.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

	List<Menu> findUserPermissions(String userName);

	List<Menu> findUserMenus(String userName);

	List<Menu> findAllMenus(Menu menu);

	Tree<Menu> getMenuButtonTree();
	
	Tree<Menu> getMenuTree();
	
	Tree<Menu> getUserMenu(String userName);
	
	Menu findById(Long menuId);

	Menu findByNameAndType(String menuName, String type);

	void addMenu(Menu menu);

	void updateMenu(Menu menu);
	
	void deleteMeuns(String menuIds);
}
