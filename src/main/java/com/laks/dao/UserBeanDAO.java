package com.laks.dao;

import java.util.List;

import com.laks.model.UserBean;



public interface UserBeanDAO {

		 public List getList();
		 public UserBean getRowById(int id);
		 public int updateRow(UserBean ub);
		 public int deleteRow(int id);
		 public int insertRow(UserBean ub);
	}


