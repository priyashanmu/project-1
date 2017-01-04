package com.laks.services;

import java.util.List;

import com.laks.model.Supplier;



public interface SupplierService {
	public int insertRow(Supplier sub); 
	 public List getList();
	 public Supplier getRowById(int id);
	 public int updateRow(Supplier sub);
	 public int deleteRow(int id);
}
