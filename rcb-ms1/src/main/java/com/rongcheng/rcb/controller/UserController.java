package com.rongcheng.rcb.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.rcb.entity.User;
import com.rongcheng.rcb.exception.NameException;
import com.rongcheng.rcb.exception.PasswordException;
import com.rongcheng.rcb.service.user.UserService;
import com.rongcheng.rcb.utils.JsonResult;

@Controller
@RequestMapping("/admin")
public class UserController 
			 extends ExceptionController{
	@Resource
	private UserService userService;
	
	@RequestMapping("/pass.do")
	public String pass(){
		return "backstage/pass";
	}
		//修改密码controller的修改动态操作
		@RequestMapping("/pass/modify.do")
		@ResponseBody
		public Object passModify(int userId,String name, String tel, String email, String password, String newPassword){
			User user=userService.modifyUser(userId, name, tel, email, password, newPassword);
			return new JsonResult(user);
		}
		
		@RequestMapping("/pass/loadPass.do")
		@ResponseBody
		public Object passModify(HttpSession session){
			User user=(User)session.getAttribute("user");
			user.setPassword("");
			return new JsonResult(user);
		}
	/*@RequestMapping("/admin.do")
	public String login() {
		return "backstage/login";
	}
	@ResponseBody
	@RequestMapping("/to/login.do")
	public Object login(String account, String password, String yzm, HttpServletRequest request,HttpServletResponse response, HttpSession session){
		try {
			User user=userService.login(account, password);
			// 登录成功，绑订数据到session。
			session.setAttribute("user", user);
			String userName = user.getName();
			Cookie cookie = new Cookie("userName", URLEncoder.encode(userName,"UTF-8"));
			response.addCookie(cookie);
		} catch (Exception e) {
			if (e.getMessage().equals("imgCodeError"))
				return new JsonResult("验证码错误");
			return new JsonResult("账号或密码错误");
		}
		return new JsonResult("ok");
	}*/
	
	
	
	
	
	
	
	@ExceptionHandler(NameException.class)
	@ResponseBody
	public JsonResult nameexp(NameException e){
		e.printStackTrace();
		return new JsonResult(2,e);
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult pwdexp(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}
	
	
	
	/*@RequestMapping("/index.do")
	public String index() {
		return "backstage/index";
	}*/
	

@RequestMapping("/Administrator.do")
public String Administrator(HttpSession session) {
	User user = (User)session.getAttribute("user");
	if(user.getRootAdmin()==0) return "backstage/no_power";
	return "backstage/Administrator";
}




	
	
	@RequestMapping("/add-user.do")
	public String addUser(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user.getRootAdmin()==0) return "backstage/no_power";
		return "backstage/add-user";
	}
	
	//添加管理员
	@RequestMapping("/user/add_user.do")
	@ResponseBody
	public Object addUser(String name, String account, String password, 
			String tel, String email, String remark,Byte enable,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user.getRootAdmin()==0) return "backstage/no_power";
		int n=userService.addUser(name, account, password, tel, email, remark, enable);
		return new JsonResult(n);
}
	//查询管理员
		@RequestMapping("/user/loadAdministrator.do")
		@ResponseBody
		public Object findUserAll(HttpSession session) {
			User user = (User)session.getAttribute("user");
			if(user.getRootAdmin()==0) return "backstage/no_power";
			List<User> list=userService.findUserAll();
			Iterator<User> it = list.iterator();
			while (it.hasNext()) {
				User user2 = (User) it.next();
				if(user2.getAccount().equals(user.getAccount())){
					it.remove();
				}
			}
			return new JsonResult(list);
	}
		//删除管理员
		@RequestMapping("/user/delAdministrator.do")
		@ResponseBody
		public Object  delUserById(Integer id,HttpSession session) {
			User user = (User)session.getAttribute("user");
			if(user.getRootAdmin()==0) return "backstage/no_power";
			int n=userService.delUserById(id);;
			return new JsonResult(n);
	}
			//修改管理员
		@RequestMapping("/user/modifyAdministrator.do")
		@ResponseBody
		public Object modifyAdministrator(Integer id,String name,String account,String password,String tel,
				String email,String remark,Byte enable,HttpSession session) {
			User user = (User)session.getAttribute("user");
			if(user.getRootAdmin()==0) return "backstage/index";
			userService.modifyAdministrator(id, name, account, password, tel, email, remark, enable);
			return new JsonResult();
	}
		@RequestMapping("/user/load_modify_Administrator.do")
		@ResponseBody
		public Object findById(Integer id,HttpSession session) {
			User user = (User)session.getAttribute("user");
			if(user.getRootAdmin()==0) return "backstage/no_power";
			user=userService.findById(id);
			return new JsonResult(user);
		}
		@RequestMapping("/amend_user.do")
		public String modifyUser(HttpSession session) {
			User user = (User)session.getAttribute("user");
			if(user.getRootAdmin()==0) return "backstage/no_power";
			return "backstage/amend-user";
		}
}