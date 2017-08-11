package com.rongcheng.rcb.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.entity.AlternateImgModule;
import com.rongcheng.rcb.service.AlternateImg.AlternateImgService;
import com.rongcheng.rcb.service.AlternateImgModule.AlternateImgModuleService;
import com.rongcheng.rcb.utils.JsonResult;
	@Controller
	@RequestMapping("/admin")
	public class AlternateImgModuleController{
		@Resource
		private AlternateImgService aiservice;
		@Resource
		private AlternateImgModuleService service;
		@ResponseBody
		@RequestMapping("/addAdvTitle/addTitleCol.do")
		public Object add(String moduleName,String remark,Byte display){

			int row=service.addAlternateImgCol(moduleName, remark, display);
			return new JsonResult(row);	
		}
		
		@RequestMapping("/adv.do")
		public String adv() {
			return "backstage/adv";
		}
		@RequestMapping("/addAdv_title.do")
		public String addAdvTitle() {
			return "backstage/addAdv-title";
		}
		@RequestMapping("/alternateimgmodule/delete.do")
		@ResponseBody
		public Object deleteAlternateImgModule(HttpServletRequest request,HttpServletResponse response) {
			String moduleId = request.getParameter("moduleId");
			service.delAlternateImgModuleById(new Integer(moduleId));
			
			List<AlternateImg> aiMenu = aiservice.findAlternateImgAll();
			List<AlternateImgModule> aimMenu = service.findAlternateImgModuleAll();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("aimenu",aiMenu);
			map.put("aimmenu", aimMenu); 
			/*System.out.println("listOneMenu:"+aiMenu);
			System.out.println("listTwoMenu:"+aimMenu);
			System.out.println("map:"+map);*/
			return new JsonResult(map);
			
		}
		
		
		
		
}
	
	

	