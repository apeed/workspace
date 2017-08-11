package com.rongcheng.rcb.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rongcheng.rcb.entity.OneMenu;
import com.rongcheng.rcb.entity.SinglePage;
import com.rongcheng.rcb.entity.TwoMenu;
import com.rongcheng.rcb.service.one_menu.OneMenuService;
import com.rongcheng.rcb.service.single_page.SinglePageService;
import com.rongcheng.rcb.service.two_menu.TwoMenuService;
import com.rongcheng.rcb.utils.FileTool;
import com.rongcheng.rcb.utils.JsonResult;


@Controller
@RequestMapping("/admin")
public class SinglePageController {
	
	//分页相关（每页多少条）
	@Value("#{sysconfig['rows']}")
	private int rows;
	
	@Resource
	private SinglePageService singlePageServive;
	@Resource
	private OneMenuService oneMenuService;
	@Resource
	private TwoMenuService twoMenuServive;
	
	//跳转内容管理页面
	@RequestMapping("/list.do")
	public String list(){
		return "backstage/list";
	}
	
	//加载内容管理页面
	@ResponseBody
	@RequestMapping("/list/loadListByPage.do")
	public JsonResult loadListByPage(Integer page,Integer oneMenuId,Integer twoMenuId,String fuzzy){
		List<SinglePage> singlePageList = new ArrayList<SinglePage>();
		/*if(oneMenuId == null){
			oneMenuId = 0;
		}
		if(twoMenuId == null){
			twoMenuId = 0;
		}*/
		/*System.out.println(page);
		System.out.println(oneMenuId);
		System.out.println(twoMenuId);*/
		//一级二级栏目都没有选中,并且不是模糊查询
		if(oneMenuId == 0 && twoMenuId == 0 && fuzzy.equals("")){
			singlePageList = singlePageServive.listSinglePageByPage(page, rows);
		}
		//一级选中，二级没有选中，直接查找,并且不是模糊查询
		else if(oneMenuId != 0 && twoMenuId == 0 && fuzzy.equals("")){
			singlePageList = singlePageServive.listSinglePageByPageOneMenuId(page, rows, oneMenuId);
		}
		//一级没有选中，二级选中，给一级赋值再查找,并且不是模糊查询
		else if(oneMenuId == 0 && twoMenuId != 0 && fuzzy.equals("")){
			
			//一级id通过数据库查
			oneMenuId = twoMenuServive.getTwoMenuById(twoMenuId).getOneMenuId();
			
			singlePageList = singlePageServive.listSinglePageByPageMenuId(page, rows, oneMenuId, twoMenuId);
		}
		//如果是模糊查询，没有一级二级id
		else if(oneMenuId == 0 && twoMenuId == 0 && !fuzzy.equals("")){
			singlePageList = singlePageServive.listSinglePageByPageLike(page, rows, fuzzy);
		}
		/*System.out.println("----------------");
		System.out.println(oneMenuId);
		System.out.println(twoMenuId);*/
		
		//查找三个list
		List<OneMenu> oneMenuList = new ArrayList<OneMenu>();
		List<TwoMenu> twoMenuList = new ArrayList<TwoMenu>();
		
		//查找剩余两个
		for (SinglePage singlePage:singlePageList) {
			Integer oneMenuListId = singlePage.getOneMenuId();
			OneMenu oneMenu = oneMenuService.getOneMenuById(oneMenuListId);
			oneMenuList.add(oneMenu);
			Integer twoMenuListId = singlePage.getTwoMenuId();
			TwoMenu twoMenu = twoMenuServive.getTwoMenuById(twoMenuListId);
			twoMenuList.add(twoMenu);
		}
		/*System.out.println(singlePageList);
		System.out.println(oneMenuList);
		System.out.println(twoMenuList);*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("singlePageList",singlePageList);
		map.put("oneMenuList",oneMenuList);
		map.put("twoMenuList",twoMenuList);
		/*System.out.println(map);*/
		return new JsonResult(map);
	}
	
	//加载内容管理页面的数据条数
	@ResponseBody
	@RequestMapping("/list/countSinglePage.do")
	public JsonResult countSinglePage(Integer oneMenuId,Integer twoMenuId,String fuzzy){
		
		double row = 0;
		//一级二级栏目都没有选中,并且不是模糊查询
		if(oneMenuId == 0 && twoMenuId == 0 && fuzzy.equals("")){
			row = (double)singlePageServive.countSinglePage();
		}
		//一级选中，二级没有选中，直接查找,并且不是模糊查询
		else if(oneMenuId != 0 && twoMenuId == 0 && fuzzy.equals("")){
			row = (double)singlePageServive.countSinglePageByPageOneMenuId(oneMenuId);
		}
		//一级没有选中，二级选中，给一级赋值再查找,并且不是模糊查询
		else if(oneMenuId == 0 && twoMenuId != 0 && fuzzy.equals("")){
			
			//一级id通过数据库查
			oneMenuId = twoMenuServive.getTwoMenuById(twoMenuId).getOneMenuId();
			
			row = (double)singlePageServive.countSinglePageByPageMenuId(oneMenuId, twoMenuId);

		}
		//如果是模糊查询，没有一级二级id
		else if(oneMenuId == 0 && twoMenuId == 0 && !fuzzy.equals("")){
			row = (double)singlePageServive.countSinglePageByPageLike(fuzzy);
		}
		/*System.out.println(row);*/
		return new JsonResult(Math.ceil((double)row/(double)rows));
	}
	
	//内容管理删除按钮
	@ResponseBody
	@RequestMapping("/list/deleteSinglePage.do")
	public JsonResult deleteSinglePage(HttpServletRequest request,Integer singlePageId){
		String url = singlePageServive.getSinglePageById(singlePageId).getImgUrl();
		FileTool.deleteFile(request, url);
		int row = singlePageServive.deleteSinglePageById(singlePageId);
		return new JsonResult(row);
	
	}
	
	//跳转添加内容页面
	@RequestMapping("/addContent.do")
	public String addContent(){
		return "backstage/addContent";
	}
	
	//添加内容页面提交功能
	@ResponseBody
	@RequestMapping("/addContent/addContent.do")
	public JsonResult addContentAddContent(HttpServletRequest request){

		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		
		String oneMenuid = multipartRequest.getParameter("oneMenuId"); 		//（10） 一级菜单id（非空）
		String twoMenuid = multipartRequest.getParameter("twoMenuId"); 		//（10） 二级菜单（默认值-1。无二级菜单请赋值-1）
		/*System.out.println(twoMenuid);*/
		Integer oneMenuId = 0;
		Integer twoMenuId = 0;
		
		//如果没有选择菜单
		if(oneMenuid.equals("") && twoMenuid.equals("")){
			//一二级都为零，不进行操作
		}
		//如果一级菜单不为空，二级菜单为空，说明，选中一级，没有选二级
		else if(!oneMenuid.equals("") && twoMenuid.equals("")){
			//一级有id，二级为零
			oneMenuId = Integer.valueOf(oneMenuid);
		}
		//如果一级菜单为空，二级菜单不为空，说明，选中一级和二级
		else if(oneMenuid.equals("") && !twoMenuid.equals("")){
			//二级菜单直接抓到
			twoMenuId = Integer.valueOf(twoMenuid);
			//一级id通过数据库查
			oneMenuId = twoMenuServive.getTwoMenuById(twoMenuId).getOneMenuId();
		}
		
		String title = multipartRequest.getParameter("title"); 			//（50） 标题
		String shortTitle = multipartRequest.getParameter("shortTitle"); 		//（20） 短标题
		String author = multipartRequest.getParameter("author"); 			//（50） 作者
		String keyword = multipartRequest.getParameter("keyword"); 		//（100） 关键字
		String profile = multipartRequest.getParameter("profile"); 		//（200） 简介
		String content1 = multipartRequest.getParameter("content1"); 		//（text） 主内容1
		String content2 = multipartRequest.getParameter("content2"); 		//（text） 主内容2
		String content3 = multipartRequest.getParameter("content3"); 		//（text） 主内容3
		Byte display = new Byte(multipartRequest.getParameter("display")); 			//（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 				//（3） 排序（默认100，取值0-255，值越小越靠前）
		Integer click = new Integer(multipartRequest.getParameter("click")); 			//（10） 点击量（默认值0）
		String remark = multipartRequest.getParameter("remark"); 			//（200） 备注
		
		String imgPath = "";//相对项目根路径
		
		/*System.out.println(oneMenuId+","+title+","+iconUrl+","+profile+","+keyword+","+display+","+seq+","+remark);*/
		
		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		int row = singlePageServive.insertSinglePage(oneMenuId, twoMenuId, title, shortTitle, author, imgPath, keyword, profile, content1, content2, content3, display, seq, click, remark);
		return new JsonResult(row);
	
	}
	
	//跳转修改内容页面
	@RequestMapping("/amendContent.do")
	public String amendContent(){
		return "backstage/amendContent";
	}
	
	//修改内容页面加载内容
	@ResponseBody
	@RequestMapping("/amendContent/loadAmendContent.do")
	public JsonResult loadAmendContent(Integer id){
		SinglePage singlePage = singlePageServive.getSinglePageById(id);
		/*System.out.println(singlePage);*/
		return new JsonResult(singlePage);
	}

	//修改内容页面提交功能
	@ResponseBody
	@RequestMapping("/amendContent/amendContent.do")
	public JsonResult amendContentAmendContent(HttpServletRequest request){

		//转换类型
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		//获取参数
		Integer id = new Integer(multipartRequest.getParameter("id")); 		//（10） id（非空）
		String oneMenuid = multipartRequest.getParameter("oneMenuId"); 		//（10） 一级菜单id（非空）
		String twoMenuid = multipartRequest.getParameter("twoMenuId"); 		//（10） 二级菜单（默认值-1。无二级菜单请赋值-1）
		/*System.out.println(twoMenuid);*/
		Integer oneMenuId = 0;
		Integer twoMenuId = 0;
		
		//如果没有选择菜单
		if(oneMenuid.equals("") && twoMenuid.equals("")){
			//一二级都为零，不进行操作
		}
		//如果一级菜单不为空，二级菜单为空，说明，选中一级，没有选二级
		else if(!oneMenuid.equals("") && twoMenuid.equals("")){
			//一级有id，二级为零
			oneMenuId = Integer.valueOf(oneMenuid);
		}
		//如果一级菜单为空，二级菜单不为空，说明，选中一级和二级
		else if(oneMenuid.equals("") && !twoMenuid.equals("")){
			//二级菜单直接抓到
			twoMenuId = Integer.valueOf(twoMenuid);
			//一级id通过数据库查
			oneMenuId = twoMenuServive.getTwoMenuById(twoMenuId).getOneMenuId();
		}
		
		String title = multipartRequest.getParameter("title"); 			//（50） 标题
		String shortTitle = multipartRequest.getParameter("shortTitle"); 		//（20） 短标题
		String author = multipartRequest.getParameter("author"); 			//（50） 作者
		String keyword = multipartRequest.getParameter("keyword"); 		//（100） 关键字
		String profile = multipartRequest.getParameter("profile"); 		//（200） 简介
		String content1 = multipartRequest.getParameter("content1"); 		//（text） 主内容1
		String content2 = multipartRequest.getParameter("content2"); 		//（text） 主内容2
		String content3 = multipartRequest.getParameter("content3"); 		//（text） 主内容3
		Byte display = new Byte(multipartRequest.getParameter("display")); 			//（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 				//（3） 排序（默认100，取值0-255，值越小越靠前）
		Integer click = new Integer(multipartRequest.getParameter("click")); 			//（10） 点击量（默认值0）
		String remark = multipartRequest.getParameter("remark"); 			//（200） 备注
		
		String imgPath = "";//相对项目根路径
		
		/*System.out.println("oneMenuId:"+oneMenuId);
		System.out.println("twoMenuId:"+twoMenuId);*/

		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		//如果没有更新图片，返回的是error
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		if(!imgPath.equals("images/box/error")){
			String url = singlePageServive.getSinglePageById(id).getImgUrl();
			FileTool.deleteFile(request, url);
		}else{
			imgPath = singlePageServive.getSinglePageById(id).getImgUrl();
		}
		int row = singlePageServive.updateSinglePage(id, oneMenuId, twoMenuId, title, shortTitle, author, imgPath, keyword, profile, content1, content2, content3, display, seq, click, remark);
		
		return new JsonResult(row);
	
	}
}
