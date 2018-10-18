package com.arms.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LOG")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DTM_CREATE")
	private Date dtmCreate;

	private String ip;

	private String mac;

	@Lob
	private String message;

	private int status;

	@Column(name="USER_ID")
	private String userId;

	public Log() {
	}

	public String getIdLog() {
		return this.idLog;
	}

	public void setIdLog(String idLog) {
		this.idLog = idLog;
	}

	public Date getDtmCreate() {
		return this.dtmCreate;
	}

	public void setDtmCreate(Date dtmCreate) {
		this.dtmCreate = dtmCreate;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}