package com.laks.services;

import java.util.List;

import com.laks.model.Category;



public interface CategoryService {
	public int insertRow(Category cat); 
	 public List getList();
	 public Category getRowById(int id);
	 public int updateRow(Category cat);
	 public int deleteRow(int id);
}
