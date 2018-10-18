/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bariskreatif
 */
@Entity
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.findByActive", query = "SELECT m FROM Menu m WHERE m.active = :active"),
    @NamedQuery(name = "Menu.findByLevelMenu", query = "SELECT m FROM Menu m WHERE m.levelMenu = :levelMenu"),
    @NamedQuery(name = "Menu.findByMenuName", query = "SELECT m FROM Menu m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "Menu.findByParentId", query = "SELECT m FROM Menu m WHERE m.parentId = :parentId"),
    @NamedQuery(name = "Menu.findByPathName", query = "SELECT m FROM Menu m WHERE m.pathName = :pathName"),
    @NamedQuery(name = "Menu.findByClassStyle", query = "SELECT m FROM Menu m WHERE m.classStyle = :classStyle"),
    @NamedQuery(name = "Menu.findByMenuType", query = "SELECT m FROM Menu m WHERE m.menuType = :menuType")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ID")
    private String id;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "LEVEL_MENU")
    private Integer levelMenu;
    @Size(max = 100)
    @Column(name = "MENU_NAME")
    private String menuName;
    @Size(max = 50)
    @Column(name = "PARENT_ID")
    private String parentId;
    @Size(max = 200)
    @Column(name = "PATH_NAME")
    private String pathName;
    @Size(max = 100)
    @Column(name = "CLASS_STYLE")
    private String classStyle;
    @Column(name = "MENU_TYPE")
    private Integer menuType;

    public Menu() {
    }

    public Menu(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Integer getLevelMenu() {
        return levelMenu;
    }

    public void setLevelMenu(Integer levelMenu) {
        this.levelMenu = levelMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String name) {
        this.menuName = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String path) {
        this.pathName = path;
    }

    public String getClassStyle() {
        return classStyle;
    }

    public void setClassStyle(String style) {
        this.classStyle = style;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer tipe) {
        this.menuType = tipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.djp.app.entity.Menu[ id=" + id + " ]";
    }
    
}
