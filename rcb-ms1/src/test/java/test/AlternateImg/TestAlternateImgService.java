package test.AlternateImg;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.service.AlternateImg.AlternateImgService;



public class TestAlternateImgService {
	private AlternateImgService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("alternateImgService",
				AlternateImgService.class);
	}
	@Test 
	public void test1(){
		AlternateImg hig=service.findAlternateImgById(1);
		System.out.println(hig);
	}
	@Test 
	public void test2(){
		List<AlternateImg> list=service.findAlternateImgAll();
		System.out.println(list);
	}
	@Test 
	public void test3(){
		int row=service.modifyAlternateImg(2,"heping", "sd", "dsf", "sdf", "dsf", "dsf", (byte)1, (byte)23);
		System.out.println(row);
	}@Test 
	public void test4(){
		int n=service.addAlternateImgCol(67, "sdf", "sdf", "sdf", "sdf", "gfd", "df",(byte)1,(byte)5);
		System.out.println(n);
		}
	/*
	
	@Test 
	public void test4(){
		service.delAlternateImgById("1");
		
	}
	*/
	
}
