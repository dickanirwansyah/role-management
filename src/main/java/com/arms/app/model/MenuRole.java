package com.arms.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_role database table.
 * 
 */
@Entity
@Table(name="menu_role")
@NamedQuery(name="MenuRole.findAll", query="SELECT m FROM MenuRole m")
public class MenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="ACCESS_ID")
	private String accessId;

	@Column(name="MENU_ID")
	private String menuId;

	@Column(name="PARENT_ID")
	private String parentId;

	public MenuRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessId() {
		return this.accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}