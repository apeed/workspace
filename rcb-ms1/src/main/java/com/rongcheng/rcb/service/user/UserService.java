package com.rongcheng.rcb.service.user;

import java.util.List;

import com.rongcheng.rcb.entity.User;
import com.rongcheng.rcb.exception.NameException;
import com.rongcheng.rcb.exception.PasswordException;

public interface UserService {
	
	User login(String account,String password)
			throws NameException,PasswordException;
	
	User modifyUser(Integer userId,String name,String tel,String email,String password,String newPassword)
			throws NameException,PasswordException;
	User findByName(String account);
	public int addUser(String name,String account,String password,String tel,
			String email,String remark,Byte enable);//添加管理员
	public int delUserById(Integer id);//删除
	public List<User> findUserAll();//查全部
	public void modifyAdministrator(Integer id,String name,String account,String password,String tel,
			String email,String remark,Byte enable);//通过用户对象改用户信息
	User findById(Integer id);
	
	
	
	//////////////////////////////////
	User getUserByAccount(String account);
	
	User checkLogin(String account, String password, String yzm, String imgCode) throws RuntimeException;
	////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
}
