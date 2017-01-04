package com.laks.services;

import java.util.List;

import com.laks.model.Shipping;



public interface ShippingService {
	public int insertRow(Shipping shi); 
	 public List getList();
	 public Shipping getRowById(int id);
	 public int updateRow(Shipping shi);
	 public int deleteRow(int id);
}
