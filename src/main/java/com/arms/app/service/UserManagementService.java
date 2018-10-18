package com.arms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arms.app.model.MUserManagement;
import com.arms.app.repository.UserManagementRepository;

@Service
public class UserManagementService {

	@Autowired
	UserManagementRepository userManagementRepository;

	public List<MUserManagement> getAll() {
		return (List<MUserManagement>) userManagementRepository.findAll();
	}
	
	public List<MUserManagement> getByStatus() {
		return (List<MUserManagement>) userManagementRepository.findByStatus(0);
	}

	public List<MUserManagement> getId(String jobId) {
		return (List<MUserManagement>) userManagementRepository.findByLoginId(jobId);
	}
	
	public MUserManagement cekLogin(String username, String password) {
		return userManagementRepository.findByNameUserAndPassword(username, password);
	}

	public void save(MUserManagement mUserManagement) {
		userManagementRepository.save(mUserManagement);
	}

	public void delete(String id) {
		userManagementRepository.deleteByLoginId(id);
	}

}
