package com.laks.services;

import java.util.List;

import com.laks.model.UserBean;



public interface UserBeanService {
	public int insertRow(UserBean ub); 
	 public List getList();
	 public UserBean getRowById(int id);
	 public int updateRow(UserBean ub);
	 public int deleteRow(int id);
}
