package test.AlternateImgModule;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.entity.AlternateImgModule;
import com.rongcheng.rcb.service.AlternateImgModule.AlternateImgModuleService;




public class TestAlternateImgModuleService {
	private AlternateImgModuleService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("alternateImgModuleService",
				AlternateImgModuleService.class);
	}
	@Test 
	public void test1(){
		AlternateImgModule d1=service.findAlternateImgModuleById(1);
		System.out.println(d1);
	}
	@Test 
	public void test2(){
		 int n=service.addAlternateImgCol("和平", "dff", (byte) 1);
		System.out.println(n);
	}
	@Test 
	public void test3(){
		List<AlternateImgModule> list=service.findAlternateImgModuleAll();
		System.out.println(list);
	}
	@Test 
	public void test4(){
		service.delAlternateImgModuleById(3);
//		System.out.println(s);AlternateImgModule s=
	}
	@Test 
	public void test5(){
		int row=service.modifyHomeImg(10, "heping", "sdf", (byte)1);
		System.out.println(row);
	}
	/*
	@Test 
	public void test3(){
//		HomeImg hig = new HomeImg();
		service.addAlternateImg("9","北京", "欢迎 ", "ni", "人民", 1);
//		System.out.println(h1);
		}
	
	*/
	
}
