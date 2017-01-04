package com.laks.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.dao.ShippingDAO;
import com.laks.model.Shipping;


@Service("shiegoryService")
@Transactional(propagation = Propagation.SUPPORTS)
public class ShippingServiceImbl implements ShippingService{
	
	@Autowired
	private ShippingDAO shippingDAO;

	public int insertRow(Shipping shi) {
		// TODO Auto-generated method stub
		return  shippingDAO.insertRow(shi);
		 
	}

	public List getList() {
		// TODO Auto-generated method stub
		return shippingDAO.getList();
	}

	public Shipping getRowById(int id) {
		// TODO Auto-generated method stub
		return  shippingDAO.getRowById(id);
	}

	public int updateRow(Shipping shi) {
		// TODO Auto-generated method stub
		return  shippingDAO.updateRow(shi);
	}

	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return  shippingDAO.deleteRow(id);
	}
}
