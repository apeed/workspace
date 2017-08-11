package com.rongcheng.rcb.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于session验证的拦截器
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if (user == null) {
			// 没有登录或失效,重定向到登录页面
			//res.sendRedirect("/admin.do");
			PrintWriter out = res.getWriter();  
	        out.println("<html>");      
	        out.println("<script>");      
	        out.println("window.open ('/admin.do','_top')");      
	        out.println("</script>");      
	        out.println("</html>");    
			// res.addCookie(new Cookie("reLogin", "1"));
			return false;
		}
		// 已经登录过，则继续向下执行。
		return true;
	}

}
