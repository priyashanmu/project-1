package com.laks.dao;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.laks.model.UserDetails1;


public interface UserDetails1DAO {
	public List<UserDetails1> list();

	public UserDetails1 get(String id);

	public boolean save(UserDetails1 userDetails1);
	
	public boolean update(UserDetails1 userDetails1);
	
	public boolean delete(String id);

}