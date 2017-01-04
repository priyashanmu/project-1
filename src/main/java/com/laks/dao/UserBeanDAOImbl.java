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

import com.laks.model.UserBean;
import com.laks.model.UserRole;

@Repository("userBeanDAO")
public class UserBeanDAOImbl implements UserBeanDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(UserBean ub) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  ub.setEnable(true);
		UserRole r=new UserRole();
		r.setRoleid(ub.getUid());
		r.setRole_name("ROLE_USER");
		r.setRole_username(ub.getUserName());
		session.saveOrUpdate(r);
	

	  session.saveOrUpdate(ub);
	  tx.commit();
	  Serializable id = session.getIdentifier(ub);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from UserBean").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public UserBean getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  UserBean ub = (UserBean) session.load(UserBean.class, id);
	  return ub;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(UserBean ub) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(ub);
	  tx.commit();
	  Serializable id = session.getIdentifier(ub);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  UserBean ub = (UserBean) session.load(UserBean.class, id);
	  session.delete(ub);
	  tx.commit();
	  Serializable ids = session.getIdentifier(ub);
	  session.close();
	  return (Integer) ids;
	 }

}