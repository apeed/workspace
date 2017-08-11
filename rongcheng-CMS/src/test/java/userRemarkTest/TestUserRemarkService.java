package userRemarkTest;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng_tech.cms.entity.UserRemark;
import com.rongcheng_tech.cms.service.UserRemark.UserRemarkService;
public class TestUserRemarkService {
	private UserRemarkService service;
	@Before
	public void init(){
		String[] conf={"config/springmvc.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("userRemarkService",
				UserRemarkService.class);
	}
	@Test
	public void test1(){
		List<UserRemark> s= service.findByUserRemarkAccount("账号1", new Long(2),new Long(300));
		System.out.println(s);
	}
}
