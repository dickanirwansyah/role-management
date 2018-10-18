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

@Service
public class MenuRoleService {
	@Autowired
	MenuRoleRepository menuRoleRepository;

	@Autowired
	MenuRepository menuRepository;

	public List<MenuRole> getAll() {
		return (List<MenuRole>) menuRoleRepository.findAll();
	}

	public List<MenuRole> getByAccessId(String accessId) {
		return (List<MenuRole>) menuRoleRepository.findByAccessId(accessId);
	}

	public void delete(String accessId) {
		menuRoleRepository.deleteByAccessId(accessId);
	}

	public void deleteAll(List<MenuRole> lsMenuRole) {
		menuRoleRepository.delete(lsMenuRole);
	}

	public void saveAll(List<MenuRole> lsMenuRole) {
		menuRoleRepository.save(lsMenuRole);
	}

	public void save(MenuRole menuRole) {
		menuRoleRepository.save(menuRole);
	}
	
	public List<MenuRole> getByParentId(String accessId, String parentId) {
		return (List<MenuRole>) menuRoleRepository.findByAccessIdAndParentIdContaining(accessId, parentId);
	}
	
	public List<MenuActive> listMenuRole(String accessId, String role) {
		List<Menu> all = menuRepository.menuJoin(role);
		List<MenuActive> allDetail = new ArrayList<>();
		for (Menu menu : all) {
			if (menu.getLevelMenu() == 1) {
				List<MenuRole> lsMenuRole = getByParentId(accessId, menu.getId());
				MenuActive md = new MenuActive(menu);
				if (lsMenuRole.size() > 0) {
					md.setSub(menuRepository.findMenuByParentId(menu.getId()));
				}
				allDetail.add(md);
			}
		}
		return allDetail;
	}

}
