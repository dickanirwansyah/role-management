package com.arms.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.arms.app.model.MUserManagement;

public interface UserManagementRepository extends CrudRepository<MUserManagement,Integer> {
	
    List<MUserManagement> findAll();
    
    List<MUserManagement> findByLoginId(String loginId);
	
    @Transactional
    void deleteByLoginId(String loginId);
	
	MUserManagement findByNameUserAndPassword(String username, String password);
	
	List<MUserManagement> findByStatus(int status);
	
}
