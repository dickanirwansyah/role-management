package com.arms.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.arms.app.model.MenuRole;


public interface MenuRoleRepository extends CrudRepository<MenuRole,Integer> {
	
    List<MenuRole> findAll();
	
    @Transactional
	void deleteByAccessId(String accessId);
    
    List<MenuRole> findByAccessId(String accessId);
    
    List<MenuRole> findByAccessIdAndParentIdContaining(String accessId, String parentId);
    
}
