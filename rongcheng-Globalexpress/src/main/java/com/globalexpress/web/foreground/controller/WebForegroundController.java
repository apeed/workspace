package com.globalexpress.web.foreground.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globalexpress.web.entity.BlockChannel;
import com.globalexpress.web.entity.BlockContentLink;
import com.globalexpress.web.entity.CargoTracking;
import com.globalexpress.web.entity.DerivedContentPage;
import com.globalexpress.web.entity.MediaInfo;
import com.globalexpress.web.entity.StatementNotice;
import com.globalexpress.web.foreground.dao.ForegroundBlockChannelDao;
import com.globalexpress.web.foreground.dao.ForegroundBlockContentLinkDao;
import com.globalexpress.web.foreground.dao.ForegroundCargoTrackingDao;
import com.globalexpress.web.foreground.dao.ForegroundDerivedContentPageDao;
import com.globalexpress.web.foreground.dao.ForegroundMediaInfoDao;
import com.globalexpress.web.foreground.dao.ForegroundStatementNoticeDao;
import com.globalexpress.web.foreground.service.blockContentLink.ForegroundBlockContentLinkService;
import com.globalexpress.web.foreground.service.derivedContentPage.ForegroundDerivedContentPageService;
import com.globalexpress.web.foreground.service.mediaInfo.ForegroundMediaInfoService;
import com.globalexpress.web.util.KdniaoTrackQueryAPI;

import net.sf.json.JSONArray;

/**
 * 
 * @author jiml
 *
 */
@Controller
public class WebForegroundController {
	// 分页相关（每页多少条）
	@Value("#{config['rows']}")
	private int rows;
	// 首页每个栏目下显示内容条数
	@Value("#{config['indexRows']}")
	private int indexRows;
	// 版本号
	@Value("#{config['version']}")
	private String version;
	// 主账号id
	@Value("#{config['ownerId']}")
	private Long ownerId;

	@Resource
	private ForegroundStatementNoticeDao foregroundStatementNoticeDao;
	@Resource
	private ForegroundDerivedContentPageDao contentPageDao;
	@Resource
	private ForegroundMediaInfoDao mediaDao;
	@Resource
	private ForegroundBlockChannelDao blockChannelDao;
	@Resource
	private ForegroundBlockContentLinkDao blockContentLinkDao;
	@Resource
	private ForegroundCargoTrackingDao foregroundCargoTrackingDao;
	@Resource
	private ForegroundBlockContentLinkService fBlockContentLinkService;
	@Resource
	private ForegroundDerivedContentPageService fDerivedContentPageService;
	@Resource
	private ForegroundMediaInfoService fMediaInfoService;
	
	// 到首页
	@SuppressWarnings("unchecked")
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request) throws ClassNotFoundException {
		// 栏目及其内容查询 start /////////////////////////////////////////////////////////////
		// 查询类型为1的所有栏目及其对应的前indexRows条类型为1,23的内容（页面内容和媒体内容）（都为有序集合，方便JSP页面直接按对应顺序调用）
		
		// 指定栏目类型
		int recordType = 1;
		// 指定内容类型
		Byte[] contentType = {1,23};
		
		// 查栏目集合
		ArrayList<BlockChannel> type1BlockChannelList = (ArrayList<BlockChannel>) listBlockChannel(recordType);
		
		// 内容集合容器
		ArrayList<ArrayList<Object>> type1BlockChannelAllContentlList = new ArrayList<ArrayList<Object>>();
		// 按栏目顺序对应添加相应的内容
		BlockContentLink bcl = new BlockContentLink();
		bcl.setOwnerId(ownerId);
		for (BlockChannel blockChannel : type1BlockChannelList) {
			bcl.setBlockId(blockChannel.getId());
			// 根据栏目id 查关联表 从第0条开始查indexRows条关联信息
			List<BlockContentLink> blockContentLinkList = blockContentLinkDao.limitSelective(bcl, contentType, 0, indexRows);
			// 根据关联信息查 内容
			HashMap<String, Object> map = new HashMap<String, Object>();
			map = mapAllContentByBlockContentLink(blockContentLinkList, map);
			if(map != null){
				type1BlockChannelAllContentlList.add((ArrayList<Object>) map.get("allContentList"));
			}else{
				type1BlockChannelAllContentlList.add(null);
			}
		}
		request.setAttribute("type1BlockChannelList",JSONArray.fromObject(type1BlockChannelList));
		request.setAttribute("type1BlockChannelContentlList",type1BlockChannelAllContentlList);
		// 栏目及其内容查询 end /////////////////////////////////////////////////////////////
		
		// 轮播 start /////////////////////////////////////////////////////////////
		// 指定栏目类型
		recordType = 2;
		// 指定内容类型
		contentType = new Byte[]{23};
		// 查栏目集合
		ArrayList<BlockChannel> type2BlockChannelList = (ArrayList<BlockChannel>) listBlockChannel(recordType);
		// 内容集合容器
		ArrayList<ArrayList<Object>> type2BlockChannelAllContentlList = new ArrayList<ArrayList<Object>>();
		// 按栏目顺序对应添加相应的内容
		for (BlockChannel blockChannel : type2BlockChannelList) {
			bcl.setBlockId(blockChannel.getId());
			// 根据栏目id 查关联表 从第0条开始查indexRows条关联信息
			List<BlockContentLink> blockContentLinkList = blockContentLinkDao.limitSelective(bcl, contentType, 0, indexRows);
			// 根据关联信息查 内容
			HashMap<String, Object> map = new HashMap<String, Object>();
			map = mapAllContentByBlockContentLink(blockContentLinkList, map);
			if(map != null){
				type2BlockChannelAllContentlList.add((ArrayList<Object>) map.get("allContentList"));
			}
		}
		request.setAttribute("type2BlockChannelList",JSONArray.fromObject(type2BlockChannelList));
		request.setAttribute("type2BlockChannelContentlList",type2BlockChannelAllContentlList);
		// 轮播 end /////////////////////////////////////////////////////////////
		return "foreground/index";
	}
	
	// (导航栏目等触发点击，第一步)查指定栏目下有无内容
	@SuppressWarnings("unchecked")
	@RequestMapping("/isHaveContent.do")
	@ResponseBody
	public Object haveContent(HttpServletRequest request) {
		Long blockChannelId = new Long(request.getParameter("id"));
		HashMap<String, Object> map = mapBlockAndContentList(blockChannelId,1);
		if(map == null){
			return 0;
		}else{
			return ((List<Object>)map.get("allContentList")).size();
		}
	}
	
	// (导航栏目等触发点击，第二步)各栏目点击跳转页 及 分页查询
	@SuppressWarnings("unchecked")
	@RequestMapping("/page.do")
	public String about(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long blockChannelId = new Long(request.getParameter("id"));
		String blockChannelTitle = request.getParameter("blockTitle");
		
		if(blockChannelTitle.contains("运单") 
				|| blockChannelTitle.contains("運單") 
				|| blockChannelTitle.contains("物流") ){
			//转发
			request.getRequestDispatcher("/express.do").forward(request, response);
			return null;
		}
		
		//内容
		HashMap<String, Object> map = mapBlockAndContentList(blockChannelId,1);
		if(map == null){
			//转发
			request.getRequestDispatcher("/index.do").forward(request, response);
			return null;
		}
		request.setAttribute("blockChannelId", blockChannelId);
		request.setAttribute("blockChannelTitle", blockChannelTitle);
		//只有一条内容
		if(((List<Object>)map.get("allContentList")).size()==1){
			request.setAttribute("content", ((List<Object>)map.get("allContentList")).get(0));
			//公告
			StatementNotice sn = new StatementNotice();
			sn.setOwnerId(ownerId);
			sn.setReserved1("1");
			sn = foregroundStatementNoticeDao.getSelective(sn);
			request.setAttribute("statementNotice", sn);
			return "foreground/show";
		}
		//有多条内容
		//查类型为1的所有栏目并绑定数据
		request.setAttribute("type1BlockChannelList",jSONArrayBlockChannel(1));
		//将内容集合转换为json格式 并绑定，方便js使用
		request.setAttribute("map", JSONArray.fromObject(map));
		return "foreground/list";
	}

	// 分页查询
	@RequestMapping("/byPage.do")
	@ResponseBody
	public Object byPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long blockChannelId = new Long(request.getParameter("blockChannelId"));
		String str_page = request.getParameter("page");
		
		//内容
		int page = 1;
		try {
			page = new Integer(str_page);
		} catch (Exception e) {
			
		}
		HashMap<String, Object> map = mapBlockAndContentList(blockChannelId,page);
		if(map == null){
			return null;
		}
		return map.get("allContentList");
	}

	
	
	// 到运单跟踪页
	@RequestMapping("/express.do")
	public String express(HttpServletRequest request) {
		request.setAttribute("trackingNum", request.getParameter("trackingNum")); 
		return "foreground/inquire";
	}

	// 到内容详情页
	@RequestMapping("/show.do")
	public String show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//公告
		StatementNotice sn = new StatementNotice();
		sn.setOwnerId(ownerId);
		sn.setReserved1("1");
		sn = foregroundStatementNoticeDao.getSelective(sn);
		request.setAttribute("statementNotice", sn);
		
		Long contentId = new Long(request.getParameter("id"));
		String blockChannelTitle = request.getParameter("blockTitle");
		String contentType = request.getParameter("contentType");
		request.setAttribute("contentType", contentType);
		switch (new Integer(contentType)) {
		case 1:
			DerivedContentPage contentPage = new DerivedContentPage();
			contentPage.setOwnerId(ownerId);
			contentPage.setId(contentId);
			request.setAttribute("content", contentPageDao.getSelective(contentPage));
			request.setAttribute("blockChannelTitle", blockChannelTitle);
			return "foreground/show";
		case 23:
			MediaInfo mediaInfo = new MediaInfo();
			mediaInfo.setId(contentId);
			//contentPageDao.getSelective(mediaInfo);
			request.setAttribute("content", "");
			return "foreground/show";
		default:
			//转发
			request.getRequestDispatcher("/index.do").forward(request, response);
			return null;
		}
	}
	
	/**
	 * 查询运单详情
	 * 
	 * @param request
	 * @return 正常返回物流信息或者null，物流单号格式不正确返回-1
	 * @throws Exception 
	 */
	@RequestMapping("/express/inquire.do")
	@ResponseBody
	public Object inquire(HttpServletRequest request) throws Exception {
		String trackingNum = request.getParameter("trackingNum");
		//运单号不正确
		//return -1;
		CargoTracking cT = foregroundCargoTrackingDao.getByTrackingNum(trackingNum, ownerId);
		if(cT == null){
			return 0;
		}
		String json = KdniaoTrackQueryAPI.getOrderTracesByJson(cT.getTransferCarrierId(), cT.getTransferTrackingNum().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cargoTracking", cT);
		map.put("kdniaoTrack", JSONArray.fromObject("["+json+"]"));
		return map;
	}	
	
	/**
	 * 首页留言
	 * 
	 * @param request
	 * @return 留言成功返回0，失败返回其他值
	 * @throws Exception 
	 */
	@RequestMapping("/leavemessage.do")
	@ResponseBody
	public Object leaveMessage(HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String message = request.getParameter("message");
		return null;
	}	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////
	//根据栏目id 查栏目信息 及 该栏目下的内容(页面内容优于媒体内容显示，按时间和排序分页)
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> mapBlockAndContentList(Long blockId, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
//		这里根据栏目id查栏目信息（如果有，必然是一条信息）
//		BlockChannel bc = new BlockChannel();
//		bc.setOwnerId(ownerId);
//		bc.setId(blocklId);
//		List<BlockChannel> blockChannelList = blockChannelDao.listSelective(bc);
//		if(blockChannelList == null || blockChannelList.size()==0){
//			return null;
//		}
//		map.put("blockChannel", blockChannelList.get(0));
		
		//根据栏目id 查关联表
		BlockContentLink bcl = new BlockContentLink();
		bcl.setOwnerId(ownerId);
		bcl.setBlockId(blockId);
		List<BlockContentLink> blockContentLinkList = blockContentLinkDao.listSelective(bcl);
		//没有内容
		if(blockContentLinkList == null || blockContentLinkList.size()==0){
			return null;
		}
		//各内容条数
		int contentCount = 0;
		int mediaCount = 0;
		//各内容
		for (BlockContentLink blockContentLink : blockContentLinkList) {
			Byte type = blockContentLink.getContentType();
			if(type == 1){
				contentCount++;
			}else if(type == 23){
				mediaCount++;
			}
		}
		int contentMaxPage = (int) Math.ceil(new Double(contentCount) / rows);
		int maxPage = (int) Math.ceil(new Double(contentCount + mediaCount) / rows);
		int start = 0;
		if(page < contentMaxPage){
			start = page * rows - rows;
			map.put("allContentList", fDerivedContentPageService.pageByBlockIdAndKeyword(ownerId, start, rows, blockId, null));
		} else if(page == contentMaxPage){
			List<Object> allContentList = new ArrayList<Object>();
			start = page * rows - rows;
			allContentList.addAll(fDerivedContentPageService.pageByBlockIdAndKeyword(ownerId, start, rows, blockId, null));
			int rowsTemp = rows - (contentCount-start);
			start = 0;
			allContentList.addAll(fMediaInfoService.pageByBlockIdAndKeyword(ownerId, start, rowsTemp, blockId, null));
			map.put("allContentList", allContentList);
		} else if(page > contentMaxPage){
			start = page * rows - rows;
			map.put("allContentList", fMediaInfoService.pageByBlockIdAndKeyword(ownerId, start, rows, blockId, null));
		}
		map.put("maxPage", maxPage);
		return map;
	}
/*	//根据栏目id 查栏目信息 及 该栏目下的内容(按关联表的关联时间分页)
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> mapBlockAndContentListByLink(Long blockId, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
//		这里根据栏目id查栏目信息（如果有，必然是一条信息）
//		BlockChannel bc = new BlockChannel();
//		bc.setOwnerId(ownerId);
//		bc.setId(blocklId);
//		List<BlockChannel> blockChannelList = blockChannelDao.listSelective(bc);
//		if(blockChannelList == null || blockChannelList.size()==0){
//			return null;
//		}
//		map.put("blockChannel", blockChannelList.get(0));
		
		//根据栏目id 查关联表
		BlockContentLink bcl = new BlockContentLink();
		bcl.setOwnerId(ownerId);
		bcl.setBlockId(blockId);
		Object[] o = fBlockContentLinkService.pageSelective(bcl, new Byte[]{1,23}, page, rows);
		map.put("maxPage", o[0]);
		List<BlockContentLink> blockContentLinkList = (List<BlockContentLink>) o[1];
		//没有内容
		if(blockContentLinkList == null || blockContentLinkList.size()==0){
			return null;
		}
		return mapAllContentByBlockContentLink(blockContentLinkList, map);
	}*/
	
	/**
	 * 根据关联信息查各类型内容(内容按排序从小到大再按id从大到小)
	 * 
	 * @param blockContentLinkList 关联信息（ 至少包含 内容类型 和 内容id ）
	 * @return 查不到内容一律为null。
	 * 		keys：allContentList，derivedContentPageList，mediaInfoList
	 */
	private HashMap<String, Object> mapAllContentByBlockContentLink(List<BlockContentLink> blockContentLinkList, HashMap<String, Object> map) {
		//暂存各类型内容id的集合
		List<Long> derivedContentPageIdList = new ArrayList<Long>();
		List<Long> mediaInfoIdList = new ArrayList<Long>();
		//循环关联信息找出各类型内容id集合
		for (BlockContentLink blockContentLink : blockContentLinkList) {
			switch (blockContentLink.getContentType()) {
			case 1://关联表中页面内容的类型为1，将页面内容的id添加至此集合
				derivedContentPageIdList.add(blockContentLink.getContentId());
				break;
			case 23://关联表中媒体内容的类型为2和3，2：图片、3：视频，但插值时统一处理合并为了23
				mediaInfoIdList.add(blockContentLink.getContentId());
				break;
			default:
				break;
			}
		}
		//或即将返回的[多类型]内容集合(内容按排序从小到大再按id从大到小)
		List<Object> allContentList = new ArrayList<Object>();
		if(derivedContentPageIdList.size() > 0){
			//或即将返回的[页面类型]内容集合
			List<DerivedContentPage> dcpList = new ArrayList<DerivedContentPage>();
			dcpList = contentPageDao.listByIdList(ownerId, derivedContentPageIdList);
			map.put("derivedContentPageList", dcpList);
			allContentList.addAll(dcpList);
		}
		if(mediaInfoIdList.size() > 0){
			//或即将返回的[媒体类型]内容集合
			List<MediaInfo> mediaInfoList = new ArrayList<MediaInfo>();
			mediaInfoList = mediaDao.listByIdList(ownerId, mediaInfoIdList);
			map.put("mediaInfoList", mediaInfoList);
			allContentList.addAll(mediaInfoList);
		}
		if(allContentList.size() > 0){
			map.put("allContentList", allContentList);
		}
		if(map.size() > 0){
			return map;
		}
		return null;
	}
	
	
	//查所有该类型栏目(返回List集合)
	private List<BlockChannel> listBlockChannel(Integer recordType) {
		BlockChannel bc = new BlockChannel();
		bc.setOwnerId(ownerId);
		bc.setRecordType(recordType);
		ArrayList<BlockChannel> BlockChannelList = (ArrayList<BlockChannel>) blockChannelDao.listSelective(bc);
		return BlockChannelList;
	}
	
	//查所有该类型栏目(返回json格式数据)
	private JSONArray jSONArrayBlockChannel(Integer recordType) {
		JSONArray jo = JSONArray.fromObject(listBlockChannel(recordType));
		return jo;
	}

}
