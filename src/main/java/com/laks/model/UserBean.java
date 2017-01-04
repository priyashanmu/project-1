package com.laks.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UserBean implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private static final long serialVersionUID = 4657462015039726030L;
	private String userName;
	private String email;
	private String password;
	private boolean enable;
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Transient
	private String conform_password;
	 
	
	public String getConform_password() {
		return conform_password;
	}
	public void setConform_password(String conform_password) {
		this.conform_password = conform_password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	}
