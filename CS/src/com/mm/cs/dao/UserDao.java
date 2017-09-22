package com.mm.cs.dao;

import java.util.List;

import org.hibernate.Query;

import com.mm.cs.entities.User;

public class UserDao extends BaseDao
{
	//ajax
	public User getUserByUsername(String username)
	{
		String hql = "from User u where u.username = ?";
		Query query = getSession().createQuery(hql).setString(0, username);
		return (User) query.uniqueResult();
	}
	
	//*********************************************************************
	public void saveOrUpdate(User user)
	{
		getSession().saveOrUpdate(user);		
	}
	public User get(Integer id)
	{
		return (User) getSession().get(User.class, id);
	}
	
	//*******************************************************************
	public List<User> getAll()
	{
		String hql = "from User";
		return getSession().createQuery(hql).list();
	}
	
	//**************************************************************
	public List<User> loginSave(String username,String password,Integer id)
	{
		String hql = "from User u where u.username = ? and u.password = ? ";	
		//System.out.println(hql);
		return getSession().createQuery(hql).setString(0, username)
											.setString(1, password)
											.list();	
	}
	//*****************************************************************
	public void delete(Integer id)
	{
		String hql = "delete from User u where u.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public List<User> getUserById(Integer id)
	{
		String hql = "from User u where u.id = ?";
		return getSession().createQuery(hql).setInteger(0, id).list();
	}
}
