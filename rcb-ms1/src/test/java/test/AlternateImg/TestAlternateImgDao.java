package test.AlternateImg;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.dao.AlternateImgDao;
import com.rongcheng.rcb.entity.AlternateImg;


public class TestAlternateImgDao {
	@Test
	public void findAlteranteImgById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgDao dao=
		context.getBean("alternateImgDao",AlternateImgDao.class);
		AlternateImg aig=dao.findAlternateImgById(1);
		System.out.println(aig);
	}
	@Test
	public void addAlternateImg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgDao dao=
				context.getBean("alternateImgDao",AlternateImgDao.class);
		AlternateImg aig = new AlternateImg();
		aig.setId(3);
		aig.setModuleId(2);
		aig.setTitle("sdf");
		aig.setImgUrl("sdf");
		aig.setProfile("dfs");
		aig.setLink("dsf");
		aig.setKeyword("常州");
		aig.setRemark("fsd");
		int n=dao.addAlternateImg(aig);
		System.out.println(n);
	}
	@Test
	public void delHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgDao dao=
		context.getBean("alternateImgDao",AlternateImgDao.class);
		dao.delAlternateImgById(3);
	}
	
	@Test
	public void modifyHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgDao dao=
		context.getBean("alternateImgDao",AlternateImgDao.class);
		AlternateImg hid=dao.findAlternateImgById(2);
		hid.setTitle("今日");
		int n=dao.modifyAlternateImg(hid);
		System.out.println(n);
	}
	@Test
	public void findAll(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgDao dao=
		context.getBean("alternateImgDao",AlternateImgDao.class);
		List<AlternateImg> hig=dao.findAlternateImgAll();
		System.out.println(hig);
	}
}
