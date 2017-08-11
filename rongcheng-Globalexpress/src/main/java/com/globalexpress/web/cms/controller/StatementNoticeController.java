package com.globalexpress.web.cms.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.globalexpress.web.entity.StatementNotice;
import com.globalexpress.web.entity.UserInfo;
import com.globalexpress.web.util.JsonResult;
import com.globalexpress.web.cms.service.StatementNotice.StatementNoticeService;
@Controller
@RequestMapping("/admin")
public class StatementNoticeController {
	private int rows=20;
//	@Value("#{config['ownerId']}")
//	private Long ownerId;
	
	@Resource
	private StatementNoticeService statementService;
	
	@RequestMapping("/notice.do")
	public String toNotice(){
		return "admin/notice/notice";
	}
	@RequestMapping("/noticePublic.do")
	public String noticePublic(){
		return "admin/notice/noticePublic";
	}
	@RequestMapping("/noticeAdd.do")
	public String noticeAdd(){
		return "admin/notice/noticeAdd";
	}
	//根据页码检索商品信息
	@RequestMapping("/loadList_notice.do")
	@ResponseBody
	public JsonResult loadStatementNotice(String page, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		return loadStatementNotices(page, ownerId);
	}
	
	//根据页码检索
	public JsonResult loadStatementNotices(String page, Long ownerId) {
		int max_page = (int) Math.ceil(new Double(statementService.findStatementNoticeCount(ownerId))/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		List<StatementNotice> StatementNotice=statementService.findStatementNoticeByPage(new Integer(page)*rows-rows,rows,ownerId);
		JsonResult jr = new JsonResult(StatementNotice);
		jr.setMessage(max_page+"");
		return jr;
	}
	//加载修改内容
	@RequestMapping("/load_modify_notice.do")
	@ResponseBody
	public JsonResult findByStatementNoticeId(Long id, HttpSession session){
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		StatementNotice sn=statementService.findByStatementNoticeId(id, ownerId);
		return new JsonResult(sn);
	}
	//修改内容
	@RequestMapping("/modify_statementNotice.do")
	@ResponseBody
	public JsonResult modifyStatementNotice(Long id,String statementTitle, String statement, String notice,String note, HttpSession  session){
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		int n=statementService.modifyStatementNotice(id,ownerId,statementTitle, statement, notice, note, operatorId, tamp);
		return new JsonResult(n);
	}
	//添加内容
	@RequestMapping("/add_statementNotice.do")
	@ResponseBody
	public JsonResult addStatementNotice(String statementTitle, String statement,
			String notice,String note, HttpSession session){
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		int n=statementService.addStatementNotice(ownerId, tamp, statementTitle, statement, notice, note,operatorId);
//	System.out.println(ownerId+","+gmtCreate+","+statementTitle+","+statement+","+notice);
	return new JsonResult(n);
	}
	//删除单条
	@RequestMapping("/delStatementNotice.do")
	@ResponseBody
	public JsonResult delStatementNotice(Long id, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		statementService.delStatementNotice(id, ownerId);
		return new JsonResult();
	}
	//模糊查询
	@RequestMapping("/findListByStatementNotice.do")
	@ResponseBody
	public JsonResult findListByStatementNotice(String keyword, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		List<StatementNotice> list=statementService.findListByStatementNotice(keyword, ownerId);
		return new JsonResult(list);
	}
	//批量删除
	@RequestMapping("/delStatementNoticeList.do")
	@ResponseBody
	public JsonResult delStatementNoticeList(Long[] id1, HttpSession session) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		statementService.delStatementNoticeList(id1, ownerId);
		return new JsonResult();
	}
	//启用
	@RequestMapping("/updateStatementNotice.do")
	@ResponseBody
	public JsonResult updateStatementNotice(Long id, HttpSession session,Boolean apply){
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		int n=statementService.updateStatementNotice(id, ownerId, operatorId, tamp, apply);
		return new JsonResult(n);
	}
	//其他不启用
	@RequestMapping("/updateStatementNotice1.do")
	@ResponseBody
	public JsonResult updateStatementNotice1(Long id, HttpSession session){
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		statementService.updateStatementNotice1(id,ownerId, operatorId, tamp, false);
		return new JsonResult();
	}
	//查找作者
	@RequestMapping("/findByOperatorId.do")
	@ResponseBody
	public JsonResult findByOperatorId(HttpSession session,Long id) {
		Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
		UserInfo ui=statementService.findByOperatorId(id, ownerId);
		return new JsonResult(ui);
	}
}
