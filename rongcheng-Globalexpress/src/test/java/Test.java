import java.util.Date;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.globalexpress.web.cms.dao.UserRemarkDao;
import com.globalexpress.web.entity.UserRemark;

public class Test {
	private UserRemarkDao dao;

	@Before
	public void init() {
		String[] conf = { "config/springmvc.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(conf);
		dao = context.getBean("userRemarkDao", UserRemarkDao.class);
	}

	@org.junit.Test
	public void test1() {
		UserRemark u= new UserRemark();
		u.setOwnerId(new Long("1"));
		u.setGmtCreate(new Date(System.currentTimeMillis()));
		u.setOperatorId(new Long("1"));
		int n=dao.addUserRemark(u);
		System.out.println(n);
	}
}
