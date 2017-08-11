package test.ItemCommonInfo;
import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.dao.ItemCommonInfoDao;
import com.rongcheng.print.entity.ItemCommonInfo;
import com.rongcheng.print.service.ItemCommonInfo.ItemCommonInfoService;

public class TestItemCommonInfoService {
	private ItemCommonInfoService service;
	private ItemCommonInfoDao dao;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("itemCommonInfoService",
				ItemCommonInfoService.class);
	}
	@Test 
	public void test1(){
		List<ItemCommonInfo> list=service.findItemCommonInfoAll();
		System.out.println(list);
	}
	@Test 
	public void test2(){
		int n =service.modifyItemCommonInfo(new BigInteger("1234567"), "afaab");
		System.out.println(n);
	}
	@Test 
	public void test3(){
		List<ItemCommonInfo> list=service.findItemCommonInfoByPage(1, 1);
		System.out.println(list);
	}
	@Test 
	public void test4(){
		String p =service.findItemCommonInfoCount();
		System.out.println(p);
	}
	@Test 
	public void test5(){
		BigInteger[] id = {new BigInteger("333"),new BigInteger("555"),new BigInteger("4")};
		String[] shortName ={"short1"};
		service.modifyItemCommonInfos(id, shortName);
	}	
}
