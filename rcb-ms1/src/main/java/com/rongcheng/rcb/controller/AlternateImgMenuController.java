package com.rongcheng.rcb.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.entity.AlternateImgModule;
import com.rongcheng.rcb.service.AlternateImg.AlternateImgService;
import com.rongcheng.rcb.service.AlternateImgModule.AlternateImgModuleService;
import com.rongcheng.rcb.utils.FileTool;
import com.rongcheng.rcb.utils.JsonResult;
	@Controller
	@RequestMapping("/admin")
	public class AlternateImgMenuController{
		@Resource
		private AlternateImgService aiservice;
		@Resource
		private AlternateImgModuleService aimservice;
		//加载Menu
		@ResponseBody
		@RequestMapping("/column/loadAIMenu.do")
		public JsonResult loadAIColume(){
			List<AlternateImg> aiMenu = aiservice.findAlternateImgAll();
			List<AlternateImgModule> aimMenu = aimservice.findAlternateImgModuleAll();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("aimenu",aiMenu);
			map.put("aimmenu", aimMenu); 
			/*System.out.println("listOneMenu:"+aiMenu);
			System.out.println("listTwoMenu:"+aimMenu);
			System.out.println("map:"+map);*/
			return new JsonResult(map);
		}
		@RequestMapping("/amend-advTitle.do")
		public String modifyAdvTitle() {
			return "backstage/amend-advTitle";
		}
		@RequestMapping("/addadv.do")
		public String addadv() {
			return "backstage/addadv";
		}
		@RequestMapping("/amend_adv.do")
		public String modifyAdv() {
			return "backstage/amend-adv";
		}
		//adv页面删除内容
		@ResponseBody
		@RequestMapping("/adv/delAiMenu.do")
		public Object del(int id){
			int h=aiservice.delAlternateImgById(id);
				return new JsonResult(h);	
		}
		//加载修改信息 
		@ResponseBody
		@RequestMapping("/adv/loadAmend.do")
		public JsonResult findAlternateImgById(int id){
			AlternateImg ai = aiservice.findAlternateImgById(id);
			return new JsonResult(ai);
		}
		//加载修改信息 
		@ResponseBody
		@RequestMapping("/adv/loadTitle.do")
		public JsonResult findAlternateImgModuleById(int id){
			AlternateImgModule aim = aimservice.findAlternateImgModuleById(id);
			return new JsonResult(aim);
		}
	
		//adv页面修改内容
		@ResponseBody
		@RequestMapping("/adv/modifyTitle.do")
		public Object modifyAmend(int id,String moduleName,String remark,Byte display){
			int row1=aimservice.modifyHomeImg(id, moduleName, remark, display);
			return new JsonResult(row1);	
		}		
		/**/
		
		
				//amendadv页面修改内容
				@ResponseBody
				@RequestMapping("/adv/modifyAmend.do")
				public JsonResult modifyAmend(HttpServletRequest request){
				
					MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
					
					Integer id = new Integer(multipartRequest.getParameter("id"));
					String title = multipartRequest.getParameter("title"); 
					String imgUrl = multipartRequest.getParameter("imgUrl"); 
					
					String keyword = multipartRequest.getParameter("keyword"); 
					String remark = multipartRequest.getParameter("remark"); 
					String profile = multipartRequest.getParameter("profile"); 
					Byte display = new Byte(multipartRequest.getParameter("display"));
					Byte seq = new Byte(multipartRequest.getParameter("seq"));
					String imgPath = "";//相对项目根路径
					// 获取项目路径
					String projectPath = FileTool.getProjectPath(multipartRequest, "/");
					imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
					
					
					int row=aiservice.modifyAlternateImg(id,title, imgUrl, keyword, imgPath, remark, profile, display, seq);
					return new JsonResult(row);	
				}
				//adv页面添加内容
				@ResponseBody
				@RequestMapping("/adv/addAlternateImgCol.do")
				public JsonResult addAlternateImgCol(HttpServletRequest request){
					MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
					Integer moduleId = new Integer(multipartRequest.getParameter("moduleId"));
					String title = multipartRequest.getParameter("title"); 
					String link = multipartRequest.getParameter("link"); 
					String keyword = multipartRequest.getParameter("keyword"); 
					String remark = multipartRequest.getParameter("remark"); 
					String profile = multipartRequest.getParameter("profile"); 
					Byte display = new Byte(multipartRequest.getParameter("display"));
					Byte seq = new Byte(multipartRequest.getParameter("seq"));
					
					String imgPath = "";//相对项目根路径
					// 获取项目路径
					String projectPath = FileTool.getProjectPath(multipartRequest, "/");
					imgPath = "images/box/" + FileTool.fileSaveSrc(multipartRequest, projectPath, "images/box/", "", "");
					System.out.println(moduleId+"--"+imgPath);
					int row=aiservice.addAlternateImgCol(moduleId, title,imgPath , keyword, link, remark, profile, display, seq);
					return new JsonResult(row);	
				}
}
	
	

	