package com.globalexpress.web.cms.controller;

import java.io.IOException;
import java.math.BigDecimal;
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

import com.globalexpress.web.cms.dao.BlockContentLinkDAO;
import com.globalexpress.web.cms.dao.ItemInfoDAO;
import com.globalexpress.web.entity.BlockContentLink;
import com.globalexpress.web.entity.ItemInfo;
import com.globalexpress.web.entity.UserInfo;
import com.globalexpress.web.util.JimlUtil;
import com.globalexpress.web.util.JsonResult;
import com.globalexpress.web.cms.service.ItemInfo.ItemInfoService;
/**
 * 
 * @author jiml
 *
 */
@Controller
@RequestMapping("/admin/item/")
public class ItemController {
	//分页相关（每页多少条）
	@Value("#{config['rows']}")
	private int rows;
	//ownerId
//	@Value("#{config['ownerId']}")
//	private Long ownerId;
	@Resource
	private ItemInfoDAO itemInfoDAO;
	@Resource
	private ItemInfoService itemService;
	@Resource
	private BlockContentLinkDAO blockContentLinkDAO;
	//正规表达
	private final Pattern GREEDY_URL_MATCH_PATTERN = Pattern.compile("(/temp/){1}([^\\x00-\\x20()\"<>\\x7F-\\xFF])*(\")", Pattern.CASE_INSENSITIVE);
	private final Pattern GREEDY_URL_MATCH_PATTERN2 = Pattern.compile("(/media/images/item/editor/){1}([^\\x00-\\x20()\"<>\\x7F-\\xFF])*(\")", Pattern.CASE_INSENSITIVE);
		

	//到商品管理页
	@RequestMapping("list.do")
	public String itemList(HttpServletRequest request, HttpSession session) {
		return "admin/shopping/item";
	}
	//到商品添加页
	@RequestMapping("additem.do")
	public String addItem(HttpServletRequest request, HttpSession session) {
		return "admin/shopping/item-add";
	}
	
	//到商品修改页
	@RequestMapping("modifyitem.do")
	public String modifyItem(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		String id = request.getParameter("id");
		ItemInfo item = new ItemInfo();
		item.setOwnerId(ownerId);
		item.setId(new Long(id));
		item = itemInfoDAO.getSelective(item);
		request.setAttribute("item", item);
		return "admin/shopping/item-modify";
	}
	//根据页码查询商品
	@RequestMapping("loaditem.do")
	@ResponseBody
	public Object loadItem(HttpServletRequest request, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		int page = new Integer(request.getParameter("page"));
		String blockChannelId = request.getParameter("blockChannelId");
		String keyword = request.getParameter("keyword");

		Map<String, Object> map = new HashMap<String, Object>();
		Object[] itemInfoArray = itemService.pageByOwnerIdAndKeyword(ownerId, page, rows,blockChannelId,keyword);
		map.put("state", 0);
		map.put("maxPage", itemInfoArray[0]);
		map.put("itemInfoList", itemInfoArray[1]);
		if(request.getAttribute("message")!=null){
			map.put("message", request.getAttribute("message"));
		}
		return map;
	}
	//删除内容
	@RequestMapping("upDelete.do")
	@ResponseBody
	public void deleteItem(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		String[] id = request.getParameterValues("id");
		ItemInfo item = new ItemInfo();
		item.setOwnerId(ownerId);
		for (int i = 0; i < id.length; i++) {
			item.setId(new Long(id[i]));
			item = itemInfoDAO.getSelective(item);
			////删除缩略图///
			String iconUrl = item.getIconUrl();
			String projectPath = JimlUtil.getProjectPath(request);
			JimlUtil.upDelete(projectPath+iconUrl);
			////删除主内容图片start/////////////////
			String itemDetail = item.getItemDetail();
			if(itemDetail != null){
				List<String> content1ImgUrlList = JimlUtil.findURL(GREEDY_URL_MATCH_PATTERN2, itemDetail);
				for (String imgUrl : content1ImgUrlList) {
					System.out.println(projectPath+imgUrl);
					JimlUtil.upDelete(projectPath+imgUrl);
				}
			}
			////删除主内容图片end/////////////////
		}
		int n = itemInfoDAO.deleteByOwnerIdAndIdArray(ownerId, id);
		request.setAttribute("message", n);
		request.getRequestDispatcher("/admin/item/loaditem.do").forward(request, response);
	}
	//添加商品
	@RequestMapping("additem/add.do")
	@ResponseBody
	public Object addItemDo(HttpServletRequest request, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		ItemInfo item = new ItemInfo();
		item.setOwnerId(ownerId);
		item.setGmtCreate(new Date());
		item.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		String itemSku = request.getParameter("itemSku");
		String itemName = request.getParameter("itemName");
		String itemShortName = request.getParameter("itemShortName");
		String interfaceName = request.getParameter("interfaceName");
		String itemBrand = request.getParameter("itemBrand");
		String itemSeries = request.getParameter("itemSeries");
		String itemColor = request.getParameter("itemColor");
		String itemSize = request.getParameter("itemSize");
		String barCode = request.getParameter("barCode");
		String itemProfile = request.getParameter("itemProfile");
		String itemType = request.getParameter("itemType");
		String costPrice = request.getParameter("costPrice");
		String normalPrice = request.getParameter("normalPrice");
		String itemLocation = request.getParameter("itemLocation");
		String stockQuantity = request.getParameter("stockQuantity");
		String labelId = request.getParameter("labelId");
		String itemKeyword = request.getParameter("itemKeyword");
		String userSequence = request.getParameter("userSequence");
		String note = request.getParameter("note");
		String itemDetail = request.getParameter("itemDetail");
		String show = request.getParameter("show");
		if(itemSku != null && !itemSku.equals("")){
			item.setItemSku(new Long(itemSku));
		}
		if(itemName != null && !itemName.equals("")){
			item.setItemName(itemName);
		}
		if(itemShortName != null && !itemShortName.equals("")){
			item.setItemShortName(itemShortName);
		}
		if(interfaceName != null && !interfaceName.equals("")){
			item.setInterfaceName(interfaceName);
		}
		if(itemBrand != null && !itemBrand.equals("")){
			item.setItemBrand(itemBrand);
		}
		if(itemSeries != null && !itemSeries.equals("")){
			item.setItemSeries(itemSeries);
		}
		if(itemColor != null && !itemColor.equals("")){
			item.setItemColor(itemColor);
		}
		if(itemSize != null && !itemSize.equals("")){
			item.setItemSize(itemSize);
		}
		if(barCode != null && !barCode.equals("")){
			item.setBarCode(barCode);
		}
		if(itemProfile != null && !itemProfile.equals("")){
			item.setItemProfile(itemProfile);
		}
		if(itemType != null && !itemType.equals("")){
			item.setItemType(new Byte(itemType));
		}
		if(costPrice != null && !costPrice.equals("")){
			item.setCostPrice(new BigDecimal(costPrice));
		}
		if(normalPrice != null && !normalPrice.equals("")){
			item.setNormalPrice(new BigDecimal(normalPrice));
		}
		if(itemLocation != null && !itemLocation.equals("")){
			item.setItemLocation(itemLocation);
		}
		if(stockQuantity != null && !stockQuantity.equals("")){
			item.setStockQuantity(new Integer(stockQuantity));
		}
		if(labelId != null && !labelId.equals("")){
			item.setLabelId(labelId);
		}
		if(itemKeyword != null && !itemKeyword.equals("")){
			item.setItemKeyword(itemKeyword);
		}
		if(userSequence != null && !userSequence.equals("")){
			item.setUserSequence(new Integer(userSequence));
		}
		System.out.println("itemDetail"+itemDetail);
		if(itemDetail != null && !itemDetail.equals("")){
			itemDetail = updateURL(itemDetail);System.out.println(itemDetail);
		///////处理content主内容内包含的图片///////////////////////////////////
			String projectPath = JimlUtil.getProjectPath(request);
					List<String> content1UrlList = JimlUtil.findURL(GREEDY_URL_MATCH_PATTERN, itemDetail);
					for (String string : content1UrlList) {
						if(!JimlUtil.copyFile(projectPath+string, projectPath+updateURL(string))){
							return -1;
						}
					}
					itemDetail = updateURL(itemDetail);System.out.println(itemDetail);
			////////////////////////////
			item.setItemDetail(itemDetail);
		}
		if(show != null && !show.equals("")){
			if(show.equals("1")){
				item.setShow(true);
			}else{
				item.setShow(false);
			}
		}
		if(note != null && !note.equals("")){
			item.setNote(note);
		}
		String imgPath = "/media/images/item/";
		Map<String, String> map = null;
		try {
			map = JimlUtil.saveMultipartFileUseInputTagNameValue(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map != null && map.get("itemImage1")!=null){
			imgPath = imgPath + map.get("itemImage1");
			item.setItemImage1(imgPath);
		}
		
		int n = itemInfoDAO.insertSelective(item);
		
		return n;
	}
	//修改内容
	@RequestMapping("modifyitem/modify.do")
	@ResponseBody
	public Object modifyItemDo(HttpServletRequest request, HttpSession session) throws IOException {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		ItemInfo item = new ItemInfo();
		item.setOwnerId(ownerId);
		item.setGmtModified(new Date());
		item.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
		
		Long id = new Long(request.getParameter("id"));
		item.setId(id);
		String itemName = request.getParameter("itemName");
		item.setItemName(itemName);
		String itemShortName = request.getParameter("itemShortName");
		item.setItemShortName(itemShortName);
		String interfaceName = request.getParameter("interfaceName");
		item.setInterfaceName(interfaceName);
		String itemBrand = request.getParameter("itemBrand");
		item.setItemBrand(itemBrand);
		String itemSeries = request.getParameter("itemSeries");
		item.setItemSeries(itemSeries);
		String itemColor = request.getParameter("itemColor");
		item.setItemColor(itemColor);
		String itemSize = request.getParameter("itemSize");
		item.setItemSize(itemSize);
		String barCode = request.getParameter("barCode");
		item.setBarCode(barCode);
		String itemProfile = request.getParameter("itemProfile");
		item.setItemProfile(itemProfile);
		String itemType = request.getParameter("itemType");
		item.setItemType(itemType==null?null:new Byte(itemType));
		String costPrice = request.getParameter("costPrice");
		item.setCostPrice(costPrice==null?null:new BigDecimal(costPrice));
		String normalPrice = request.getParameter("normalPrice");
		item.setNormalPrice(normalPrice==null?null:new BigDecimal(normalPrice));
		String itemLocation = request.getParameter("itemLocation");
		item.setItemLocation(itemLocation);
		String stockQuantity = request.getParameter("stockQuantity");
		item.setStockQuantity(stockQuantity==null?null:new Integer(stockQuantity));
		String labelId = request.getParameter("labelId");
		item.setLabelId(labelId);
		String itemKeyword = request.getParameter("itemKeyword");
		item.setItemKeyword(itemKeyword);
		String userSequence = request.getParameter("userSequence");
		item.setUserSequence(userSequence==null?null:new Integer(userSequence));
		String note = request.getParameter("note");
		item.setNote(note);
		
		String itemDetail = request.getParameter("itemDetail");
		if(itemDetail != null){
			///////处理编辑器内包含的图片///////////////////////////////////
			ItemInfo itemTemp = new ItemInfo();
			itemTemp.setId(id);
			itemTemp.setOwnerId(ownerId);
			itemTemp = itemInfoDAO.getSelective(itemTemp);
			String oldDetail = itemTemp.getItemDetail();
			String projectPath = JimlUtil.getProjectPath(request);
			
			List<String> content1UrlList = JimlUtil.findURL(GREEDY_URL_MATCH_PATTERN, itemDetail);
			if(oldDetail != null){
				List<String> oldContent1UrlList = JimlUtil.findURL(GREEDY_URL_MATCH_PATTERN2, oldDetail);
				itemDetail = updateURL(itemDetail);
				List<String> content1UrlUpList = JimlUtil.findURL(GREEDY_URL_MATCH_PATTERN2, itemDetail);
				for (String oldContent1Url : oldContent1UrlList) {
					if(!content1UrlUpList.contains(oldContent1Url)){
						JimlUtil.upDelete(projectPath+oldContent1Url);
					}
				}
			}
			for (String string : content1UrlList) {
				JimlUtil.copyFile(projectPath+string, projectPath+updateURL(string));
			}
			//////////////////////////////////////////
			item.setItemDetail(itemDetail);
		}
		String show = request.getParameter("show");
		if(show != null){
			if(show.equals("1") || show.equals("true")){
				item.setShow(true);
			}else{
				item.setShow(false);
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String imgPath = "/media/images/item/";
		Map<String, String> map = JimlUtil.saveMultipartFileUseInputTagNameValue(request, imgPath, "-"+ownerId+"-"+new Date().getTime());
		if(map != null && map.get("itemImage1")!=null){
			String itemImage1Temp = request.getParameter("itemImage1Temp");
			JimlUtil.upDelete(JimlUtil.getProjectPath(request)+itemImage1Temp);
			String itemImage1 = imgPath + map.get("itemImage1");
			item.setItemImage1(itemImage1);
			resultMap.put("itemImage1Temp", itemImage1);
		}
		int n = itemInfoDAO.updateSelective(item);
		resultMap.put("modify", n);
		return resultMap;
	}
	//归类
	@RequestMapping("itemguilei.do")
	@ResponseBody
	public Object contentGuiLei(HttpServletRequest request, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		String[] id = request.getParameterValues("id");
		String[] blockChannelId = request.getParameterValues("blockChannelId");
		//内容类型，1：页面内容，23：媒体内容，4：商品内容
		String contentType = request.getParameter("contentType");
		//批量归类时的标志，1归类，2删除归类
		String piLiangGuiLeiType = request.getParameter("piLiangGuiLeiType");
		if(id == null){return 0;}
		List<BlockContentLink> list = new ArrayList<BlockContentLink>();
		if(blockChannelId != null){
			for (int i = 0; i < blockChannelId.length; i++) {
				for (int j = 0; j < id.length; j++) {
					BlockContentLink bcl = new BlockContentLink();
					bcl.setBlockId(new Long(blockChannelId[i]));
					bcl.setContentId(new Long(id[j]));
					bcl.setContentType(new Byte(contentType));
					bcl.setOwnerId(ownerId);
					bcl.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
					bcl.setGmtCreate(new Date());
					list.add(bcl);
				}
			}
		}
		int n = 0;
		//单独归类
		if(id.length == 1){
			try{
				blockContentLinkDAO.deleteByArrContentIdAndcontentType(id, new Byte(contentType), ownerId);
				if(blockChannelId != null){n = blockContentLinkDAO.insertListSelective(list);}
			}catch (org.springframework.dao.DuplicateKeyException e) {
				return -1;
			}
			return n;
		//批量归类
		}else if(id.length > 1){
			//归类
			if(piLiangGuiLeiType.equals("1")){
				if(blockChannelId != null){
					for (int i = 0; i < blockChannelId.length; i++) {
						for (int j = 0; j < id.length; j++) {
							BlockContentLink bcl = new BlockContentLink();
							bcl.setBlockId(new Long(blockChannelId[i]));
							bcl.setContentType(new Byte(contentType));
							bcl.setContentId(new Long(id[j]));
							bcl.setOwnerId(ownerId);
							bcl.setOperatorId(((UserInfo)(session.getAttribute("user"))).getId());
							bcl.setGmtCreate(new Date());
							try{
								n += blockContentLinkDAO.insertSelective(bcl);
							}catch(Exception e){
							}
						}
					}
				}
			//删除归类
			}else if(piLiangGuiLeiType.equals("2")){
				n = blockContentLinkDAO.deleteSelectiveByList(list);
			}
		}
		return n;
	}
	
	//获取商品编号
	@RequestMapping("getItemSku.do")
	@ResponseBody
	public JsonResult getItemSku(String keyword, HttpSession session){
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		List<ItemInfo> list=itemInfoDAO.getItemSku(keyword,ownerId);
		return new JsonResult(list);
	}
	
	// URL替换
	public static String updateURL(String str) {
		return str = str.replaceAll("temp", "media/images/item/editor");
	}
	
}
