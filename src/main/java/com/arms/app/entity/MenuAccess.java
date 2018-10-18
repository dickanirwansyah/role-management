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
@Table(name = "MENU_ACCESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuAccess.findAll", query = "SELECT m FROM MenuAccess m"),
    @NamedQuery(name = "MenuAccess.findByAccessId", query = "SELECT m FROM MenuAccess m WHERE m.accessId = :accessId"),
    @NamedQuery(name = "MenuAccess.findByRole", query = "SELECT m FROM MenuAccess m WHERE m.roleUser = :roleUser"),
    @NamedQuery(name = "MenuAccess.findByMenuId", query = "SELECT m FROM MenuAccess m WHERE m.menuId = :menuId")})
public class MenuAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCESS_ID")
    private Long accessId;
    @Size(max = 20)
    @Column(name = "ROLE_USER")
    private String roleUser;
    @Size(max = 20)
    @Column(name = "MENU_ID")
    private String menuId;
    @Size(max = 50)
    @Column(name = "PATH_NAME")
    private String pathName;

    public MenuAccess() {
    }

    public MenuAccess(Long accId) {
        this.accessId = accId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getAccessId() != null ? getAccessId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuAccess)) {
            return false;
        }
        MenuAccess other = (MenuAccess) object;
        if ((this.getAccessId() == null && other.getAccessId() != null) || (this.getAccessId() != null && !this.accessId.equals(other.accessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.djp.app.entity.MenuAccess[ accId=" + getAccessId() + " ]";
    }

    /**
     * @return the pathName
     */
    public String getPathName() {
        return pathName;
    }

    /**
     * @param pathName the pathName to set
     */
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    /**
     * @return the accessId
     */
    public Long getAccessId() {
        return accessId;
    }

    /**
     * @param accessId the accessId to set
     */
    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    /**
     * @return the roleUser
     */
    public String getRoleUser() {
        return roleUser;
    }

    /**
     * @param roleUser the roleUser to set
     */
    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    /**
     * @return the menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
}
