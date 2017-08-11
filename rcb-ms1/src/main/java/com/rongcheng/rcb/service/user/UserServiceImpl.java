package com.rongcheng.rcb.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.UserDao;
import com.rongcheng.rcb.entity.User;
import com.rongcheng.rcb.exception.NameException;
import com.rongcheng.rcb.exception.PasswordException;


@Service("userService")
public class UserServiceImpl 
			implements UserService{
	@Resource
	private UserDao userDao;

	public User login(String account, String password) throws NameException, PasswordException {
		if(account==null||account.trim().isEmpty()){
			throw new NameException("用户不能为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		User user=userDao.findByName(account);
		if(user==null){
			throw new NameException("用户名错误");
		}
		
		
		if(user.getPassword().equals(password)){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
	}

	//修改user
	public User modifyUser(Integer userId,String name, String tel, String email, String password, String newPassword)
			throws NameException, PasswordException {
		User user=userDao.findById(userId);//查找user
		if(!user.getPassword().equals(password)){//判断原始密码
			throw new PasswordException("原始密码错误");
		}else{//重置密码
			
			user.setPassword(newPassword);//返回更新行数，虽然没用上吧
			user.setName(name);
			user.setTel(tel);
			user.setEmail(email);
			userDao.modifyUser(user);//return一个啥，一个user
			
			return user;
		}
	}

	public User findByName(String account) {
		User user=userDao.findByName(account);
		return user;
	}

	public int addUser(String name, String account, String password, String tel, String email, String remark,
			Byte enable) {
		User u = new User();
		u.setName(name);
		u.setAccount(account);
		u.setPassword(password);
		u.setTel(tel);
		u.setEmail(email);
		u.setRemark(remark);
		u.setEnable(enable);
		int n=userDao.addUser(u);
		return n;
	}

	public int delUserById(Integer id) {
		int n=userDao.delUserById(id);
		return n;
	}

	public List<User> findUserAll() {
		List<User> list=userDao.findUserAll();
		return list;
	}

	public void modifyAdministrator(Integer id,String name,String account,String password,String tel,
			String email,String remark,Byte enable) {
		User user=userDao.findById(id);
		user.setName(name);
		user.setAccount(account);
		user.setPassword(password);
		user.setTel(tel);
		user.setEmail(email);
		user.setRemark(remark);
		user.setEnable(enable);
		userDao.modifyAdministrator(user);
	}

	public User findById(Integer id) {
		User user=userDao.findById(id);
		return user;
	}


	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////
	public User getUserByAccount(String account) {
		return userDao.getUserByAccount(account);
	}

	public User checkLogin(String account, String password, String inputImgCode, String imgCode) throws RuntimeException {
		if (inputImgCode == null || inputImgCode == "" || !inputImgCode.equalsIgnoreCase(imgCode)) {
			throw new RuntimeException("imgCodeError");
		}

		User user = userDao.getUserByAccount(account);

		if (user == null) {
			// 找不到符合条件的记录, 抛出一个应用异常。
			throw new RuntimeException("accountError");
		}

		if (!user.getPassword().equals(password)) {
			// 用户提交的密码与数据库保存的密码不一致。
			throw new RuntimeException("passWordError");
		}
		if (user.getEnable()==0) {
			// 用户已被冻结
			throw new RuntimeException("userError");
		}

		// 登录验证通过
		return user;
	}
	
	//////////////////////////////////////
	
}








