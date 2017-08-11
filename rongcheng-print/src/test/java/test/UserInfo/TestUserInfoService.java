package test.UserInfo;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.dao.ShopInfoDao;
import com.rongcheng.print.entity.ShopInfo;
import com.rongcheng.print.entity.UserInfo;
import com.rongcheng.print.service.ShopInfo.ShopInfoService;
import com.rongcheng.print.service.UserInfo.UserInfoService;

public class TestUserInfoService {
	private UserInfoService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
	service=context.getBean("userInfoService",
			UserInfoService.class);
	}
	@Test 
	public void test1(){
		int n =service.modifyUserInfo(new BigInteger("1"), "ccao", "1", "1", "1");
		System.out.println(n);
	}
	@Test
	public void test2(){//addUserInfo
		int n=service.addUserInfo("zhang", "zhang", "12", "14554");
		System.out.println(n);
	}
	@Test
	public void test3(){//findUserInfoCount
		String s=service.findUserInfoCount();
		System.out.println(s);
	}
	@Test
	public void test4(){//findShopInfoByPage
		List<UserInfo> list1=service.findUserInfoByPage(0, 1);
		System.out.println(list1);
	}
	@Test
	public void test5(){//findByUserInfoId
		UserInfo s=service.findByUserInfoId(new BigInteger("15"));
		System.out.println(s);
	}
	@Test
	public void test6(){//delUserInfo
		int s=service.delUserInfo(new BigInteger("1"));
		System.out.println(s);
	}
	@Test 
	public void test7(){
		int n =service.modifyUserInfoStatus(new BigInteger("1"), 1);
		System.out.println(n);
	}
	@Test 
	public void test8(){
		UserInfo n =service.checkLogin("zhang", "123", "1VMO", "1VMO");
		System.out.println(n);
	}
	@Test 
	public void test9(){
		service.regist("feike", "123456", "faker@zhang", "66666");
	}
}
