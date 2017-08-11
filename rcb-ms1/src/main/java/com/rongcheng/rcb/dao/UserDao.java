package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.User;

public interface UserDao {
	public User findByName(String account);//通过name查用户信息
	public User findById(Integer id);//通过id修改用户信息
	public void modifyUser(User user);//通过用户对象改用户信息
	public int addUser(User user);//添加管理员
	public int delUserById(Integer id);//删除
	public List<User> findUserAll();//查全部
	public void modifyAdministrator(User user);//通过用户对象改用户信息
	
	
	
	
	
	
	
	//////////////////////////////////////
	User getUserByAccount(String account);
	///////////////////////////////////
}











