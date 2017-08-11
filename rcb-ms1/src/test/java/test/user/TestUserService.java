package test.user;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.dao.UserDao;
import com.rongcheng.rcb.entity.User;
import com.rongcheng.rcb.service.user.UserService;


public class TestUserService {
	private UserService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("userService",
				UserService.class);
	}
	@Test 
	public void test1(){
		User user=service.login("zhang", "123");
		System.out.println(user);
	}
@Test 
	public void test2(){
		User user=service.modifyUser(3, "张飞", "12121200000000", "youxiang.com", "123", "123456");
		System.out.println(user);
	}
@Test
public void test3(){
	ApplicationContext context=
			new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
	UserDao dao=
	context.getBean("userDao",UserDao.class);
	int n=service.addUser("老师", "lao", "123", "dsf", "sfd", "sfd", (byte)0);
	System.out.println(n);
}
@Test 
public void test4(){
	List<User> list=service.findUserAll();
	System.out.println(list);
}
@Test 
public void test5(){
	int n=service.delUserById(4);
	System.out.println(n);
}
@Test 
public void test6(){
	service.modifyAdministrator(6, "dsf", "dfs", "dfs", "dfs", "df", "df", (byte)0);
}
@Test 
public void test7(){
	User user=service.findById(1);
	System.out.println(user);
}



}








