package com.laks.services;

import java.util.List;

import com.laks.model.Product;



public interface ProductService {
	public int insertRow(Product prod,String s); 
	 public List getList();
	 public Product getRowById(int id);
	 public int updateRow(Product prod);
	 public int deleteRow(int id);
	public Product updateStock(int fid);
}
