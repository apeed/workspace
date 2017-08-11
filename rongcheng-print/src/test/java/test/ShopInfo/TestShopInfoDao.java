package test.ShopInfo;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.dao.ShopInfoDao;
import com.rongcheng.print.entity.ShopInfo;

public class TestShopInfoDao {
	@Test
	public void test1(){//findShopInfoCount
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ShopInfoDao dao=
		context.getBean("shopInfoDao",ShopInfoDao.class);
		String s=dao.findShopInfoCount();
		System.out.println(s);
	}
	
	@Test
	public void test2(){//modifyShopInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ShopInfoDao dao=
				context.getBean("shopInfoDao",ShopInfoDao.class);
		ShopInfo si1=dao.findByShopId(new BigInteger("1"));
		si1.setName("ggg");
		int n=dao.modifyShopInfo(si1);
		System.out.println(n);
	}
	@Test
	public void test3(){//findAll
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ShopInfoDao dao=
		context.getBean("shopInfoDao",ShopInfoDao.class);
		List<ShopInfo> list=dao.findAll();
		System.out.println(list);
	}
	@Test
	public void test4(){//addShopInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ShopInfoDao dao=
		context.getBean("shopInfoDao",ShopInfoDao.class);
		ShopInfo si = new ShopInfo();
		si.setName("xx");
		int n=dao.addShopInfo(si);
		System.out.println(n);
	}
	@Test
	public void test5(){//findShopInfoByPage
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ShopInfoDao dao=
		context.getBean("shopInfoDao",ShopInfoDao.class);
		List<ShopInfo>  list=dao.findShopInfoByPage(0, 3);
		System.out.println(list);
	}
}
