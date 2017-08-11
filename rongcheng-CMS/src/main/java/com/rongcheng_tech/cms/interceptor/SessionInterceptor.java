package com.rongcheng_tech.cms.interceptor;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rongcheng_tech.cms.dao.UserInfoDAO_JXB;
import com.rongcheng_tech.cms.entity.UserInfo;


/**
 * 用于session验证的拦截器
 *
 */
public class SessionInterceptor implements HandlerInterceptor {
	//ownerId
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private UserInfoDAO_JXB dao;
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		if (user == null || dao.getByOwnerIdAndAccountNum(ownerId,user.getAccountNum())==null) {
			// 没有登录或失效,重定向到登录页面
			//res.sendRedirect("/admin.do");
			PrintWriter out = res.getWriter();  
			out.println("<script>window.open('/admin.do','_top')</script>");  
			// res.addCookie(new Cookie("reLogin", "1"));
			return false;
		}else if(!dao.getByOwnerIdAndAccountNum(ownerId,user.getAccountNum()).getUserPassword().equals(user.getUserPassword())){
			// 没有登录或失效,重定向到登录页面
			//res.sendRedirect("/admin.do");
			PrintWriter out = res.getWriter();  
	        out.println("<script>window.open ('/admin.do','_top')</script>");      
			// res.addCookie(new Cookie("reLogin", "1"));
			return false;
		}
		// 已经登录过，则继续向下执行。
		return true;
	}

}