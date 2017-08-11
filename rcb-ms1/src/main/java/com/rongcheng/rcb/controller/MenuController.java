package com.rongcheng.rcb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rongcheng.rcb.entity.OneMenu;
import com.rongcheng.rcb.entity.TwoMenu;
import com.rongcheng.rcb.exception.ForeignKeysException;
import com.rongcheng.rcb.service.one_menu.OneMenuService;
import com.rongcheng.rcb.service.two_menu.TwoMenuService;
import com.rongcheng.rcb.utils.FileTool;
import com.rongcheng.rcb.utils.JsonResult;


@Controller
@RequestMapping("/admin")
public class MenuController extends ExceptionController{
	
	@Resource
	private OneMenuService oneMenuService;
	@Resource
	private TwoMenuService twoMenuService;
	
	@ExceptionHandler(ForeignKeysException.class)
	@ResponseBody
	public JsonResult fkexp(ForeignKeysException e){
		e.printStackTrace();
		return new JsonResult(4,e);
	}
	
	//页面的跳转 栏目菜单
	@RequestMapping("/column.do")
	public String column(){
		return "backstage/column";
	}
	
	//加载Menu
	@ResponseBody
	@RequestMapping("/column/loadMenu.do")
	public JsonResult loadColume(){
		List<OneMenu> oneMenu = oneMenuService.listOneMenuAll();
		List<TwoMenu> twoMenu = twoMenuService.listTwoMenuAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oneMenu",oneMenu);
		map.put("twoMenu", twoMenu); 
		/*System.out.println("listOneMenu:"+oneMenu);
		System.out.println("listTwoMenu:"+twoMenu);
		System.out.println("map:"+map);*/
		return new JsonResult(map);
	}
	
	//删除OneMenu
	@ResponseBody
	@RequestMapping("/column/deleteOneMenu.do")
	public JsonResult deleteOneMenu(HttpServletRequest request,Integer id){
		String url = oneMenuService.getOneMenuById(id).getLink();
		int row = oneMenuService.deleteOneMenuById(id);
		FileTool.deleteFile(request, url);
		return new JsonResult(row);
	}
	
	//删除OneMenu
	@ResponseBody
	@RequestMapping("/column/deleteTwoMenu.do")
	public JsonResult deleteTwoMenu(HttpServletRequest request,Integer id){
		String url = twoMenuService.getTwoMenuById(id).getLink();
		int row = twoMenuService.deleteTwoMenuById(id);
		FileTool.deleteFile(request, url);
		return new JsonResult(row);
	}
	
	//页面的跳转 添加一级栏目
	@RequestMapping("/addColumn.do")
	public String addColumn(){
		return "backstage/addColumn";
	}
	
	//添加一级栏目按钮
	@ResponseBody
	@RequestMapping("/addColumn/addColumn.do")
	public JsonResult addColumnAddColumn(HttpServletRequest request){
		
		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		
		String title = multipartRequest.getParameter("title"); 		//（50） 标题
		String iconUrl = multipartRequest.getParameter("iconUrl");	//（100） 一级标题图标url地址
	//	String link = multipartRequest.getParameter("link");		//（500） 链接地址
		String profile = multipartRequest.getParameter("profile"); 	//（200） 简介
		String keyword = multipartRequest.getParameter("keyword"); 	//（100） 关键字
		Byte display = new Byte(multipartRequest.getParameter("display")); //（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 			//（3） 排序（默认100，取值0-255，值越小越靠前）
		String remark = multipartRequest.getParameter("remark");		//（200） 备注
		String imgPath = "";//相对项目根路径
		
		/*System.out.println(title+","+iconUrl+","+profile+","+keyword+","+display+","+seq+","+remark);*/
		
		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		OneMenu result = oneMenuService.insertOneMenu(title, iconUrl, imgPath, profile, keyword, display, seq, remark);
		return new JsonResult(result);
	}

	//页面的跳转 添加二级栏目
	@RequestMapping("/addSonColumn.do")
	public String addSonColumn(){
		return "backstage/addSonColumn";
	}
	
	//添加二级栏目按钮
	@ResponseBody
	@RequestMapping("/addSonColumn/addSonColumn.do")
	public JsonResult addSonColumnAddSonColumn(HttpServletRequest request){
		
		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		
		Integer oneMenuId = new Integer(multipartRequest.getParameter("oneMenuId")); 		//（50） 标题
		String title = multipartRequest.getParameter("title"); 		//（50） 标题
		String iconUrl = multipartRequest.getParameter("iconUrl");	//（100） 一级标题图标url地址
	//	String link = multipartRequest.getParameter("link");		//（500） 链接地址
		String profile = multipartRequest.getParameter("profile"); 	//（200） 简介
		String keyword = multipartRequest.getParameter("keyword"); 	//（100） 关键字
		Byte display = new Byte(multipartRequest.getParameter("display")); //（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 			//（3） 排序（默认100，取值0-255，值越小越靠前）
		String remark = multipartRequest.getParameter("remark");		//（200） 备注
		String imgPath = "";//相对项目根路径
		
		/*System.out.println(oneMenuId+","+title+","+iconUrl+","+profile+","+keyword+","+display+","+seq+","+remark);*/
		
		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		TwoMenu result = twoMenuService.insertTwoMenu(oneMenuId, title, iconUrl, imgPath, profile, keyword, display, seq, remark);
		return new JsonResult(result);
	}

	//页面的跳转 修改一级栏目
	@RequestMapping("/publicColumn.do")
	public String publicColumn(){
		return "backstage/publicColumn";
	}
	
	//加载oneMenu 单条信息
	@ResponseBody
	@RequestMapping("/publicColumn/loadPublicColumn.do")
	public JsonResult loadPublicColumn(Integer id){
		/*System.out.println(id);*/
		OneMenu oneMenu = oneMenuService.getOneMenuById(id);
		/*System.out.println(oneMenu);*/
		return new JsonResult(oneMenu);
	}
	
	//修改一级栏目按钮
	@ResponseBody
	@RequestMapping("/publicColum/publicColum.do")
	public JsonResult publicColumPublicColum(HttpServletRequest request){

		//转换类型
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		//获取参数
		Integer id = new Integer(multipartRequest.getParameter("id"));			//（10）（无符号型自增id）
		String title = multipartRequest.getParameter("title"); 		//（50） 标题
		String iconUrl = multipartRequest.getParameter("iconUrl");	//（100） 一级标题图标url地址
	//	String link = multipartRequest.getParameter("link");		//（500） 链接地址
		String profile = multipartRequest.getParameter("profile"); 	//（200） 简介
		String keyword = multipartRequest.getParameter("keyword"); 	//（100） 关键字
		Byte display = new Byte(multipartRequest.getParameter("display")); //（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 			//（3） 排序（默认100，取值0-255，值越小越靠前）
		String remark = multipartRequest.getParameter("remark");		//（200） 备注
		String imgPath = "";//相对项目根路径
		
		/*System.out.println(id+","+title+","+iconUrl+","+profile+","+keyword+","+display+","+seq+","+remark);*/

		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		//如果没有更新图片，返回的是error
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		if(!imgPath.equals("images/box/error")){
			String url = oneMenuService.getOneMenuById(id).getLink();
			FileTool.deleteFile(request, url);
		}else{
			imgPath = oneMenuService.getOneMenuById(id).getLink();
		}
		int row = oneMenuService.updateOneMenu(id, title, iconUrl, imgPath, profile, keyword, display, seq, remark);
		
		return new JsonResult(row);
	}
	
	//页面的跳转 修改二级栏目
	@RequestMapping("/publicSonColumn.do")
	public String publicSonColumn(){
		return "backstage/publicSonColumn";
	}
	
	//加载twoMenu 单条信息
	@ResponseBody
	@RequestMapping("/publicSonColumn/loadPublicSonColumn.do")
	public JsonResult loadPublicSonColumn(Integer id){
		/*System.out.println(id);*/
		TwoMenu twoMenu = twoMenuService.getTwoMenuById(id);
		/*System.out.println(twoMenu);*/
		return new JsonResult(twoMenu);
	}
	
	//修改二级栏目按钮
	@ResponseBody
	@RequestMapping("/publicSonColumn/publicSonColumn.do")
	public JsonResult publicSonColumn(HttpServletRequest request){

		//转换类型
		MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
		//获取参数
		/*System.out.println(multipartRequest.getParameter("id"));*/
		Integer id = new Integer(multipartRequest.getParameter("id"));			//（10）（无符号型自增id）
		Integer oneMenuId = new Integer(multipartRequest.getParameter("oneMenuId")); 		//（50） 标题
		String title = multipartRequest.getParameter("title"); 		//（50） 标题
		String iconUrl = multipartRequest.getParameter("iconUrl");	//（100） 一级标题图标url地址
	//	String link = multipartRequest.getParameter("link");		//（500） 链接地址
		String profile = multipartRequest.getParameter("profile"); 	//（200） 简介
		String keyword = multipartRequest.getParameter("keyword"); 	//（100） 关键字
		Byte display = new Byte(multipartRequest.getParameter("display")); //（3） 是否显示（默认1。0：不显示，1：显示。）
		Byte seq = new Byte(multipartRequest.getParameter("seq")); 			//（3） 排序（默认100，取值0-255，值越小越靠前）
		String remark = multipartRequest.getParameter("remark");		//（200） 备注
		String imgPath = "";//相对项目根路径
		
		/*System.out.println(id+","+oneMenuId+","+title+","+iconUrl+","+profile+","+keyword+","+display+","+seq+","+remark);*/

		// 获取项目路径
		String projectPath = FileTool.getProjectPath(multipartRequest, "/");
		//如果没有更新图片，返回的是error
		imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
		if(!imgPath.equals("images/box/error")){
			String url = twoMenuService.getTwoMenuById(id).getLink();
			FileTool.deleteFile(request, url);
		}else{
			imgPath = twoMenuService.getTwoMenuById(id).getLink();
		}
		int row = twoMenuService.updateTwoMenu(id, oneMenuId, title, iconUrl, imgPath, profile, keyword, display, seq, remark);
		
		return new JsonResult(row);
	}
}
