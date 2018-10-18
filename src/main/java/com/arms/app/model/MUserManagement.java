package com.arms.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the m_user_management database table.
 * 
 */
@Entity
@Table(name="m_user_management")
@NamedQuery(name="MUserManagement.findAll", query="SELECT m FROM MUserManagement m")
public class MUserManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOGIN_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String loginId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="MODIFY_BY")
	private String modifyBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFY_DATE")
	private Date modifyDate;

	@Column(name="NAME_USER")
	private String nameUser;

	private String nip;

	@Column(name="POSITION_ID")
	private int positionId;

	private int status;

	private String telephone;
	
	@Column(name="PASSWORD")
	private String password;

	public MUserManagement() {
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public int getPositionId() {
		return this.positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}