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

import com.laks.model.Supplier;

@Repository("subplier1DAO")
public class SupplierDAOImbl implements Supplier1DAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Supplier sub) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	 
	  session.saveOrUpdate(sub);
	  tx.commit();
	  Serializable id = session.getIdentifier(sub);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Supplier").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Supplier getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Supplier sub = (Supplier) session.load(Supplier.class, id);
	  return sub;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Supplier sub) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(sub);
	  tx.commit();
	  Serializable id = session.getIdentifier(sub);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Supplier sub = (Supplier) session.load(Supplier.class, id);
	  session.delete(sub);
	  tx.commit();
	  Serializable ids = session.getIdentifier(sub);
	  session.close();
	  return (Integer) ids;
	 }

}