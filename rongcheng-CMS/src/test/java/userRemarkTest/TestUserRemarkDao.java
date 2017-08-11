package userRemarkTest;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.rongcheng_tech.cms.dao.UserRemarkDao;
import com.rongcheng_tech.cms.entity.UserRemark;

public class TestUserRemarkDao {
	@Test
	public void test1(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"config/springmvc.xml");
		UserRemarkDao dao=
		context.getBean("userRemarkDao",UserRemarkDao.class);
		List<UserRemark> s=dao.findByUserRemarkAccount("",new Long(2),new Long(4455));
		System.out.println(s);
	}	
}