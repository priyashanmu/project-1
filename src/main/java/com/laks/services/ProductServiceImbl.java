package com.laks.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.dao.Product1DAO;
import com.laks.model.Product;


@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS)
public class ProductServiceImbl implements ProductService{
	
	@Autowired
	private Product1DAO product1DAO;

	public int insertRow(Product prod,String s) {
		// TODO Auto-generated method stub
		return  product1DAO.insertRow(prod,s);
		 
	}

	public List getList() {
		// TODO Auto-generated method stub
		return product1DAO.getList();
	}

	public Product getRowById(int id) {
		// TODO Auto-generated method stub
		return  product1DAO.getRowById(id);
	}

	public int updateRow(Product prod) {
		// TODO Auto-generated method stub
		return  product1DAO.updateRow(prod);
	}

	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return  product1DAO.deleteRow(id);
	}

	@Override
	public Product updateStock(int fid) {
		// TODO Auto-generated method stub
		return product1DAO.updateQuantity(fid);
	}
}
