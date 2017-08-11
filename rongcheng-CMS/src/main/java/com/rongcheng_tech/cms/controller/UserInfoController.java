package com.rongcheng_tech.cms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.UserInfo.UserInfoService;
import com.rongcheng_tech.cms.utils.JsonResult;
@Controller
public class UserInfoController {
	
	@ResponseBody
    @RequestMapping("/test2.do ")
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		
		
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        System.out.println(request.getParameter("webPageLocation"));  
        System.out.println(request.getParameter("webPageIp"));  
        //获得发送HTTP请求的参数  
//        String webPageLocation=request.getParameter("webPageLocation");  
//        String webPageIp=request.getParameter("webPageIp");  
        //向HTTP发送方返回响应数据  
        /*if("123".equals(webPageLocation)&&"456".equals(webPageIp)){  
            response.getWriter().write("{\"falg\":\"success\"}");  
        }else{  
            response.getWriter().write("{\"falg\":\"error\"}");  
        }  */
          
    } 
	
	private int rows=20;
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private UserInfoService service;
	
	@RequestMapping("/clientele.do")
	public String toClientele(){
		return "clientele";
	}
	@RequestMapping("/clienteleAdd.do")
	public String clienteleAdd(){
		return "clienteleAdd";
	}
	@RequestMapping("/clientelePublic.do")
	public String clientelePublic(){
		return "clientelePublic";
	}
	@RequestMapping("/addresser.do")
	public String toAddresser(){
		return "addresser";
	}
	@RequestMapping("/addresserAdd.do")
	public String addresserAdd(){
		return "addresserAdd";
	}
	@RequestMapping("/addresserPublic.do")
	public String addresserPublic(){
		return "addresserPublic";
	}
	//根据页码检索商品信息
		@RequestMapping("/loadList_clientele.do")
		@ResponseBody
		public JsonResult loadUserInfo(HttpSession session,String page) {
			return loadUserInfos(session,page);
		}
		//根据页码检索
		public JsonResult loadUserInfos(HttpSession session,String page) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int max_page = (int) Math.ceil(new Double(service.findUserInfoCount(ownerId))/rows);
			if(max_page == 0){
				return new JsonResult();
			}
			List<UserInfo> UserInfo=service.findUserInfoByPage(new Integer(page)*rows-rows,rows,ownerId);
			JsonResult jr = new JsonResult(UserInfo);
			jr.setMessage(max_page+"");
			return jr;
		}
		//加载修改内容
		@RequestMapping("/load_modify_userInfo.do")
		@ResponseBody
		public JsonResult findByUserInfoId(HttpSession session,Long id){
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			UserInfo sn=service.findByUserInfoId(id, ownerId);
			return new JsonResult(sn);
		}
		//修改内容
		@RequestMapping("/modify_userInfo.do")
		@ResponseBody
		public JsonResult modifyUserInfo(Long id,String userPassword,String accountEmail,String userNickname,String userName,String userTelephone,
				String userMobile,String userAddress,Byte accountStatus,String userQuestion1,String userAnswer1,String userQuestion2,String userAnswer2,String userQuestion3,String userAnswer3,
				String note,HttpSession session){
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
			Date tamp = new Date(System.currentTimeMillis());
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int n=service.modifyUserInfo(id, ownerId,  userPassword, accountEmail, userNickname, userName, userTelephone, userMobile, userAddress, accountStatus, userQuestion1, userAnswer1, userQuestion2, userAnswer2, userQuestion3, userAnswer3, operatorId, tamp, note);
		return new JsonResult(n);
		}
		//添加内容
		@RequestMapping("/add_userInfo.do")
		@ResponseBody
		public JsonResult addUserInfo(HttpSession session,String accountNum,String userPassword,String accountEmail,String userNickname,
				String userName,String userTelephone,String userMobile,String userAddress,Byte accountStatus,String userQuestion1,String userAnswer1,String userQuestion2,String userAnswer2,String userQuestion3,String userAnswer3,String note,Byte userType){
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
			Date tamp = new Date(System.currentTimeMillis());
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int n=service.addUserInfo(ownerId, tamp, operatorId, accountNum, userPassword, accountEmail, userNickname, userName, userTelephone, userMobile, userAddress, accountStatus, userQuestion1, userAnswer1, userQuestion2, userAnswer2, userQuestion3, userAnswer3, note, userType);
		return new JsonResult(n);
		}
		//模糊查询
		@RequestMapping("/findListByUserInfo.do")
		@ResponseBody
		public JsonResult findListByUserInfo(HttpSession session,String keyword) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			List<UserInfo> list=service.findListByUserInfo(keyword, ownerId);
			return new JsonResult(list);
		}
		@RequestMapping("/findListsByUserInfo.do")
		@ResponseBody
		public JsonResult findListsByUserInfo(HttpSession session,String keyword) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			List<UserInfo> list=service.findListsByUserInfo(keyword, ownerId);
			return new JsonResult(list);
		}
		//删除单条
		@RequestMapping("/delUserInfo.do")
		@ResponseBody
		public JsonResult  delUserInfo(HttpSession session,Long id) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int n=service.delUserInfo(id, ownerId);
			return new JsonResult(n);
		}
		@RequestMapping("/modifyUserInfo1.do")
		@ResponseBody
		public JsonResult  modifyUserInfo1(Long id,String userName, String userTelephone,
				String userAddress,HttpSession session,Date gmtModified, String note) {
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
			Date tamp = new Date(System.currentTimeMillis());
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int n=service.modifyUserInfo1(id, ownerId, userName, userTelephone, userAddress,operatorId, tamp, note);
			return new JsonResult(n);
		}
		@RequestMapping("/addUserInfo1.do")
		@ResponseBody
		public JsonResult  addUserInfo1(HttpSession session, String userName,
				String userTelephone, String userAddress, String note) {
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
			Date tamp = new Date(System.currentTimeMillis());
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int n =service.addUserInfo1(ownerId, tamp, operatorId, userName, userTelephone, userAddress, note);
			return new JsonResult(n);
		}
		//批量删除
		@RequestMapping("/delUserInfoList.do")
		@ResponseBody
		public JsonResult  delUserInfoList(HttpSession session,Long[] id1) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			service.delUserInfoList(id1, ownerId);
			return new JsonResult();
		}
		//查询用户账户信息
		@RequestMapping("/getAccountNum.do")
		@ResponseBody
		public JsonResult  getAccountNum(HttpSession session,String keyword) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			List<UserInfo> list=service.getAccountNum(keyword,ownerId);
			return new JsonResult(list);
		}
		//通过用户账号查找
		@RequestMapping("/findByAccountNum.do")
		@ResponseBody
		public JsonResult  findByAccountNum(HttpSession session,String accountNum) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			UserInfo ui=service.findByAccountNum(accountNum,ownerId);
			return new JsonResult(ui);
		}
		
		
		
		
}
