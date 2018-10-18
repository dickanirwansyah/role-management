/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arms.app.entity.Menu;
import com.arms.app.model.MenuActive;
import com.arms.app.model.MenuRole;
import com.arms.app.repository.MenuRepository;
import com.arms.app.repository.MenuRoleRepository;

/**
 *
 * @author albab
 */
@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	MenuRoleRepository menuRoleRepository;

	public List<MenuActive> listMenuActive() {
		List<Menu> all = (List<Menu>) menuRepository.findMenuByLevelMenu(1);
		List<MenuActive> allDetail = new ArrayList<>();
		for (Menu menu : all) {
			MenuActive md = new MenuActive(menu);
			md.setSub(menuRepository.findMenuByParentId(menu.getId()));
			allDetail.add(md);
		}
		return allDetail;
	}
	
	public List<MenuActive> listMenu(String role) {
		List<Menu> all = menuRepository.menuJoin(role);
		List<MenuActive> allDetail = new ArrayList<>();
		for (Menu menu : all) {
			if (menu.getLevelMenu() == 1) {
				List<MenuRole> lsMenuRole = menuRoleRepository.findByAccessIdAndParentIdContaining(role, menu.getId());
				MenuActive md = new MenuActive(menu);
				if (lsMenuRole.size() > 0) {
					List<Menu> lsMenuSub = new ArrayList<>();
					List<Menu> lsSubMenu = menuRepository.findMenuByParentId(menu.getId());
					for (Menu sub : lsSubMenu) {
						for (MenuRole subTree : lsMenuRole) {
							if(sub.getId().equalsIgnoreCase(subTree.getMenuId())){
								lsMenuSub.add(sub);
								md.setSub(lsMenuSub);
							}
						}
					}
				}
				allDetail.add(md);
			}
		}
		return allDetail;
	}
	
}
