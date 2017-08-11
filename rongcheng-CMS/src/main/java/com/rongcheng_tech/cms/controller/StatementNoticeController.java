package com.rongcheng_tech.cms.controller;
import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rongcheng_tech.cms.entity.StatementNotice;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.StatementNotice.StatementNoticeService;
import com.rongcheng_tech.cms.utils.JsonResult;

@Controller
public class StatementNoticeController {
	private int rows=20;
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	
	@Resource
	private StatementNoticeService service;
	
	@RequestMapping("/notice.do")
	public String toNotice(){
		return "notice";
	}
	@RequestMapping("/noticePublic.do")
	public String noticePublic(){
		return "noticePublic";
	}
	@RequestMapping("/noticeAdd.do")
	public String noticeAdd(){
		return "noticeAdd";
	}
	//根据页码检索商品信息
	@RequestMapping("/loadList_notice.do")
	@ResponseBody
	public JsonResult loadStatementNotice(HttpSession session,String page) {
		return loadStatementNotices(session,page);
	}
	
	//根据页码检索
	public JsonResult loadStatementNotices(HttpSession session,String page) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int max_page = (int) Math.ceil(new Double(service.findStatementNoticeCount(ownerId))/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		List<StatementNotice> StatementNotice=service.findStatementNoticeByPage(new Integer(page)*rows-rows,rows,ownerId);
		JsonResult jr = new JsonResult(StatementNotice);
		jr.setMessage(max_page+"");
		return jr;
	}
	//加载修改内容
	@RequestMapping("/load_modify_notice.do")
	@ResponseBody
	public JsonResult findByStatementNoticeId(HttpSession session,Long id){
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		StatementNotice sn=service.findByStatementNoticeId(id, ownerId);
		return new JsonResult(sn);
	}
	//修改内容
	@RequestMapping("/modify_statementNotice.do")
	@ResponseBody
	public JsonResult modifyStatementNotice(Long id,String statementTitle, String statement, String notice,String note,HttpSession  session){
	Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
	Timestamp tamp = new Timestamp(System.currentTimeMillis());
	Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
	int n=service.modifyStatementNotice(id,ownerId,statementTitle, statement, notice, note, operatorId, tamp);
	return new JsonResult(n);
	}
	//添加内容
	@RequestMapping("/add_statementNotice.do")
	@ResponseBody
	public JsonResult addStatementNotice(String statementTitle, String statement,
			String notice,String note,HttpSession session){
		Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int n=service.addStatementNotice(ownerId, tamp, statementTitle, statement, notice, note,operatorId);
//	System.out.println(ownerId+","+gmtCreate+","+statementTitle+","+statement+","+notice);
	return new JsonResult(n);
	}
	//删除单条
	@RequestMapping("/delStatementNotice.do")
	@ResponseBody
	public JsonResult delStatementNotice(HttpSession session,Long id) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.delStatementNotice(id, ownerId);
		return new JsonResult();
	}
	//模糊查询
	@RequestMapping("/findListByStatementNotice.do")
	@ResponseBody
	public JsonResult findListByStatementNotice(HttpSession session,String keyword) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		List<StatementNotice> list=service.findListByStatementNotice(keyword, ownerId);
		return new JsonResult(list);
	}
	//批量删除
	@RequestMapping("/delStatementNoticeList.do")
	@ResponseBody
	public JsonResult delStatementNoticeList(HttpSession session,Long[] id1) {
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		service.delStatementNoticeList(id1, ownerId);
		return new JsonResult();
	}
	//启用
	@RequestMapping("/updateStatementNotice.do")
	@ResponseBody
	public JsonResult updateStatementNotice(Long id,HttpSession  session){
	Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
	Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
	Timestamp tamp = new Timestamp(System.currentTimeMillis());
	int n=service.updateStatementNotice(id, ownerId, operatorId, tamp, "1");
	return new JsonResult(n);
	}
	//其他不启用
	@RequestMapping("/updateStatementNotice1.do")
	@ResponseBody
	public JsonResult updateStatementNotice1(Long id,HttpSession  session){
	Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
	Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
	Timestamp tamp = new Timestamp(System.currentTimeMillis());
	service.updateStatementNotice1(id,ownerId, operatorId, tamp, "0");
	return new JsonResult();
	}
}
