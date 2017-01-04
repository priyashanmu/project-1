package com.laks.dao;

import java.util.List;

import com.laks.model.Product;



public interface Product1DAO {

		 public List getList();
		 public Product getRowById(int id);
		 public int updateRow(Product prod);
		 public int deleteRow(int id);
		 public int insertRow(Product prod,String s);
		 public Product stockUp(int id);
		 public Product updateQuantity(int id);
			
				

}


