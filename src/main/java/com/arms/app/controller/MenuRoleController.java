package com.arms.app.controller;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arms.app.model.MenuRole;
import com.arms.app.service.MenuRoleService;
import com.arms.app.service.MenuService;
import com.arms.app.util.ConstantaVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/role")
public class MenuRoleController {
	
	@Autowired
	MenuRoleService menuRoleService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String uploadingPost(@RequestBody List<MenuRole> lsMenuRole) {
		try {
			if(lsMenuRole != null){
				String accessId = lsMenuRole.get(0).getAccessId();
				List<MenuRole> lsMenu = menuRoleService.getByAccessId(accessId);
				if(lsMenu.size() > 0){
					menuRoleService.deleteAll(lsMenu);
				}
				menuRoleService.saveAll(lsMenuRole);
				return ConstantaVariable.MSG.SUCCESS;
			}else{
				return ConstantaVariable.MSG.ROLE_EMPTY;
			}
		} catch (Exception e) {
			return ConstantaVariable.MSG.FAILED;
		}
    }
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/menu-role-active", method = RequestMethod.GET)
	public List menuRole(@RequestParam(value = "user") String user, @RequestParam(value = "role") String role) throws NamingException {
		if (role.equals("1")) {
			return menuService.listMenuActive();
		} else {
			return menuRoleService.listMenuRole(user, role);
		}
	}
	
}