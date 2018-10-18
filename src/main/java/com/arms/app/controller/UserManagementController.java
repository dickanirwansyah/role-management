package com.arms.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arms.app.model.MUserManagement;
import com.arms.app.service.UserManagementService;
import com.arms.app.util.ConstantaVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user-management")
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<MUserManagement> get() throws IOException {
		return userManagementService.getByStatus();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String uploadingPost(@RequestBody MUserManagement mUserManagement) {
		try {
			userManagementService.save(mUserManagement);
			return ConstantaVariable.MSG.SUCCESS;
		} catch (Exception e) {
			return ConstantaVariable.MSG.FAILED;
		}
    }
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public String deleteCompany(@RequestBody String id) {
		try {
			userManagementService.delete(id);
			return ConstantaVariable.MSG.DELETE_SUCCESS;
		} catch (Exception e) {
			return ConstantaVariable.MSG.DELETE_FAILED;
		}
	}
	
}