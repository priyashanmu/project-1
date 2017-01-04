package com.laks.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.dao.Category1DAO;
import com.laks.model.Category;


@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS)
public class CategoryServiceImbl implements CategoryService{
	
	@Autowired
	private Category1DAO category1DAO;

	public int insertRow(Category cat) {
		// TODO Auto-generated method stub
		return  category1DAO.insertRow(cat);
		 
	}

	public List getList() {
		// TODO Auto-generated method stub
		return category1DAO.getList();
	}

	public Category getRowById(int id) {
		// TODO Auto-generated method stub
		return  category1DAO.getRowById(id);
	}

	public int updateRow(Category cat) {
		// TODO Auto-generated method stub
		return  category1DAO.updateRow(cat);
	}

	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return  category1DAO.deleteRow(id);
	}
}
