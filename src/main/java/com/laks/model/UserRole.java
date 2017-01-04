package com.laks.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int roleid;
	private String role_name;
	private String role_username;  

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_username() {
		return role_username;
	}
	public void setRole_username(String role_username) {
		this.role_username = role_username;
	}

}
