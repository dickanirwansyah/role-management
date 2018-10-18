package com.arms.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.arms.app.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, String> {

	List<Menu> findMenuByParentId(String parentId);

	List<Menu> findMenuById(String id);

	List<Menu> findMenuByLevelMenu(Integer levelMenu);

	//@Query(value = "select distinct A.ID, A.ACTIVE, A.LEVEL_MENU, A.MENU_NAME, A.PARENT_ID, A.PATH_NAME, A.CLASS_STYLE, A.MENU_TYPE from menu a, menu_role b where a.id = b.menu_id and b.access_id=:role", nativeQuery = true)
//	@Query("select distinct a.id as ID, a.active as ACTIVE, a.levelMenu as LEVEL_MENU, a.menuName as MENU_NAME, a.parentId as PARENT_ID, a.pathName as PATH_NAME, a.classStyle as CLASS_STYLE, a.menuType as MENU_TYPE from Menu a, MenuRole b where a.id = b.menuId and b.accessId=?")
	@Query(value = "select distinct m.id, m.active, m.level_menu, m.menu_name, m.parent_id, m.path_name, m.class_style, m.menu_type from menu m, menu_role mr where m.id = mr.menu_id and mr.access_id=:role", nativeQuery = true)
	List<Menu> menuJoin(@Param("role") String role);

}
