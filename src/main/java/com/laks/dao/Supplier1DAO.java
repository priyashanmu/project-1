package com.laks.dao;

import java.util.List;

import com.laks.model.Supplier;



public interface Supplier1DAO {

		 public List getList();
		 public Supplier getRowById(int id);
		 public int updateRow(Supplier sub);
		 public int deleteRow(int id);
		 public int insertRow(Supplier sub);
	}


