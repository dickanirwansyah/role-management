/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arms.app.model.MUserManagement;
import com.arms.app.model.UserCredential;
import com.arms.app.service.MenuService;
import com.arms.app.service.UserManagementService;

/**
 *
 * @author bariskreatif
 */
@RestController()
@RequestMapping("/auth")
@ResponseBody
public class AuthController {
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserManagementService userManagementService;

	@SuppressWarnings({ "unused", "rawtypes" })
//	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Map getCredential(@RequestBody UserCredential user, HttpServletRequest request, HttpSession session)throws NamingException {
		Map<String, Object> hasil = new LinkedHashMap<>();
		MUserManagement userLogin = userManagementService.cekLogin(user.getUsername(), user.getPassword());
		
		if (userLogin != null) {
//		if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			String id = UUID.randomUUID().toString();

			HttpSession sess = request.getSession();
			sess.setAttribute("user", user.getUsername());
			sess.setAttribute("password", user.getPassword());

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Object crede = SecurityContextHolder.getContext().getAuthentication().getCredentials();
			UsernamePasswordAuthenticationToken s = new UsernamePasswordAuthenticationToken(principal, crede);

			String usern = "";
			String t = "";
			if (principal instanceof UserDetails) {
				usern = ((UserDetails) principal).getUsername();
			} else {
				usern = principal.toString();
			}

			System.out.println("USERR:" + usern);
			System.out.println("T:" + s.getName());
			System.out.println("T:" + s.toString());
			
			UserCredential cred=new UserCredential();
            cred.setFullName("ARMS");
            cred.setRole("ADMIN");
            cred.setUsername(user.getUsername());
            cred.setLoginStatus(Boolean.TRUE);
            cred.setPicture("assets/img/avatars/arms-blue.png");
            cred.setToken(id);

			hasil.put("status", true);
			hasil.put("message", "Login Berhasil");
			hasil.put("data", cred);
			hasil.put("user", user.getUsername());
			hasil.put("password", user.getPassword());
			hasil.put("userId", userLogin.getLoginId());
			hasil.put("roleId", userLogin.getPositionId());
		} else {
			hasil.put("status", false);
			hasil.put("message", "Username atau Password Salah");
			hasil.put("data", null);
		}
		return hasil;
	}
	
	/*public boolean login(String username, String password){
		MUserManagement user = userManagementService.cekLogin(username, password);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}*/
}
