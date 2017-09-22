package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.UserDao;
import com.mm.cs.entities.User;

public class UserService 
{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	//ajax 判断用户名是否存在
	public boolean userNameIsValid(String username)
	{
		//System.out.println(userDao.getUserByUsername(c_Username)+"ajax");
		return userDao.getUserByUsername(username) == null;
	}
	
	//保存更新
	public void saveOrUpdate(User user)
	{
		userDao.saveOrUpdate(user);
	}
	public User get(Integer id)
	{
		return userDao.get(id);
	}
	//列表
	public List<User> getAll()
	{
		List<User> user = userDao.getAll();
		return user; 
	}
	//登录
	public List<User> loginSave(String username,String password,Integer id)
	{
		 List<User> users = userDao.loginSave(username,password,id);
		 System.out.println(users+"haha");
		 return users;
	}
	
	//删除
	public void delete(Integer id)
	{
		userDao.delete(id);
	}
	
	public List<User> getUserById(Integer id)
	{
		return userDao.getUserById(id);
	}
}
