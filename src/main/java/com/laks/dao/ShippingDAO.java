package com.laks.dao;

import java.util.List;

import com.laks.model.Shipping;



public interface ShippingDAO {

		 public List getList();
		 public Shipping getRowById(int id);
		 public int updateRow(Shipping shi);
		 public int deleteRow(int id);
		 public int insertRow(Shipping shi);
	}


