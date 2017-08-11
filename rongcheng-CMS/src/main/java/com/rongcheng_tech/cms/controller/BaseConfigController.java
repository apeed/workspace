package com.rongcheng_tech.cms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng_tech.cms.dao.UserConfigSettingsDAO;
import com.rongcheng_tech.cms.dao.UserInfoDAO_JXB;
import com.rongcheng_tech.cms.entity.UserConfigSettings;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.UserConfigSettings.UserConfigSettingsService;
import com.rongcheng_tech.cms.service.UserInfo.UserInfoService_JXB;
import com.rongcheng_tech.cms.utils.JimlUtils;

@Controller
@RequestMapping("/admin/config")
public class BaseConfigController {
	//分页相关（每页多少条）
	@Value("#{sysconfig['rows']}")
	private int rows;
	//ownerId
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private UserConfigSettingsDAO configDAO;
	@Resource
	private UserConfigSettingsService configService;
	@Resource
	private UserInfoDAO_JXB userInfoDAO_JXB;
	@Resource
	private UserInfoService_JXB userInfoService_JXB;

	//到网站信息配置页
	@RequestMapping("/siteconfig.do")
	public String siteConfig(HttpServletRequest request, HttpSession session) {
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		HashMap<String, Object> map = configService.getMapConfig(new UserConfigSettings(ownerId));
		map.put("ownerId", ownerId);
		request.setAttribute("configMap", map);
		return "admin/config/config-site";
	}
	
	//到用户信息修改页
	@RequestMapping("/userconfig.do")
	public String userConfig(HttpServletRequest request, HttpSession session) {
		Long id = ((UserInfo)session.getAttribute("user")).getId();
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		UserInfo user = null;
		if(request.getParameter("userId")==null){
			user = userInfoDAO_JXB.getById(ownerId, id);
			request.setAttribute("user", user);
			return "admin/config/config-user";
		}else{
			Long userId = new Long(request.getParameter("userId"));
			user = userInfoDAO_JXB.getById(ownerId, userId);
			request.setAttribute("user", user);
			System.out.println(1);
			return "admin/config/config-users-update";
		}
	}

	//到用户管理页
	@RequestMapping("/usersconfig.do")
	public String usersConfig() {
		return "admin/config/config-users";
	}
	
	//到增加管理员页
	@RequestMapping("/toadduser.do")
	public String toAddUser() {
		return "admin/config/config-user-add";
	}
	
	
	
	//更新网站信息配置
	@RequestMapping("/updateconfig.do")
	@ResponseBody
	public Object updateConfig(HttpServletRequest request, HttpSession session) {
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		List<UserConfigSettings> configList = new ArrayList<UserConfigSettings>();
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = request.getParameter(name);
			UserConfigSettings config = new UserConfigSettings();
			config.setOwnerId(ownerId);
			config.setParameterName(name);
			config.setParameterValue1(value);
			configList.add(config);
		}
		String imgPath = "/images/";
		Map<String, String> map = JimlUtils.fileSaveSrc2(request, imgPath, ownerId+"");
		Set<Entry<String,String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			UserConfigSettings config = new UserConfigSettings();
			config.setOwnerId(ownerId);
			config.setParameterName(entry.getKey());
			config.setParameterValue1(imgPath+entry.getValue());
			config.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
			configList.add(config);
		}
		return configDAO.updateSelective(configList);
	}
	//更新当前用户信息
	@RequestMapping("/updatenowuser.do")
	@ResponseBody
	public Object updateNowUser(HttpServletRequest request, HttpSession session) {
		UserInfo sessionUser = (UserInfo)session.getAttribute("user");
		Long id = ((UserInfo)session.getAttribute("user")).getId();
		String userName = request.getParameter("userName");
		String userTelephone = request.getParameter("userTelephone");
		String accountEmail = request.getParameter("accountEmail");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String userMobile = request.getParameter("userMobile");
		String userAddress = request.getParameter("userAddress");
		String userQuestion1 = request.getParameter("userQuestion1");
		String userAnswer1 = request.getParameter("userAnswer1");
		String userQuestion2 = request.getParameter("userQuestion2");
		String userAnswer2 = request.getParameter("userAnswer2");
		String userQuestion3 = request.getParameter("userQuestion3");
		String userAnswer3 = request.getParameter("userAnswer3");
		
		UserInfo user = new UserInfo();
		user.setId(id);
		user.setGmtModified(new Date());
		if(userName!=null&&!userName.trim().equals("")){
			user.setUserName(userName);
		}
		if(userTelephone!=null&&!userTelephone.trim().equals("")){
			user.setUserTelephone(userTelephone);
		}
		if(accountEmail!=null&&!accountEmail.trim().equals("")){
			user.setAccountEmail(accountEmail);
		}
		if(password!=null&&!password.trim().equals("")){
			user.setUserPassword(password);
		}
		if(newPassword!=null&&!newPassword.trim().equals("")){
			user.setUserNewPassword(newPassword);
		}
		if(userMobile!=null&&!userMobile.trim().equals("")){
			user.setUserMobile(userMobile);
		}
		if(userAddress!=null&&!userAddress.trim().equals("")){
			user.setUserAddress(userAddress);
		}
		if(userQuestion1!=null&&!userQuestion1.trim().equals("")){
			user.setUserQuestion1(userQuestion1);
			user.setUserAnswer1(userAnswer1);
		}
		if(userQuestion2!=null&&!userQuestion2.trim().equals("")){
			user.setUserQuestion2(userQuestion2);
			user.setUserAnswer2(userAnswer2);
		}
		if(userQuestion3!=null&&!userQuestion3.trim().equals("")){
			user.setUserQuestion3(userQuestion3);
			user.setUserAnswer3(userAnswer3);
		}
		int n = userInfoDAO_JXB.updateNowUserSelective(user);
		if(n == 1){
			sessionUser.setGmtModified(new Date());
			if(userName!=null&&!userName.trim().equals("")){
				sessionUser.setUserName(userName);
			}
			if(userTelephone!=null&&!userTelephone.trim().equals("")){
				sessionUser.setUserTelephone(userTelephone);
			}
			if(accountEmail!=null&&!accountEmail.trim().equals("")){
				sessionUser.setAccountEmail(accountEmail);
			}
			if(password!=null&&!password.trim().equals("")){
				sessionUser.setUserPassword(password);
			}
			if(newPassword!=null&&!newPassword.trim().equals("")){
				sessionUser.setUserNewPassword(newPassword);
			}
			if(userMobile!=null&&!userMobile.trim().equals("")){
				sessionUser.setUserMobile(userMobile);
			}
			if(userAddress!=null&&!userAddress.trim().equals("")){
				sessionUser.setUserAddress(userAddress);
			}
			if(userQuestion1!=null&&!userQuestion1.trim().equals("")){
				sessionUser.setUserQuestion1(userQuestion1);
				sessionUser.setUserAnswer1(userAnswer1);
			}
			if(userQuestion2!=null&&!userQuestion2.trim().equals("")){
				sessionUser.setUserQuestion2(userQuestion2);
				sessionUser.setUserAnswer2(userAnswer2);
			}
			if(userQuestion3!=null&&!userQuestion3.trim().equals("")){
				sessionUser.setUserQuestion3(userQuestion3);
				sessionUser.setUserAnswer3(userAnswer3);
			}
		}
		return n;
	}
	//更新当前账号下子账号信息
	@RequestMapping("/updateuser.do")
	@ResponseBody
	public Object updateUser(HttpServletRequest request, HttpSession session) {
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		
		Long userId = new Long(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String userTelephone = request.getParameter("userTelephone");
		String accountEmail = request.getParameter("accountEmail");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String note = request.getParameter("note");
		String accountStatus = request.getParameter("accountStatus");
		
		UserInfo user = new UserInfo();
		user.setId(userId);
		user.setOwnerId(ownerId);
		user.setGmtModified(new Date());
		if(userName!=null&&!userName.trim().equals("")){
			user.setUserName(userName);
		}
		if(userTelephone!=null&&!userTelephone.trim().equals("")){
			user.setUserTelephone(userTelephone);
		}
		if(accountEmail!=null&&!accountEmail.trim().equals("")){
			user.setAccountEmail(accountEmail);
		}
		if(password!=null&&!password.trim().equals("")){
			user.setUserPassword(password);
		}
		if(newPassword!=null&&!newPassword.trim().equals("")){
			user.setUserNewPassword(newPassword);
		}
		if(note!=null&&!note.trim().equals("")){
			user.setNote(note);
		}
		if(accountStatus!=null&&!accountStatus.trim().equals("")){
			user.setAccountStatus(new Byte(accountStatus));
		}
		
		return userInfoDAO_JXB.updateSelective(user);
	}
	//删除用户
	@RequestMapping("/deleteuser.do")
	@ResponseBody
	public Object deleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		String[] userId = request.getParameterValues("userId");
		int n = userInfoDAO_JXB.deleteByOwnerIdAndIds(ownerId, userId);
		return n;
	}
	//检查欲增账号的可用性
	@RequestMapping("/chickuser.do")
	@ResponseBody
	public Object chickUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String accountNum = request.getParameter("accountNum");
		UserInfo user = userInfoDAO_JXB.getByOwnerIdAndAccountNum(ownerId,accountNum);
		if(user == null){
			return 0;
		}
		return 1;
	}
	//新添用户
	@RequestMapping("/adduser.do")
	@ResponseBody
	public Object addUser(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		Byte userType = ((UserInfo)session.getAttribute("user")).getUserType();
		if(userType != 1){
			return -1;
		}
		
		String userName = request.getParameter("userName");
		String accountNum = request.getParameter("accountNum");
		String password = request.getParameter("password");
		String userTelephone = request.getParameter("userTelephone");
		String accountEmail = request.getParameter("accountEmail");
		String note = request.getParameter("note");
		String accountStatus = request.getParameter("accountStatus");
		
		UserInfo user = new UserInfo();
		user.setUserType(new Byte("2"));
		user.setOwnerId(ownerId);
		user.setOperatorId(ownerId);
		user.setAdmin(true);
		user.setRootAccount(false);;
		user.setGmtCreate(new Date());
		if(accountNum!=null&&!accountNum.trim().equals("")){
			user.setAccountNum(accountNum);
		}
		if(userName!=null&&!userName.trim().equals("")){
			user.setUserName(userName);
		}
		if(userTelephone!=null&&!userTelephone.trim().equals("")){
			user.setUserTelephone(userTelephone);
		}
		if(accountEmail!=null&&!accountEmail.trim().equals("")){
			user.setAccountEmail(accountEmail);
		}
		if(password!=null&&!password.trim().equals("")){
			user.setUserPassword(password);
		}
		if(note!=null&&!note.trim().equals("")){
			user.setNote(note);
		}
		if(accountStatus!=null&&!accountStatus.trim().equals("")){
			user.setAccountStatus(new Byte(accountStatus));
		}
		return userInfoDAO_JXB.insertSelective(user);
	}
	//根据页码加载用户信息
	@RequestMapping("/loadusersinfo.do")
	@ResponseBody
	public Object LoadUsersInfo(HttpServletRequest request, HttpSession session) {
		/*Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();*/
		int page = new Integer(request.getParameter("page"));System.out.println(page);
		Object[] array = userInfoService_JXB.listByOwnerIdAndPage(ownerId, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 0);
		map.put("maxPage", array[0]);
		map.put("users", array[1]);
		return map;
	}
}
