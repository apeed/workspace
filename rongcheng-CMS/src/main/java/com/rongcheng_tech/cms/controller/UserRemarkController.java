package com.rongcheng_tech.cms.controller;
import java.sql.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.entity.UserRemark;
import com.rongcheng_tech.cms.service.UserRemark.UserRemarkService;
import com.rongcheng_tech.cms.utils.JsonResult;

@Controller
public class UserRemarkController {
	private int rows=20;
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private UserRemarkService service;

	@RequestMapping("/book.do")
	public String tobook(){
		return "book";
	}
	@RequestMapping("/bookMore.do")
	public String bookMore(){
		return "bookMore";
	}
	@RequestMapping("/review.do")
	public String toreview(){
		return "review";
	}
	@RequestMapping("/reviewAdd.do")
	public String reviewAdd(){
		return "reviewAdd";
	}
	@RequestMapping("/reviewReturn.do")
	public String reviewReturn(){
		return "reviewReturn";
	}
	//根据页码检索商品信息
	@RequestMapping("/loadList_book.do")
	@ResponseBody
	public JsonResult loadBook(HttpSession session,String page) {
		return loadBooks(session,page);
	}
	//根据页码检索商品信息
	@RequestMapping("/loadList_book1.do")
	@ResponseBody
	public JsonResult loadBook1(HttpSession session,String page) {
		return loadBooks1(session,page);
	}
	
	//根据页码检索
	public JsonResult loadBooks(HttpSession session,String page) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int max_page = (int) Math.ceil(new Double(service.findUserRemarkCount(ownerId))/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		List<UserRemark> UserRemark=service.findUserRemarkByPage(new Integer(page)*rows-rows,rows,ownerId);
		JsonResult jr = new JsonResult(UserRemark);
		jr.setMessage(max_page+"");
		return jr;
	}
	//根据页码检索
	public JsonResult loadBooks1(HttpSession session,String page) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int max_page = (int) Math.ceil(new Double(service.findUserRemarkCount(ownerId))/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		List<UserRemark> UserRemark=service.findUserRemarkByPage1(new Integer(page)*rows-rows,rows,ownerId);
		JsonResult jr = new JsonResult(UserRemark);
		jr.setMessage(max_page+"");
		return jr;
	}
	//删除单条
	@RequestMapping("/delUserRemark.do")
	@ResponseBody
	public JsonResult delUserRemark(HttpSession session,Long id) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.delUserRemark(id,ownerId);
		return new JsonResult();
	}
	//批量删除
	@RequestMapping("/delUserRemarkList.do")
	@ResponseBody
	public JsonResult delUserRemarkList(HttpSession session,Long[] id1) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
//		System.out.println(id1[0]);
		service.delUserRemarkList(id1, ownerId);
		return new JsonResult();
	}
	//通过id查询对象
	@RequestMapping("/findByUserRemarkId.do")
	@ResponseBody
	public JsonResult findByUserRemarkId(HttpSession session,Long id) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		UserRemark n=service.findByUserRemarkId(id,ownerId);
		return new JsonResult(n);
	}
	//修改内容
	@RequestMapping("/modifyUserRemark.do")
	@ResponseBody
	public JsonResult modifyUserRemark(Long id, String adminReply, String note, Boolean show, Integer userSequence,HttpSession session) {
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Date tamp = new Date(System.currentTimeMillis());
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.modifyUserRemark(id,ownerId, adminReply, note, show, userSequence,operatorId,tamp);
		return new JsonResult();
	}
	
	@RequestMapping("/findByItemInfoId.do")
	@ResponseBody
	public JsonResult findByItemInfoId(HttpSession session,Long id) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		ItemInfo n=service.findByItemInfoId(id, ownerId);
		return new JsonResult(n);
	}
	//添加评论
	@RequestMapping("/addUserRemark.do")
	@ResponseBody
	public JsonResult addUserRemark(HttpSession session, String userAccount,Long userId, String userWord,
	Integer userSequence, Integer remarkType, Boolean show, String note, Byte contentType,Long contentId){
		Date tamp = new Date(System.currentTimeMillis());
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int n=service.addUserRemark(ownerId, tamp, userAccount, userId, userWord, 
				tamp, userSequence, remarkType, show, note, contentType,contentId);
		return new JsonResult(n);	
	}
	//模糊查询 
	@RequestMapping("/findListByUserRemark.do")
	@ResponseBody
	public JsonResult findListByUserRemark(HttpSession session,String keyword) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		List<UserRemark> list=service.findListByUserRemark(keyword, ownerId);
		return new JsonResult(list);
	}
	//批量修改评论不显示
	@ResponseBody
	@RequestMapping("/modifyUserRemarks.do")//object
	public Object modifyUserRemarks(HttpSession session,Long[] id1,Boolean show){
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.modifyUserRemarks(id1, ownerId, false);
		return new JsonResult();	
	}
	//批量修改不予回复
		@ResponseBody
		@RequestMapping("/updateUserRemarks.do")//object
		public Object updateUserRemarks(HttpSession session,Long[] id1,Boolean reply){
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			service.updateUserRemarks(id1, ownerId, false);
			return new JsonResult();	
		}
	//回复 
	@ResponseBody
	@RequestMapping("/modifyUserRemark1.do")
	public JsonResult modifyUserRemark1(Long id, String adminReply,
			HttpSession session,Boolean reply){
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Date tamp = new Date(System.currentTimeMillis());
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.modifyUserRemark1(id,ownerId, adminReply, tamp, operatorId, tamp,reply);
		return new JsonResult();	
	}
	//历史记录查询客服账号
	@ResponseBody
	@RequestMapping("/findByUserRemarkAccount.do")
	public JsonResult findByUserRemarkAccount(HttpSession session,String accountNum,Long itemSku){
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		List<UserRemark> list= service.findByUserRemarkAccount(accountNum, ownerId,itemSku);
		return new JsonResult(list);	
	}
	//获取客服账号
	@ResponseBody
	@RequestMapping("/getByOperatorId.do")
	public JsonResult getByOperatorId(HttpSession session,Long id){
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		List<UserInfo>list=service.getByOperatorId(id, ownerId);
		return new JsonResult(list);	
	}
}
