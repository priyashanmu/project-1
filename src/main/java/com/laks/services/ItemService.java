package com.laks.services;

import java.util.List;

import com.laks.model.Item;



public interface ItemService {
	public int insertRow(Item it); 
	 public List getList();
	 public Item getRowById(int id);
	 public int updateRow(Item it);
	 public int deleteRow(int id);
	public Item updateQuantity(int itemId);
}
