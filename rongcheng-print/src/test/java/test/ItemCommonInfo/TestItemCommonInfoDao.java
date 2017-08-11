package test.ItemCommonInfo;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.dao.ItemCommonInfoDao;
import com.rongcheng.print.entity.ItemCommonInfo;

public class TestItemCommonInfoDao {
	@Test
	public void test1(){//findById
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		ItemCommonInfo ici=dao.findById(new BigInteger("3"));
		System.out.println(ici);
	}
	@Test
	public void test2(){//findAll
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		List<ItemCommonInfo> list=dao.findItemCommonInfoAll();
		System.out.println(list);
	}
	@Test
	public void test3(){//modifyItemCommonInfo
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		ItemCommonInfo ici1=dao.findById(new BigInteger("3"));
		ici1.setShortName("xxx");
		int n=dao.modifyItemCommonInfo(ici1);
		System.out.println(n);
	}
	@Test
	public void test4(){//findItemCommonInfoByPage
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		List<ItemCommonInfo> list=dao.findItemCommonInfoByPage(0, 1);
		System.out.println(list);
	}
	@Test
	public void test5(){//findItemCommonInfoCount
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		String p=dao.findItemCommonInfoCount();
		System.out.println(p);
	}
	
	@Test
	public void test7(){//modifyItemCommonInfos
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		ItemCommonInfoDao dao=
		context.getBean("itemCommonInfoDao",ItemCommonInfoDao.class);
		BigInteger[] id = {new BigInteger("333"),new BigInteger("555")};
		String[] shortName={"st1"};
		for(int i=0;i<id.length;i++){
			ItemCommonInfo ici=new ItemCommonInfo();
			ici.setShortName(shortName[0]);
			ici.setId(id[i]);
			dao.modifyItemCommonInfo(ici);
		}
	}
}
