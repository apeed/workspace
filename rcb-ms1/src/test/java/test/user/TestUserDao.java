package test.user;



import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.dao.UserDao;
import com.rongcheng.rcb.entity.User;

public class TestUserDao {
	@Test
	public void testFindByName(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User user=dao.findByName("caocao");
		System.out.println(user);
	}

	@Test
	public void testModifyUserPwd(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
				context.getBean("userDao",UserDao.class);
		User user = dao.findById(4);
		user.setPassword("123456");
		dao.modifyUser(user);
		System.out.println(user);
	}

	@Test
	public void testFindById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User user=dao.findById(1);
		System.out.println(user);
	}
	@Test
	public void testaddUser(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User u = new User();
		u.setName("老白");
		u.setAccount("bai");
		u.setPassword("123");
		u.setTel("546461");
		u.setEmail("12@qq.com");
		u.setRemark("sdf");
		u.setEnable((byte)1);
		int n=dao.addUser(u);
		System.out.println(n);
	}
	@Test
	public void testfindUserAll(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		List<User> user=dao.findUserAll();
		System.out.println(user);
	}
	@Test
	public void testdelUserById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		int n=dao.delUserById(5);
		System.out.println(n);
	}
	@Test
	public void testmodifyAdministrator(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User user=dao.findById(4);
		user.setName("老王哥");
		user.setAccount("sdfd");
		user.setPassword("1321");
		user.setTel("21321");
		dao.modifyAdministrator(user);
	}
}















