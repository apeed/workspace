package test.AlternateImgModule;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.rcb.dao.AlternateImgModuleDao;
import com.rongcheng.rcb.entity.AlternateImgModule;



public class TestAlternateImgModuleDao {
	@Test
	public void findAlteranteImgModuleById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgModuleDao dao=
		context.getBean("alternateImgModuleDao",AlternateImgModuleDao.class);
		AlternateImgModule aig=dao.findAlternateImgModuleById(1);
		System.out.println(aig);
	}
	@Test
	public void addAlternateImg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgModuleDao dao=
				context.getBean("alternateImgModuleDao",AlternateImgModuleDao.class);
		AlternateImgModule aim = new AlternateImgModule();
		aim.setModuleName("不一样");
		aim.setDisplay((byte) 1);
		aim.setRemark("评论");
		int n=dao.addAlternateImgModule(aim);
		System.out.println(n);
	}
	@Test
	public void delAlternateImgModuleById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgModuleDao dao=
		context.getBean("alternateImgModuleDao",AlternateImgModuleDao.class);
		dao.delAlternateImgModuleById(3);
	}
	
	@Test
	public void modifyHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgModuleDao dao=
				context.getBean("alternateImgModuleDao",AlternateImgModuleDao.class);
		AlternateImgModule aim=dao.findAlternateImgModuleById(1);
		aim.setRemark("今日多马");
		int n=dao.modifyAlternateImgModule(aim);
		System.out.println(n);
	}
		@Test
	public void findAll(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AlternateImgModuleDao dao=
		context.getBean("alternateImgModuleDao",AlternateImgModuleDao.class);
		List<AlternateImgModule> hig=dao.findAlternateImgModuleAll();
		System.out.println(hig);
	}
}
