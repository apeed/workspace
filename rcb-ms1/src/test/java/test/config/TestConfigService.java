package test.config;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.entity.Config;
import com.rongcheng.rcb.service.Config.ConfigService;



public class TestConfigService{
	private ConfigService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("configService",
				ConfigService.class);
	}
	/*@Test 
	public void test1(){
		Settings n=service.addSettings("1","这家伙", "127.0.0.1", "io55", "长方", "孙膑", 65655, 7777777, 556565, 1234567, "123@qq.com", "北京", "我是内容，风景不错");
		System.out.println(n);
	}
	
	*/
/*	@Test 
	public void test1(){
		Config sett=service.findConfigByName("网站描述");
		System.out.println(sett);
	}
	@Test 
	public void test3(){
		int b=service.modifyConfig("网站描述", "花儿");
		System.out.println(b);
	}*/
}
