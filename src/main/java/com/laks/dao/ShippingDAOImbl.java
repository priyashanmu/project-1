package com.laks.dao;

import java.io.Serializable;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.laks.model.Shipping;

@Repository("shippingDAO")
public class ShippingDAOImbl implements ShippingDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Shipping shi) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	 
	  session.saveOrUpdate(shi);
	  tx.commit();
	  Serializable id = session.getIdentifier(shi);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Shipping").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Shipping getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Shipping shi = (Shipping) session.load(Shipping.class, id);
	  return shi;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Shipping shi) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(shi);
	  tx.commit();
	  Serializable id = session.getIdentifier(shi);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Shipping shi = (Shipping) session.load(Shipping.class, id);
	  session.delete(shi);
	  tx.commit();
	  Serializable ids = session.getIdentifier(shi);
	  session.close();
	  return (Integer) ids;
	 }

}