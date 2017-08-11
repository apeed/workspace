package com.rongcheng.rcb.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.rcb.entity.User;
import com.rongcheng.rcb.service.user.UserService;
import com.rongcheng.rcb.utils.ImgCodeUtil;
import com.rongcheng.rcb.utils.JsonResult;


@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/admin.do")
	public String toLogin(HttpSession session){
		session.removeAttribute("user");
		return "backstage/login";
	}
	
	@RequestMapping("/admin/index.do")
	public String index(){
		return "backstage/index";
	}
	
	@ResponseBody
	@RequestMapping("/login.do")
	public JsonResult login(String account, String password, String yzm, HttpServletRequest request,HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
		String imgCode = (String) request.getSession().getAttribute("imgCode");
		try {
			System.out.println(account+password);
			User user = userService.checkLogin(account, password, yzm, imgCode);
			// 登录成功，绑订数据到session。
			session.setAttribute("user", user);
			String userName = user.getName();
			Cookie cookie = new Cookie("userName", URLEncoder.encode(userName,"UTF-8"));
			response.addCookie(cookie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().equals("imgCodeError"))
				return new JsonResult("验证码错误");
			if (!e.getMessage().equals("userError"))
				return new JsonResult("账号或密码错误");
			return new JsonResult("账号已被冻结");
		}
		return new JsonResult("ok");
	}
	
	@RequestMapping("/createImg.do")
	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// System.out.println("createImg");
		// 生成验证码及图片
		Object[] objs = ImgCodeUtil.createImage();
		// 将验证码存入session
		String imgCode = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("imgCode", imgCode);
		// 将图片输出给浏览器
		res.setContentType("image/jpeg");
		// res.setHeader("Content-Type","image/jpeg");
		BufferedImage img = (BufferedImage) objs[1];
		// 该输出流由tomcat创建，目标是浏览器
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "jpeg", os);
		os.close();
	}
}
