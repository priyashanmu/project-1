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

import com.laks.model.Item;

@Repository("itemDAO")
public class ItemDAOImbl implements ItemDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Item it) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	 
	  session.saveOrUpdate(it);
	  tx.commit();
	  Serializable id = session.getIdentifier(it);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Item").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Item getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Item it = (Item) session.load(Item.class, id);
	  return it;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Item it) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(it);
	  tx.commit();
	  Serializable id = session.getIdentifier(it);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Item it = (Item) session.load(Item.class, id);
	  session.delete(it);
	  tx.commit();
	  Serializable ids = session.getIdentifier(it);
	  session.close();
	  return (Integer) ids;
	 }
	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public Item updateQuantity(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Item p = (Item) session.load(Item.class, id);
	  p.setQuantity(p.getQuantity()+1);
	  session.saveOrUpdate(p);
	  tx.commit();
	  Serializable sid = session.getIdentifier(p);
	  session.close();
	  return p;
	 }

}