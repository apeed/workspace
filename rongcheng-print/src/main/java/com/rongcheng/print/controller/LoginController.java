package com.rongcheng.print.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.print.entity.UserInfo;
import com.rongcheng.print.service.UserInfo.UserInfoService;
import com.rongcheng.print.utils.ImgCodeUtil;
import com.rongcheng.print.utils.JsonResult;

@Controller
public class LoginController {
	
	@Resource
	private UserInfoService service;
	
	@RequestMapping("/admin.do")
	public String toLogin(HttpSession session){
		session.removeAttribute("user");
		return "login";
	}
	@RequestMapping("/sign.do")
	public String toSign(){
		return "sign";
	}
	@RequestMapping("/index.do")
	public String toIndex(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/login.do")
	public JsonResult login(String accountNum, String password, String yzm, HttpServletRequest request,HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
		String imgCode = (String) request.getSession().getAttribute("imgCode");
		String userName = null;
		BigInteger ownerId = null;
		try {
			UserInfo ui = service.checkLogin(accountNum, password, yzm, imgCode);
			// 登录成功，绑订数据到session。
			session.setAttribute("user", ui);
			userName = ui.getName();
			ownerId = ui.getOwnerId();
			//System.out.println(userName+ownerId);
			//System.out.println(e.getMessage());
		} catch (Exception e) {
			if (e.getMessage().equals("imgCodeError"))
				return new JsonResult("验证码错误");
			else if (!e.getMessage().equals("userError"))
				return new JsonResult("账号或密码错误");
//			return new JsonResult("账号已被冻结");
		}
		Map<String, Object> map  = new HashMap<String, Object>();
		//if(userName!=null||ownerId!=null){}
			map.put("userName", userName);
			map.put("ownerId", ownerId);
			return new JsonResult(map);
//		System.out.println(map.get("ownerId"));
	}
	
	@RequestMapping("/createImg.do")
	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// System.out.println("createImg");
		// 生成验证码及图片
		Object[] objs = ImgCodeUtil.createImage();
		// 将验证码存入session
		String imgCode = (String) objs[0];
		System.out.println(imgCode);
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
