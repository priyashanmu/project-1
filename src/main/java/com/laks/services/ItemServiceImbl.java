package com.laks.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.dao.ItemDAO;
import com.laks.model.Item;


@Service("itemService")
@Transactional(propagation = Propagation.SUPPORTS)
public class ItemServiceImbl implements ItemService{
	
	@Autowired
	private ItemDAO itemDAO;

	public int insertRow(Item it) {
		// TODO Auto-generated method stub
		return  itemDAO.insertRow(it);
		 
	}

	public List getList() {
		// TODO Auto-generated method stub
		return itemDAO.getList();
	}

	public Item getRowById(int id) {
		// TODO Auto-generated method stub
		return  itemDAO.getRowById(id);
	}

	public int updateRow(Item it) {
		// TODO Auto-generated method stub
		return  itemDAO.updateRow(it);
	}

	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return  itemDAO.deleteRow(id);
	}

	@Override
	public Item updateQuantity(int itemId) {
		// TODO Auto-generated method stub
		return itemDAO.updateQuantity(itemId);
	}
}
