package com.arms.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.arms.app.entity.MenuAccess;

public interface MenuAccessRepository extends CrudRepository<MenuAccess,Integer> {
	
	//List<Menu> findByParent(@Param("parent") String parent);
        
        
}

