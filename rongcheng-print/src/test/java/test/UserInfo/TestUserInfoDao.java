package test.UserInfo;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.dao.ShopInfoDao;
import com.rongcheng.print.dao.UserInfoDao;
import com.rongcheng.print.entity.ShopInfo;
import com.rongcheng.print.entity.UserInfo;

public class TestUserInfoDao {
	@Test
	public void test1(){//findByUserInfoId
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
		context.getBean("userInfoDao",UserInfoDao.class);
		UserInfo ui=dao.findByUserInfoId(new BigInteger("15"));
		System.out.println(ui);
	}
	
	@Test
	public void test2(){//findUserInfoCount
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
				context.getBean("userInfoDao",UserInfoDao.class);
		String n=dao.findUserInfoCount();
		System.out.println(n);
	}
	@Test
	public void test3(){//findUserInfoByPage
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
				context.getBean("userInfoDao",UserInfoDao.class);
		List<UserInfo> list=dao.findUserInfoByPage(0, 2);
		System.out.println(list);
	}
	@Test
	public void test4(){//modifyUserInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
				context.getBean("userInfoDao",UserInfoDao.class);
		UserInfo ui=dao.findByUserInfoId(new BigInteger("1"));
		ui.setAccountNum("caocao1");
		int n=dao.modifyUserInfo(ui);
		System.out.println(n);
	}
	@Test
	public void test5(){//addUserInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
				context.getBean("userInfoDao",UserInfoDao.class);
		UserInfo ui = new UserInfo();
		ui.setAccountNum("caocao");
		ui.setEmail("17740411@qq.com");
		int n=dao.addUserInfo(ui);
		System.out.println(n);
	}
	@Test
	public void test6(){//delUserInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
				context.getBean("userInfoDao",UserInfoDao.class);
		int n=dao.delUserInfo(new BigInteger("1"));
		System.out.println(n);
	}
	@Test
	public void test7(){//getUserByAccountNum
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserInfoDao dao=
		context.getBean("userInfoDao",UserInfoDao.class);
		UserInfo ui=dao.getUserByAccountNum("zhang");
		System.out.println(ui);
	}
}
