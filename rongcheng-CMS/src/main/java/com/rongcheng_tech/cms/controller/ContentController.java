package com.rongcheng_tech.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng_tech.cms.dao.BlockContentLinkDAO;
import com.rongcheng_tech.cms.dao.DerivedContentPageDAO;
import com.rongcheng_tech.cms.dao.MediaInfoDAO;
import com.rongcheng_tech.cms.dao.UserConfigSettingsDAO;
import com.rongcheng_tech.cms.entity.BlockContentLink;
import com.rongcheng_tech.cms.entity.DerivedContentPage;
import com.rongcheng_tech.cms.entity.MediaInfo;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.DerivedContentPage.DerivedContentPageService;
import com.rongcheng_tech.cms.service.MediaInfo.MediaInfoService;
import com.rongcheng_tech.cms.utils.JimlUtils;

@Controller
@RequestMapping("/admin/content")
public class ContentController {
	//分页相关（每页多少条）
	@Value("#{sysconfig['rows']}")
	private int rows;
	//ownerId
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private UserConfigSettingsDAO configDAO;
	@Resource
	private DerivedContentPageDAO derivedContentPageDAO;
	@Resource
	private DerivedContentPageService derivedContentPageService;
	@Resource
	private MediaInfoDAO mediaInfoDAO;
	@Resource
	private MediaInfoService mediaInfoService;
	@Resource
	private BlockContentLinkDAO blockContentLinkDAO;
	//正规表达
	private final Pattern GREEDY_URL_MATCH_PATTERN = Pattern.compile("(/temp/){1}([^\\x00-\\x20()\"<>\\x7F-\\xFF])*(\")", Pattern.CASE_INSENSITIVE);
	private final Pattern GREEDY_URL_MATCH_PATTERN2 = Pattern.compile("(/mediafiles/images/pages/editor/){1}([^\\x00-\\x20()\"<>\\x7F-\\xFF])*(\")", Pattern.CASE_INSENSITIVE);
		

	//到内容管理页
	@RequestMapping("/content.do")
	public String content(HttpServletRequest request, HttpSession session) {
		return "admin/content/content";
	}
	//到内容添加页
	@RequestMapping("/addcontent.do")
	public String addContent(HttpServletRequest request, HttpSession session) {
		return "admin/content/content-add";
	}
	//到媒体管理页
	@RequestMapping("/media.do")
	public String media(HttpServletRequest request, HttpSession session) {
		return "admin/content/media";
	}
	//到媒体添加页
	@RequestMapping("/addmedia.do")
	public String addMedia(HttpServletRequest request, HttpSession session) {
		return "admin/content/media-add";
	}
	
	//根据页码查询内容
	@RequestMapping("/loadcontent.do")
	@ResponseBody
	public Object loadContent(HttpServletRequest request, HttpSession session) {

		int page = new Integer(request.getParameter("page"));
		String blockChannelId = request.getParameter("blockChannelId");
		String keyword = request.getParameter("keyword");

		Object[] derivedContentPage = derivedContentPageService.pageByOwnerIdAndKeyword(ownerId, "desc", page, rows,blockChannelId,keyword);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 0);
		map.put("contentMaxPage", derivedContentPage[0]);
		map.put("content", derivedContentPage[1]);
		if(request.getAttribute("message")!=null){
			map.put("message", request.getAttribute("message"));
		}
		return map;
	}
	//根据页码查询媒体
	@RequestMapping("/loadmedia.do")
	@ResponseBody
	public Object loadMedia(HttpServletRequest request, HttpSession session) {

		int page = new Integer(request.getParameter("page"));
		String blockChannelId = request.getParameter("blockChannelId");
		String keyword = request.getParameter("keyword");

		Map<String, Object> map = new HashMap<String, Object>();
		Object[] mediaInfoArray = mediaInfoService.pageByOwnerIdAndKeyword(ownerId, page, rows,blockChannelId,keyword);
		map.put("state", 0);
		map.put("mediaInfoMaxPage", mediaInfoArray[0]);
		map.put("mediaInfo", mediaInfoArray[1]);
		if(request.getAttribute("message")!=null){
			map.put("message", request.getAttribute("message"));
		}
		return map;
	}
	//删除内容
	@RequestMapping("/deletecontent.do")
	@ResponseBody
	public void deleteContent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

		String[] id = request.getParameterValues("id");
		DerivedContentPage dcp = new DerivedContentPage();
		dcp.setOwnerId(ownerId);
		for (int i = 0; i < id.length; i++) {
			dcp.setId(new Long(id[i]));
			dcp = derivedContentPageDAO.getSelective(dcp);
			////删除缩略图///
			String iconUrl = dcp.getIconUrl();
			String projectPath = JimlUtils.getProjectPath(request);
			JimlUtils.delete(projectPath+iconUrl);
			////删除主内容图片start/////////////////
			String content1 = dcp.getContent1();
			if(content1 != null){
				List<String> content1ImgUrlList = JimlUtils.findURL(GREEDY_URL_MATCH_PATTERN2, content1);
				for (String imgUrl : content1ImgUrlList) {
					System.out.println(projectPath+imgUrl);
					JimlUtils.delete(projectPath+imgUrl);
				}
			}
			////删除主内容图片end/////////////////
		}
		int n = derivedContentPageDAO.deleteByOwnerIdAndIdArray(ownerId, id);
		request.setAttribute("message", n);
		request.getRequestDispatcher("/admin/content/loadcontent.do").forward(request, response);
	}
	//删除媒体
	@RequestMapping("/deletemedia.do")
	@ResponseBody
	public void deleteMedia(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		String[] id = request.getParameterValues("id");
		MediaInfo mi = new MediaInfo();
		mi.setOwnerId(ownerId);
		String projectPath = JimlUtils.getProjectPath(request);
		for (int i = 0; i < id.length; i++) {
			mi.setId(new Long(id[i]));
			String iconUrl = mediaInfoDAO.getSelective(mi).getIconUrl();
			JimlUtils.delete(projectPath+iconUrl);
			String mediaUrl = mediaInfoDAO.getSelective(mi).getMediaUrl();
			JimlUtils.delete(projectPath+mediaUrl);
		}
		int n = mediaInfoDAO.deleteByOwnerIdAndIdArray(ownerId, id);
		request.setAttribute("message", n);
		request.getRequestDispatcher("/admin/content/loadmedia.do").forward(request, response);
	}
	//到修改内容页
	@RequestMapping("/modifycontent.do")
	public String modifyContent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String id = request.getParameter("id");
		DerivedContentPage dcp = new DerivedContentPage();
		dcp.setOwnerId(ownerId);
		dcp.setId(new Long(id));
		dcp = derivedContentPageDAO.getSelective(dcp);
		request.setAttribute("dcp", dcp);
		return "admin/content/content-modify";
	}
	//到修改媒体页
	@RequestMapping("/modifymedia.do")
	public String modifyMedia(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String id = request.getParameter("id");
		MediaInfo mi = new MediaInfo();
		mi.setOwnerId(ownerId);
		mi.setId(new Long(id));
		mi = mediaInfoDAO.getSelective(mi);
		request.setAttribute("mi", mi);
		return "admin/content/media-modify";
	}
	//添加内容
	@RequestMapping("/addcontent/add.do")
	@ResponseBody
	public Object addContentDo(HttpServletRequest request, HttpSession session) {
		DerivedContentPage dcp = new DerivedContentPage();
		dcp.setOwnerId(ownerId);
		dcp.setGmtCreate(new Date());
		dcp.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		String contentTitle = request.getParameter("contentTitle");
		String contentSubtitle = request.getParameter("contentSubtitle");
		String contentEnTitle = request.getParameter("contentEnTitle");
		String interfaceName = request.getParameter("interfaceName");
		String author = request.getParameter("author");
		String iconDirectLink = request.getParameter("iconDirectLink");
		String contentProfile = request.getParameter("contentProfile");
		String content1 = request.getParameter("content1");
		String contentLabel = request.getParameter("contentLabel");
		String contentKeyword = request.getParameter("contentKeyword");
		String userSequence = request.getParameter("userSequence");
		String show = request.getParameter("show");
		String note = request.getParameter("note");
		
		if(contentTitle != null && !contentTitle.equals("")){
			dcp.setContentTitle(contentTitle);
		}
		if(contentSubtitle != null && !contentSubtitle.equals("")){
			dcp.setContentSubtitle(contentSubtitle);
		}
		if(contentEnTitle != null && !contentEnTitle.equals("")){
			dcp.setContentEnTitle(contentEnTitle);
		}
		if(interfaceName != null && !interfaceName.equals("")){
			dcp.setInterfaceName(interfaceName);
		}
		if(author != null && !author.equals("")){
			dcp.setAuthor(author);
		}
		if(iconDirectLink != null && !iconDirectLink.equals("")){
			dcp.setIconDirectLink(iconDirectLink);
		}
		if(contentProfile != null && !contentProfile.equals("")){
			dcp.setContentProfile(contentProfile);
		}
		if(content1 != null && !content1.equals("")){
		///////处理content主内容内包含的图片///////////////////////////////////
			String projectPath = JimlUtils.getProjectPath(request);
					List<String> content1UrlList = JimlUtils.findURL(GREEDY_URL_MATCH_PATTERN, content1);
					for (String string : content1UrlList) {
						try {
							JimlUtils.copyFile(projectPath+string, projectPath+updateURL(string));
						} catch (IOException e) {
							e.printStackTrace();
							return -1;
						}
					}
					content1 = updateURL(content1);
			////////////////////////////
			dcp.setContent1(content1);
		}
		if(contentLabel != null && !contentLabel.equals("")){
			dcp.setContentLabel(contentLabel);
		}
		if(contentKeyword != null && !contentKeyword.equals("")){
			dcp.setContentKeyword(contentKeyword);
		}
		if(userSequence != null && !userSequence.equals("")){
			dcp.setUserSequence(new Integer(userSequence));
		}
		if(show != null && !show.equals("")){
			if(show.equals("1")){
				dcp.setShow(true);
			}else{
				dcp.setShow(false);
			}
		}
		if(note != null && !note.equals("")){
			dcp.setNote(note);
		}
		String imgPath = File.separator+"mediafiles"+File.separator+"images"+File.separator+"pages"+File.separator;
		Map<String, String> map = JimlUtils.fileSaveSrc2(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		if(map != null && map.get("iconUrl")!=null){
			imgPath = imgPath + map.get("iconUrl");
			dcp.setIconUrl(imgPath);
		}
		
		int n = derivedContentPageDAO.insertSelective(dcp);
		
		return n;
	}
	//修改内容
	@RequestMapping("/modifycontent/modify.do")
	@ResponseBody
	public Object modifyContentDo(HttpServletRequest request, HttpSession session) throws IOException {
		DerivedContentPage dcp = new DerivedContentPage();
		dcp.setOwnerId(ownerId);
		dcp.setGmtModified(new Date());
		dcp.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		Long id = new Long(request.getParameter("id"));
		dcp.setId(id);
		String contentTitle = request.getParameter("contentTitle");
		String contentSubtitle = request.getParameter("contentSubtitle");
		String contentEnTitle = request.getParameter("contentEnTitle");
		String interfaceName = request.getParameter("interfaceName");
		String author = request.getParameter("author");
		String iconDirectLink = request.getParameter("iconDirectLink");
		String contentProfile = request.getParameter("contentProfile");
		String content1 = request.getParameter("content1");
		String contentLabel = request.getParameter("contentLabel");
		String contentKeyword = request.getParameter("contentKeyword");
		String userSequence = request.getParameter("userSequence");
		String show = request.getParameter("show");
		String note = request.getParameter("note");
		
		if(contentTitle != null && !contentTitle.equals("")){
			dcp.setContentTitle(contentTitle);
		}
		if(contentSubtitle != null && !contentSubtitle.equals("")){
			dcp.setContentSubtitle(contentSubtitle);
		}
		if(contentEnTitle != null && !contentEnTitle.equals("")){
			dcp.setContentEnTitle(contentEnTitle);
		}
		if(interfaceName != null && !interfaceName.equals("")){
			dcp.setInterfaceName(interfaceName);
		}
		if(author != null && !author.equals("")){
			dcp.setAuthor(author);
		}
		if(iconDirectLink != null && !iconDirectLink.equals("")){
			dcp.setIconDirectLink(iconDirectLink);
		}
		if(contentProfile != null && !contentProfile.equals("")){
			dcp.setContentProfile(contentProfile);
		}
		if(content1 != null && !content1.equals("")){
			///////处理content主内容内包含的图片///////////////////////////////////
			DerivedContentPage dcpTemp = new DerivedContentPage();
			dcpTemp.setId(id);
			dcpTemp.setOwnerId(ownerId);
			dcpTemp = derivedContentPageDAO.getSelective(dcpTemp);
			String oldContent1 = dcpTemp.getContent1();
			String projectPath = JimlUtils.getProjectPath(request);
			
			List<String> content1UrlList = JimlUtils.findURL(GREEDY_URL_MATCH_PATTERN, content1);
			if(oldContent1 != null){
				List<String> oldContent1UrlList = JimlUtils.findURL(GREEDY_URL_MATCH_PATTERN2, oldContent1);
				content1 = updateURL(content1);
				List<String> content1UrlUpList = JimlUtils.findURL(GREEDY_URL_MATCH_PATTERN2, content1);
				for (String oldContent1Url : oldContent1UrlList) {
					if(!content1UrlUpList.contains(oldContent1Url)){
						JimlUtils.delete(projectPath+oldContent1Url);
					}
				}
			}
			for (String string : content1UrlList) {
				JimlUtils.copyFile(projectPath+string, projectPath+updateURL(string));
			}
			//////////////////////////////////////////
			dcp.setContent1(content1);
		}
		if(contentLabel != null && !contentLabel.equals("")){
			dcp.setContentLabel(contentLabel);
		}
		if(contentKeyword != null && !contentKeyword.equals("")){
			dcp.setContentKeyword(contentKeyword);
		}
		if(userSequence != null && !userSequence.equals("")){
			dcp.setUserSequence(new Integer(userSequence));
		}
		if(show != null && !show.equals("")){
			if(show.equals("1")){
				dcp.setShow(true);
			}else{
				dcp.setShow(false);
			}
		}
		if(note != null && !note.equals("")){
			dcp.setNote(note);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String imgPath = File.separator+"mediafiles"+File.separator+"images"+File.separator+"pages"+File.separator;
		Map<String, String> map = JimlUtils.fileSaveSrc2(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		if(map != null && map.get("iconUrl")!=null){
			String iconUrlTemp = request.getParameter("iconUrlTemp");
			JimlUtils.delete(JimlUtils.getProjectPath(request)+iconUrlTemp);
			String iconUrl = imgPath + map.get("iconUrl");
			dcp.setIconUrl(iconUrl);
			resultMap.put("iconUrlTemp", iconUrl);
		}
		int n = derivedContentPageDAO.updateSelective(dcp);
		resultMap.put("modify", n);
		return resultMap;
	}
	//添加媒体
	@RequestMapping("/addmedia/add.do")
	@ResponseBody
	public Object addMediaDo(HttpServletRequest request, HttpSession session) {
		MediaInfo mi = new MediaInfo();
		mi.setOwnerId(ownerId);
		mi.setGmtCreate(new Date());
		mi.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		String mediaType = request.getParameter("mediaType");
		String mediaName = request.getParameter("mediaName");
		String interfaceName = request.getParameter("interfaceName");
		String mediaDirectLink = request.getParameter("mediaDirectLink");
		String wordDesign = request.getParameter("wordDesign");
		String iconDirectLink = request.getParameter("iconDirectLink");
		String mediaLabel = request.getParameter("mediaLabel");
		String mediaKeyword = request.getParameter("mediaKeyword");
		String userSequence = request.getParameter("userSequence");
		String show = request.getParameter("show");
		String note = request.getParameter("note");
		
		if(mediaType != null && !mediaType.equals("")){
			mi.setMediaType(new Byte(mediaType));
		}
		if(mediaName != null && !mediaName.equals("")){
			mi.setMediaName(mediaName);
		}
		if(interfaceName != null && !interfaceName.equals("")){
			mi.setInterfaceName(interfaceName);
		}
		if(mediaDirectLink != null && !mediaDirectLink.equals("")){
			mi.setMediaDirectLink(mediaDirectLink);
		}
		if(wordDesign != null && !wordDesign.equals("")){
			mi.setWordDesign(wordDesign);
		}
		if(iconDirectLink != null && !iconDirectLink.equals("")){
			mi.setIconDirectLink(iconDirectLink);
		}
		if(mediaLabel != null && !mediaLabel.equals("")){
			mi.setMediaLabel(mediaLabel);
		}
		if(mediaKeyword != null && !mediaKeyword.equals("")){
			mi.setMediaKeyword(mediaKeyword);
		}
		if(userSequence != null && !userSequence.equals("")){
			mi.setUserSequence(new Integer(userSequence));
		}
		if(show != null && !show.equals("")){
			if(show.equals("1")){
				mi.setShow(true);
			}else{
				mi.setShow(false);
			}
		}
		if(note != null && !note.equals("")){
			mi.setNote(note);
		}
		String imgPath = File.separator+"mediafiles"+File.separator+"images"+File.separator+"pages"+File.separator;
		Map<String, String> map = JimlUtils.fileSaveSrc2(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		if(map != null && map.get("mediaUrl")!=null){
			imgPath = imgPath + map.get("mediaUrl");
			mi.setMediaUrl(imgPath);
		}
		if(map != null && map.get("iconUrl")!=null){
			imgPath = imgPath + map.get("iconUrl");
			mi.setIconUrl(imgPath);
		}
		int n = mediaInfoDAO.insertSelective(mi);
		
		return n;
	}
	//修改媒体
	@RequestMapping("/modifymedia/modify.do")
	@ResponseBody
	public Object modifyMediaDo(HttpServletRequest request, HttpSession session) {
		MediaInfo mi = new MediaInfo();
		mi.setOwnerId(ownerId);
		mi.setGmtModified(new Date());
		mi.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		String id = request.getParameter("id");
		mi.setId(new Long(id));
		String mediaType = request.getParameter("mediaType");
		String mediaName = request.getParameter("mediaName");
		String interfaceName = request.getParameter("interfaceName");
		String mediaDirectLink = request.getParameter("mediaDirectLink");
		String wordDesign = request.getParameter("wordDesign");
		String iconDirectLink = request.getParameter("iconDirectLink");
		String mediaLabel = request.getParameter("mediaLabel");
		String mediaKeyword = request.getParameter("mediaKeyword");
		String userSequence = request.getParameter("userSequence");
		String show = request.getParameter("show");
		String note = request.getParameter("note");
		
		if(mediaType != null && !mediaType.equals("")){
			mi.setMediaType(new Byte(mediaType));
		}
		if(mediaName != null && !mediaName.equals("")){
			mi.setMediaName(mediaName);
		}
		if(interfaceName != null && !interfaceName.equals("")){
			mi.setInterfaceName(interfaceName);
		}
		if(mediaDirectLink != null && !mediaDirectLink.equals("")){
			mi.setMediaDirectLink(mediaDirectLink);
		}
		if(wordDesign != null && !wordDesign.equals("")){
			mi.setWordDesign(wordDesign);
		}
		if(iconDirectLink != null && !iconDirectLink.equals("")){
			mi.setIconDirectLink(iconDirectLink);
		}
		if(mediaLabel != null && !mediaLabel.equals("")){
			mi.setMediaLabel(mediaLabel);
		}
		if(mediaKeyword != null && !mediaKeyword.equals("")){
			mi.setMediaKeyword(mediaKeyword);
		}
		if(userSequence != null && !userSequence.equals("")){
			mi.setUserSequence(new Integer(userSequence));
		}
		if(show != null && !show.equals("")){
			if(show.equals("1")){
				mi.setShow(true);
			}else{
				mi.setShow(false);
			}
		}
		if(note != null && !note.equals("")){
			mi.setNote(note);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String imgPath = File.separator+"mediafiles"+File.separator+"images"+File.separator+"pages"+File.separator;
		Map<String, String> map = JimlUtils.fileSaveSrc2(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		if(map != null && map.get("mediaUrl")!=null){
			String mediaUrlTemp = request.getParameter("mediaUrlTemp");
			JimlUtils.delete(JimlUtils.getProjectPath(request)+mediaUrlTemp);
			String mediaUrl = imgPath + map.get("mediaUrl");
			mi.setMediaUrl(mediaUrl);
			resultMap.put("mediaUrlTemp", mediaUrl);
		}
		if(map != null && map.get("iconUrl")!=null){
			String iconUrlTemp = request.getParameter("iconUrlTemp");
			JimlUtils.delete(JimlUtils.getProjectPath(request)+iconUrlTemp);
			String iconUrl = imgPath + map.get("iconUrl");
			mi.setIconUrl(iconUrl);
			resultMap.put("iconUrlTemp", iconUrl);
		}
		int n = mediaInfoDAO.updateSelective(mi);
		
		resultMap.put("modify", n);
		return resultMap;
	}
	//归类
	@RequestMapping("/contentguilei.do")
	@ResponseBody
	public Object contentGuiLei(HttpServletRequest request, HttpSession session) {
		String[] id = request.getParameterValues("id");
		String[] blockChannelId = request.getParameterValues("blockChannelId");
		if(id == null || blockChannelId == null){return 0;}
		System.out.println(id.length);
		System.out.println(blockChannelId.length);
		List<BlockContentLink> list = new ArrayList<BlockContentLink>();
		for (int i = 0; i < blockChannelId.length; i++) {
			for (int j = 0; j < id.length; j++) {
				BlockContentLink bcl = new BlockContentLink();
				bcl.setBlockId(blockChannelId[i]);
				bcl.setContentType(new Byte("123"));
				bcl.setContentId(id[j]);
				bcl.setOwnerId(ownerId);
				bcl.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
				bcl.setGmtCreate(new Date());
				list.add(bcl);
			}
		}
		int n = 0;
		try{
			n = blockContentLinkDAO.insertSelective(list);
		}catch (org.springframework.dao.DuplicateKeyException e) {
			return -1;
		}
		return n;
	}
	
	// URL替换
	public static String updateURL(String str) {
		return str = str.replaceAll("temp", "mediafiles/images/pages/editor/image");
	}
}
