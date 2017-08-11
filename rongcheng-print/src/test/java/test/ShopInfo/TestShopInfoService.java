package test.ShopInfo;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.entity.ShopInfo;
import com.rongcheng.print.service.ShopInfo.ShopInfoService;

public class TestShopInfoService {
	private ShopInfoService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
	service=context.getBean("shopInfoService",
			ShopInfoService.class);
	}
	@Test 
	public void test1(){
		int n =service.modifyShopInfo(new BigInteger("1"), "shu", "shu","shu","123456789","shu");
		System.out.println(n);
	}
	@Test 
	public void test2(){
		List<ShopInfo> list=service.findAll();
		System.out.println(list);
	}
	@Test
	public void test3(){//addShopInfo
		int n=service.addShopInfo("1", "1","1","1","1");
		System.out.println(n);
	}
	@Test
	public void test4(){//findShopInfoCount
		String s=service.findShopInfoCount();
		System.out.println(s);
	}
	@Test
	public void test5(){//findShopInfoByPage
		List<ShopInfo> list1=service.findShopInfoByPage(0, 3);
		System.out.println(list1);
	}
	@Test
	public void test6(){//findByShopId
		ShopInfo s=service.findByShopId(new BigInteger("1"));
		System.out.println(s);
	}
	@Test 
	public void test7(){
		int n =service.modifyShopInfoStatus(new BigInteger("1"), true);
		System.out.println(n);
	}
}
