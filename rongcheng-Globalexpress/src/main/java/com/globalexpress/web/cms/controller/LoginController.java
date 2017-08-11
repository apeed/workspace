package com.globalexpress.web.cms.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globalexpress.web.cms.dao.UserConfigSettingsDAO;
import com.globalexpress.web.cms.dao.UserInfoDAO_JXB;
import com.globalexpress.web.cms.dao.VipUserDAO;
import com.globalexpress.web.cms.service.UserConfigSettings.UserConfigSettingsService;
import com.globalexpress.web.cms.service.UserInfo.UserInfoService_JXB;
import com.globalexpress.web.cms.util.IpTool;
import com.globalexpress.web.cms.util.UrlTool;
import com.globalexpress.web.entity.UserConfigSettings;
import com.globalexpress.web.entity.UserInfo;
import com.globalexpress.web.entity.VipUser;
import com.globalexpress.web.util.ImgCodeUtil;
import com.globalexpress.web.util.JimlUtil;
import com.globalexpress.web.util.JsonResult;
/**
 * 
 * @author jiml
 *
 */
@Controller
public class LoginController {
	//分页相关（每页多少条）
	@Value("#{config['rows']}")
	private int rows;
	//版本号
	@Value("#{config['version']}")
	private String version;
	//ownerId
	//@Value("#{config['ownerId']}")
	//private Long ownerId;
	//全局变量，网页地址
	String webPageLocation;
    //全局变量，IP地址
    String webPageIp = "";
	@Resource
	private UserConfigSettingsDAO configDAO;
	@Resource
    private VipUserDAO vipUserDAO;
	@Resource
	private UserConfigSettingsService userConfigSettingsService;
	@Resource
	private UserInfoDAO_JXB userInfoDAO_JXB;
	@Resource
	private UserInfoService_JXB userInfoServiceJXB;
	/*@Resource
	private DerivedContentPageService blockChannelService;*/

	// 到登录页
	@RequestMapping("/admin.do")
	public String admin(HttpServletRequest request, HttpSession session) throws UnknownHostException {
		
	    session.removeAttribute("user");
		request.setAttribute("version", version);
		
		ServletContext sc = request.getServletContext();
        String url = request.getRequestURL().toString();
        sc.setAttribute("webPageLocation", url);
        
        String nowIp = null;
        try {
            nowIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e1) {}
        
        if (!url.equals(webPageLocation) || !webPageIp.equals(nowIp)) {
            //覆盖地址
            webPageLocation = url;
            //覆盖IP
            webPageIp = nowIp;
            //发送url
            UrlTool.sendUrl(webPageLocation, nowIp);
        }
		return "admin/login";
	}
	
	/**
	 * 需要摘除
	 * VipUser, VipUserDAO, VipUserMapper, 和该方法
	 * @author 赵滨
	 */
	@RequestMapping("/vipUser.do")
	public void vipUser(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
	    //获取参数
	    String location = request.getParameter("webPageLocation");
        String ip = request.getParameter("webPageIp");
        
	    //创建对象
	    VipUser vipUser = new VipUser();
        vipUser.setVipLink(location);
        
        //转换格式
        int vipIp = IpTool.ipToInt(ip); 
        vipUser.setVipIp(vipIp);
        
        //时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        vipUser.setGmtCreate(time);
        vipUser.setOwnerId(1L);
        vipUser.setVipType(2);
        
        //保存
        vipUserDAO.saveVipUser(vipUser);
        
	}
	
	// 到后台主页
	@RequestMapping("/admin/index.do")
	public String adminIndex(HttpServletRequest request, HttpSession session) {
		request.setAttribute("type", ((UserInfo)session.getAttribute("user")).getUserType());
		request.setAttribute("version", version);
		return "admin/index";
	}
	// 后台主页第一屏
	@RequestMapping("/admin/first.do")
	public String adminFirst(HttpServletRequest request, HttpSession session) {
		UserInfo user = (UserInfo)session.getAttribute("user");
		String ip = (String)session.getAttribute("ip");
		Date loginTime = (Date)session.getAttribute("userTemp");
		UserInfo userTemp = user.clone();
		userTemp.setUserPassword(null);
		
		UserConfigSettings config = new UserConfigSettings();
		config.setOwnerId(user.getOwnerId());
		config.setParameterName("siteTitle");
		config = configDAO.getSelective(config);
		request.setAttribute("user", userTemp);
		request.setAttribute("siteTitle", config==null?"":config.getParameterValue1());
		request.setAttribute("ip", ip);
		request.setAttribute("loginTime", loginTime);
		request.setAttribute("version", version);
		return "admin/first";
	}
	// 后台主页第一屏点击热度查询
	/*@RequestMapping("/admin/first/heat.do")
	@ResponseBody
	public JsonResult1 adminFirstHeat(HttpServletRequest request, HttpSession session) {
		int page = new Integer(request.getParameter("page"));
		UserInfo user = (UserInfo)session.getAttribute("user");
		Long ownerId = user.getOwnerId();
		Object[] o = blockChannelService.pageByOwnerIdOrderByClick(ownerId, "desc", page, rows);
		if(o == null){
			return new JsonResult1(0,null,"0");
		}
		String maxPage = o[0]+"";
		List<BlockChannel> blockChannelList = (List<BlockChannel>) o[1];
		return new JsonResult1(0,blockChannelList,maxPage);
	}*/
	
	@ResponseBody
	@RequestMapping("/login.do")
	public JsonResult login(String account, String password, String yzm, HttpServletRequest request,HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
		String imgCode = (String) request.getSession().getAttribute("imgCode");
		try {
			System.out.println(account);
			UserInfo user = userInfoServiceJXB.checkLogin(account, password, yzm, imgCode);
			/*if(user.getUserType()==1){
				user.setOwnerId(user.getId());
			}else{
				user.setOwnerId(user.getOwnerId());
			}*/
			//user.setOwnerId(ownerId);
			// 登录成功，绑订数据到session。
			String ip = JimlUtil.getIp(request);
			session.setAttribute("user", user);
			session.setAttribute("loginTime", new Date());
			session.setAttribute("ip", ip);
			session.removeAttribute("imgCode");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(e.getMessage()==null)return new JsonResult("账号已被冻结");
			if (e.getMessage().equals("imgCodeError"))
				return new JsonResult("验证码错误");
			if (!e.getMessage().equals("userError"))
				return new JsonResult("账号或密码错误");
			return new JsonResult("账号已被冻结");
		}
		return new JsonResult("ok");
	}
	
	@RequestMapping("/createImg.do")
	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws IOException, ScriptException {
		// System.out.println("createImg");
		// 生成验证码及图片
		Object[] objs = ImgCodeUtil.createImage(1);
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
