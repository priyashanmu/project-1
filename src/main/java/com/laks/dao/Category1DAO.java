package com.laks.dao;

import java.util.List;

import com.laks.model.Category;



public interface Category1DAO {

		 public List getList();
		 public Category getRowById(int id);
		 public int updateRow(Category cat);
		 public int deleteRow(int id);
		 public int insertRow(Category cat);
	}


