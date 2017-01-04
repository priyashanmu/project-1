package com.laks.dao;

import java.util.List;

import com.laks.model.Item;





public interface ItemDAO {

		 public List getList();
		 public Item getRowById(int id);
		 public int updateRow(Item it);
		 public int deleteRow(int id);
		 public int insertRow(Item it);
		 public Item updateQuantity(int id);
	}


