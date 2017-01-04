package com.laks.dao;
/*package com.access.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.access.model.UserDetails1;

@Repository("userDetails1DAO")
public class UserDetails1DAOImbl implements UserDetails1DAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void UserDetails1DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean save(UserDetails1 userDetails1)
	{
	try {
		sessionFactory.getCurrentSession().save(userDetails1);	
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public boolean update(UserDetails1 userDetails1)
	{
		try {
			sessionFactory.getCurrentSession().update(userDetails1);	
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(UserDetails1 userDetails1)
	{
		try {
			sessionFactory.getCurrentSession().delete(userDetails1);	
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public UserDetails1 get(String id)
	{
		String hql=" from UserDetails where id ="+"'"+id+"'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails1> list=((UserDetails1DAO) query).list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	public List<UserDetails1> list()
	{
		String hql=" from UserDetails";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
*/