package com.rongcheng.print.controller;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rongcheng.print.entity.PrintTemplate;
import com.rongcheng.print.service.PrintTemplate.PrintTemplateService;
import com.rongcheng.print.utils.JsonResult;

@Controller
public class PrintTemplateController {
	@Resource
	private PrintTemplateService service;
	
	/*@RequestMapping("/account_add_amend.do")
	public String account(){
		return "account_add_amend";
	}*/
	@RequestMapping("/findtemplateId.do")
	@ResponseBody
	public JsonResult findtemplateType(BigInteger carrierId){
		List<PrintTemplate> pt=service.findtemplateType(carrierId);
	return new JsonResult(pt);
	}
	@RequestMapping("/findtemplateName.do")
	@ResponseBody
	public JsonResult findtemplateName(BigInteger id){
		PrintTemplate pt=service.findtemplateName(id);
	return new JsonResult(pt);
	}
	/*@RequestMapping("/ExpressPartition.do")
	public String news(HttpServletRequest request,BigInteger carrierId) {
		List<PrintTemplate> pt=service.findtemplateType(carrierId);
		request.setAttribute("printTemplate", pt);
		return "ExpressPartition";
	}*/
}
