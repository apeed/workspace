package userInfoTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.rongcheng_tech.cms.service.UserInfo.UserInfoService;

public class TestUserInfoService {
	private UserInfoService service;
	@Before
	public void init(){
		String[] conf={"config/springmvc.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("userInfoService",
				UserInfoService.class);
	}
	@Test
	public void test1(){
	}
}
