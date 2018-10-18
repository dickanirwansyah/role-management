
package com.arms.app.controller;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arms.app.repository.MenuRepository;
import com.arms.app.service.MenuService;

@RestController()
@RequestMapping("/menu")
@ResponseBody
public class MenuController {

	@Autowired
	MenuService menuService;

	@Autowired
	MenuRepository menuRepository;

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(path = "/menu-active", method = RequestMethod.GET)
	public List menuSub(@RequestParam(value = "user") String user, @RequestParam(value = "role") String role) throws NamingException {
		if (role.equals("1")) {
			return menuService.listMenuActive();
		} else {
			return menuService.listMenu(user);
		}
	}

}
