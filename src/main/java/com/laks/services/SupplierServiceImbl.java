package com.laks.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.dao.Supplier1DAO;
import com.laks.model.Supplier;


@Service("supplierService")
@Transactional(propagation = Propagation.SUPPORTS)
public class SupplierServiceImbl implements SupplierService{
	
	@Autowired
	private Supplier1DAO supplier1DAO;

	public int insertRow(Supplier sub) {
		// TODO Auto-generated method stub
		return  supplier1DAO.insertRow(sub);
		 
	}

	public List getList() {
		// TODO Auto-generated method stub
		return supplier1DAO.getList();
	}

	public Supplier getRowById(int id) {
		// TODO Auto-generated method stub
		return  supplier1DAO.getRowById(id);
	}

	public int updateRow(Supplier sub) {
		// TODO Auto-generated method stub
		return  supplier1DAO.updateRow(sub);
	}

	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return  supplier1DAO.deleteRow(id);
	}
}
