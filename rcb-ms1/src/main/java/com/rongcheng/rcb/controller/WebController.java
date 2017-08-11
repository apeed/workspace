package com.rongcheng.rcb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.entity.AlternateImgModule;
import com.rongcheng.rcb.entity.Config;
import com.rongcheng.rcb.entity.LeaveMessage;
import com.rongcheng.rcb.entity.OneMenu;
import com.rongcheng.rcb.entity.SinglePage;
import com.rongcheng.rcb.entity.TwoMenu;
import com.rongcheng.rcb.service.AlternateImg.AlternateImgService;
import com.rongcheng.rcb.service.AlternateImgModule.AlternateImgModuleService;
import com.rongcheng.rcb.service.Config.ConfigService;
import com.rongcheng.rcb.service.leave_message.LeaveMessageService;
import com.rongcheng.rcb.service.one_menu.OneMenuService;
import com.rongcheng.rcb.service.single_page.SinglePageService;
import com.rongcheng.rcb.service.two_menu.TwoMenuService;
import com.rongcheng.rcb.utils.JsonResult;


@Controller
public class WebController {
	//导航栏菜单数量（包含未显示）
	@Value("#{sysconfig['maxOneMenuNumber']}")
	private String maxOneMenuNumber;
	//分页相关（每页多少条）
	@Value("#{sysconfig['rows']}")
	private String rows;
	//轮播图模块数量
	@Value("#{sysconfig['alternateImgModule']}")
	private String alternateImgModule;
	//每个轮播模块显示的图片数量
	@Value("#{sysconfig['alternateImg']}")
	private String alternateImg;
	
	//首页我们的业务所在一级菜单id
	@Value("#{sysconfig['indexYeWuOneMenuId']}")
	private String indexYeWuOneMenuId;
	//首页我们的优势所在一级菜单id
	@Value("#{sysconfig['indexYouShiOneMenuId']}")
	private String indexYouShiOneMenuId;
	//首页案例展示所在一级菜单id
	@Value("#{sysconfig['indexAnLiOneMenuId']}")
	private String indexAnLiOneMenuId;
	//首页案例展示几条
	@Value("#{sysconfig['indexAnLiSinglePageNum']}")
	private String indexAnLiSinglePageNum;
	//首页文章列表区所在一级菜单的id（融成观点	新闻动态   技术文章 ）
	@Value("#{sysconfig['indexWenZhangOneMenuId']}")
	private String indexWenZhangOneMenuId;
	//首页文章列表区各区下显示几篇文章（融成观点	新闻动态   技术文章 ）
	@Value("#{sysconfig['indexWenZhangSinglePageNum']}")
	private String indexWenZhangSinglePageNum;
	
	@Resource
	private LeaveMessageService leaveMessageService;
	@Resource
	private SinglePageService singlePageService;
	@Resource
	private OneMenuService oneMenuService;
	@Resource
	private TwoMenuService twoMenuService;
	@Resource
	private ConfigService configService;
	@Resource
	private AlternateImgService alternateImgService;
	@Resource
	private AlternateImgModuleService alternateImgModuleService;
	
	@RequestMapping("/index.php")
	public String in(HttpServletRequest request) {
		
		// 顶部轮播图
		//取前三组轮播图(每组取前三)
		int alternateImgNum = new Integer(alternateImg);
		int alternateImgModuleNum = new Integer(alternateImgModule);
		//转发到jsp的Map
		Map<String,List<Object>> alternateImgMap = new HashMap<String, List<Object>>();
		int i = 0;
		List<AlternateImgModule> alternateImgModuleList = alternateImgModuleService.listAlternateImgModuleByFrontRow(alternateImgModuleNum);
		for (AlternateImgModule alternateImgModule : alternateImgModuleList) {
			System.out.println(alternateImgModule);
			List<AlternateImg> alternateImgList = alternateImgService.listAlternateImgByModuleIdAndDisplayNumber(alternateImgModule.getId(), alternateImgNum);
			System.out.println(alternateImgList);
			i++;
			List<Object> alternateImg = new ArrayList<Object>();
			alternateImg.add(alternateImgModule.getModuleName());
			alternateImg.add(alternateImgList);
			alternateImgMap.put("module"+i, alternateImg);
		}
		System.out.println("alternateImgMap："+alternateImgMap);
		request.setAttribute("alternateImgMap", alternateImgMap);
		
		// 业务
		
		String YeWuOneMenuTitle = oneMenuService.getTitleById(new Integer(indexYeWuOneMenuId));
		if(YeWuOneMenuTitle!=null){
		List<TwoMenu> YeWuTwoMenuList = twoMenuService.listTwoMenuDisplayByOneMenuId(new Integer(indexYeWuOneMenuId));
		request.setAttribute("YeWuOneMenuId", indexYeWuOneMenuId);
		request.setAttribute("YeWuOneMenuTitle", YeWuOneMenuTitle);
		request.setAttribute("YeWuTwoMenuList", YeWuTwoMenuList);}
		
		// 优势
		String YouShiOneMenuTitle = oneMenuService.getTitleById(new Integer(indexYouShiOneMenuId));
		if(YouShiOneMenuTitle != null){
		List<TwoMenu> YouShiTwoMenuList = twoMenuService.listTwoMenuDisplayByOneMenuId(new Integer(indexYouShiOneMenuId));
		request.setAttribute("YouShiOneMenuId", indexYouShiOneMenuId);
		request.setAttribute("YouShiOneMenuTitle", YouShiOneMenuTitle);
		request.setAttribute("YouShiTwoMenuList", YouShiTwoMenuList);}
		
		
		
		
		
		// 案例展示
		String AnLiOneMenuTitle = oneMenuService.getTitleById(new Integer(indexAnLiOneMenuId));
		if(AnLiOneMenuTitle != null){
			List<SinglePage> ALSinglePageList = singlePageService.listSinglePageByOneMenuIdAndFrontRow(new Integer(indexAnLiOneMenuId),new Integer(indexAnLiSinglePageNum));
			System.out.println(ALSinglePageList);
			request.setAttribute("AnLiOneMenuId", indexAnLiOneMenuId);
			request.setAttribute("ALSinglePageList", ALSinglePageList);
		}
		
		
		
		
		
		// 公司动态里前3二级标题(融成观点	新闻动态 技术文章)
		List<List<SinglePage>> singlePageListList = new ArrayList<List<SinglePage>>();
		String DTOneMenuTitle = oneMenuService.getTitleById(new Integer(indexWenZhangOneMenuId));
		if(DTOneMenuTitle != null){
			List<TwoMenu> twoMenuList = twoMenuService.listTwoMenuDisplayByOneMenuId(new Integer(indexWenZhangOneMenuId));
			Iterator<TwoMenu> iterator = twoMenuList.iterator(); 
			for (int y =1; iterator.hasNext();y++) {
				if(y>=4){break;}
				TwoMenu twoMenu = (TwoMenu) iterator.next();
				int twoMenuIdInt = twoMenu.getId();
				singlePageListList.add(listSinglePage(new Integer(indexWenZhangOneMenuId),twoMenuIdInt,0,new Integer(indexWenZhangSinglePageNum)));
			}
			request.setAttribute("twoMenuList", twoMenuList);
			request.setAttribute("singlePageListList", singlePageListList);
		}
		headAndFoot(request);
		return "frontstage/index";
	}
	@RequestMapping("/list.php")
	public String list(@RequestParam String oneMenuId,HttpServletRequest request) {
		int oneMenuIdInt = -1;
		int twoMenuIdInt = -1;
		//>>>>>>>>>>完成一级菜单id赋值>>>>>>>>>>>>>>>>>>>
		try{
			oneMenuIdInt = new Integer(oneMenuId);
		}catch (Exception e) {
			System.out.println("id格式错误或者超出范围");
			return "forward:/";
		}
		//<<<<<<<<<<完成一级菜单id赋值<<<<<<<<<<<<<<<<<<<
		
		//>>>>>>>>>>完成二级菜单id赋值>>>>>>>>>>>>>>>>>>>
		//无传递tid。就判断oid下有无t，有就赋值第一个，无-1.
		//有传递tid。格式化。格式化成功赋值，不成功返回上一步。
		System.out.println("1j"+oneMenuIdInt);
		String twoMenuId = request.getParameter("twoMenuId");
		System.out.println("2j"+twoMenuId);
		List<TwoMenu> twoMenuList = twoMenuService.listTwoMenuDisplayByOneMenuId(oneMenuIdInt);
		System.out.println(twoMenuList);
		if(twoMenuId == null){
			if (twoMenuList.isEmpty()) {//此一级菜单下无二级菜单
				twoMenuIdInt = 0;
			} else {
				twoMenuIdInt = new Integer(twoMenuList.get(0).getId());//取第一个二级菜单id
				System.out.println("第一个2j"+twoMenuIdInt);
			}
		}else {
			try{
				twoMenuIdInt = new Integer(twoMenuId);
			}catch (Exception e) {
				if (twoMenuList == null) {//此一级菜单下无二级菜单
					twoMenuIdInt = 0;
				} else {
					twoMenuIdInt = new Integer(twoMenuList.get(0).getId());//取第一个二级菜单id
				}
			}
		}
		//<<<<<<<<<<完成二级菜单id赋值<<<<<<<<<<<<<<<<<<<
		
		OneMenu oneMenu = oneMenuService.getOneMenuById(oneMenuIdInt);
		if(oneMenu == null){return "forward:/";}
		String oneMenuTitle = oneMenu.getTitle();
		String oneMenuLink = oneMenu.getLink();
		
		//一级菜单下(无二级菜单)直接是详情单页
		/*if(twoMenuIdInt == -1){
			Object[] o = singlePageService.listSinglePageByPage(0, new Integer(rows),new Integer(oneMenuId),new Integer(twoMenuId),1);
			List<SinglePage> singlePageList = (List<SinglePage>) o[1];
			if(singlePageList!=null&&singlePageList.size()>1){//一级菜单下有多条详情单页
				request.setAttribute("oneMenuTitle", oneMenuTitle);
				request.setAttribute("singlePageList", singlePageList);
				headAndFoot(request);
				return "frontstage/listline";
			}else{//一级菜单下有一条或没有详情单页
				SinglePage singlePage = singlePageList.get(0);
				oneMenuTitle = oneMenuService.getTitleById(singlePage.getOneMenuId());
				String twoMenuTitle = twoMenuService.getTitleById(singlePage.getTwoMenuId());
				request.setAttribute("singlePage", singlePage);
				request.setAttribute("oneMenuTitle", oneMenuTitle);
				request.setAttribute("twoMenuTitle", twoMenuTitle);
				request.setAttribute("twoMenuList", twoMenuList);
				headAndFoot(request);
				return show(singlePage.getId()+"",request);
			}
		}*/
		System.out.println(oneMenuId+"---"+twoMenuId);
		String twoMenuTitle = twoMenuService.getTitleById(twoMenuIdInt);
		Object[] o = singlePageService.listSinglePageByPage(1, new Integer(rows),oneMenuIdInt,twoMenuIdInt,1);
		List<SinglePage> singlePageList = null;
		if (o != null) {
			singlePageList = (List<SinglePage>) o[1];
		}
		
		//二级菜单下有多条或0条详情页
		//菜单下有多条或0条详情页
		if(singlePageList==null||singlePageList.size()!=1){
			if(singlePageList==null){
				request.setAttribute("max_page", 0);
			}else{
				request.setAttribute("max_page", (Integer)o[0]);
			}
			request.setAttribute("oneMenuTitle", oneMenuTitle);
			request.setAttribute("twoMenuTitle", twoMenuTitle);
			request.setAttribute("twoMenuId", twoMenuIdInt);
			request.setAttribute("twoMenuList", twoMenuList);
			request.setAttribute("singlePageList", singlePageList);
			headAndFoot(request);
			if(oneMenuLink !=null && oneMenuLink.equals("listsquare")){
				return "frontstage/listsquare";
			}
			return "frontstage/listline";
		}
		if(singlePageList==null||singlePageList.size()!=1){
			request.setAttribute("max_page", (Integer)o[0]);
			request.setAttribute("oneMenuTitle", oneMenuTitle);
			request.setAttribute("twoMenuTitle", twoMenuTitle);
			request.setAttribute("twoMenuId", twoMenuIdInt);
			request.setAttribute("twoMenuList", twoMenuList);
			request.setAttribute("singlePageList", singlePageList);
			headAndFoot(request);
			if(oneMenuLink !=null && oneMenuLink.equals("listsquare")){
				return "frontstage/listsquare";
			}
			return "frontstage/listline";
		}
		//二级菜单下只有一条详情页
		//菜单下只有一条详情页
		if(singlePageList.size()==1){
			request.setAttribute("singlePage", singlePageList.get(0));
			request.setAttribute("oneMenuTitle", oneMenuTitle);
			request.setAttribute("twoMenuTitle", twoMenuTitle);
			request.setAttribute("twoMenuList", twoMenuList);
			headAndFoot(request);
			return show(singlePageList.get(0).getId()+"",request);
		}
		return null;
	}
	
	// 单页
	@RequestMapping("/show.php")
	public String show(@RequestParam String id, HttpServletRequest request) {
		int idNum = -1;
		try{
			idNum = new Integer(id);
		}catch (Exception e) {
			System.out.println("id格式错误或者超出范围");
			return "forward:/";
		}
		SinglePage singlePage = singlePageService.getSinglePageById(idNum);
		if(singlePage == null){return "forward:/";}
		String oneMenuTitle = oneMenuService.getTitleById(singlePage.getOneMenuId());
		String twoMenuTitle = twoMenuService.getTitleById(singlePage.getTwoMenuId());
		List<TwoMenu> twoMenuList = twoMenuService.listTwoMenuDisplayByOneMenuId(singlePage.getOneMenuId());
		request.setAttribute("singlePage", singlePage);
		request.setAttribute("oneMenuTitle", oneMenuTitle);
		request.setAttribute("twoMenuTitle", twoMenuTitle);
		request.setAttribute("twoMenuList", twoMenuList);
		headAndFoot(request);
		//增加一次点击量
		System.out.println("11111111111111111111111111111111");
		singlePageService.updateSinglePageClick(idNum);
		
		return "frontstage/show";
	}
	
	// 产品搜索（案例搜索）
	@RequestMapping("/search.php")
	public String search(HttpServletRequest request) {
		String keyword = null;
		try {
			request.setCharacterEncoding("utf-8");
			keyword = request.getParameter("keyword");
		} catch (UnsupportedEncodingException e) {
			keyword = null;
			e.printStackTrace();
		}
		List<SinglePage> singlePageList = singlePageService.listSinglePageByKeyword(keyword);
		System.out.println("产品搜索："+singlePageList);
		request.setAttribute("oneMenuTitle", "产品搜索");
		request.setAttribute("singlePageList", singlePageList);
		headAndFoot(request);
		return "frontstage/listline";
	}
	
	@RequestMapping("savaleavemessage.php")
	@ResponseBody
	public void saveLeaveMessage(String name,String tel,String email,String content,HttpServletResponse response) {
		LeaveMessage lm = new LeaveMessage();
		lm.setName(name);
		lm.setTel(tel);
		lm.setEmail(email);
		lm.setContent(content);
		int n = leaveMessageService.saveLeaveMessage(lm);
		PrintWriter out =null;
		try {
			out = response.getWriter();
			if(n>=0){
				out.print(n);
			}else{
				out.print(-1);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("留言成功，通知失败");
		} finally {
			out.close();
		}
	}
	
	//所有一级菜单下的所有二级菜单
	public LinkedHashMap<Object, Object> mapOneTwoMenu() {
		LinkedHashMap<Object,Object> oneTwoMenuMap = new LinkedHashMap<Object, Object>();
		List<OneMenu> oneMenuList = oneMenuService.listOneMenuByFrontRow(new Integer(maxOneMenuNumber)-1);
		for (OneMenu oneMenu : oneMenuList) {
			oneTwoMenuMap.put(oneMenu, twoMenuService.listTwoMenuDisplayByOneMenuId(oneMenu.getId()));
		}
		return oneTwoMenuMap;
	}
	
	public List<SinglePage> listSinglePage (int oneMenuIdInt,int twoMenuIdInt,int singlePageStart,int singlePageNum) {
		
		List<SinglePage> singlePageList = singlePageService.listSinglePageByOneTwoMenuIdAndFrontRow(oneMenuIdInt,twoMenuIdInt,singlePageStart,singlePageNum);
		
		return singlePageList;
	}
	//导航栏和网站信息
	public void headAndFoot(HttpServletRequest request) {
		//导航栏
		Map<Object, Object> oneTwoMenuMap = mapOneTwoMenu();
		request.setAttribute("oneTwoMenuMap", oneTwoMenuMap);
		//底部网站信息
		HashMap<String, Config> configMap = configService.mapConfig();
		request.setAttribute("configMap", configMap);
	}
	
	//根据页码检索所有留言
		@RequestMapping("loadsinglepagebypage.php")
		@ResponseBody
		public JsonResult loadLeaveMessagesByPage(String page,String oneMenuId,String twoMenuId) {
			try{
				new Integer(page);
			}catch (Exception e) {
				page="1";
			}
			Object[] o = singlePageService.listSinglePageByPage(new Integer(page), new Integer(rows),new Integer(oneMenuId),new Integer(twoMenuId),1);
			List<SinglePage> singlePageList = null;
			if (o != null) {
				singlePageList = (List<SinglePage>) o[1];
			}
			JsonResult jr = new JsonResult(singlePageList);
			jr.setMessage(o[0]+"");
			return jr;
		}
}
