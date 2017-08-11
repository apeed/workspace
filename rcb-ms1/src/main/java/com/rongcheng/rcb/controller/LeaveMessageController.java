package com.rongcheng.rcb.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.rcb.entity.LeaveMessage;
import com.rongcheng.rcb.service.leave_message.LeaveMessageService;
import com.rongcheng.rcb.utils.JsonResult;

@Controller
@RequestMapping("/admin")
public class LeaveMessageController {
	//分页相关（每页多少条）
		@Value("#{sysconfig['rows']}")
		private int rows;
	@Resource
	private LeaveMessageService service;
	
	@RequestMapping("/book.do")
	public String book() {
		return "backstage/leave-message";
	}
	
	/*
	 * 删除路径/book/delBook.do
	 * 删除多条/book/delBooks.do
	 * 自动加载/book/loadBook.do
	 * 
	 * 涉及jsp为book。jsp文件，请在js文件夹下面创建js文件
	 * 请自行按照别的方法案例书写方法
	 * 如需传递参数请参考service
	 * 
	 * */
	
	//删除单条留言
	@RequestMapping("/book/delBook.do")
	@ResponseBody
	public JsonResult delBook(String id,String now_page) {
		int n = service.delLeaveMessageById(id);
		return loadBooks(now_page);
	}
	//删除多条留言
	@RequestMapping("/book/delBooks.do")
	@ResponseBody
	public JsonResult delBooks(String[] id,String now_page) {
		int n = service.delLeaveMessagesById(id);
		System.out.println(now_page);
		return loadBooks(now_page);
	}
	//根据页码检索留言
	@RequestMapping("/book/loadBook.do")
	@ResponseBody
	public JsonResult loadBook(String page) {
		return loadBooks(page);
	}
	
	//根据页码检索留言
	public JsonResult loadBooks(String page) {
		int max_page = (int) Math.ceil(new Double(service.findLeaveMessageCount())/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		if(new Integer(page)>max_page){
			page = max_page+"";
		}
		List<LeaveMessage> LeaveMessages = service.findLeaveMessageByPage(new Integer(page)*rows-rows,rows);
		//Iterator<LeaveMessage> it = LeaveMessages.iterator();
		/*while (it.hasNext()) {
			LeaveMessage gb = (LeaveMessage) it.next();
			System.out.println("条数"+gb.toString());
		}*/
		JsonResult jr = new JsonResult(LeaveMessages);
		jr.setMessage(max_page+"");
		return jr;
	}
	
	
	//留言详情页面
	@RequestMapping("/leavemessage/more.do")
	public String leaveMessage(HttpServletRequest request) {
		String id = request.getParameter("id");
		LeaveMessage leaveMessage = service.getLeaveMessageById(new Integer(id));
		request.setAttribute("leaveMessage", leaveMessage);
		return "backstage/leave-message-more";
	}
	//处理留言
	@RequestMapping("/leavemessage/update.do")
	@ResponseBody
	public JsonResult leaveMessageUpdate(String id,String display,String reply,String seq,String remark) {
		LeaveMessage leaveMessage = new LeaveMessage(new Integer(id), null, null, null, null, null, reply, null, new Byte(display), new Byte(seq), remark);
		int n = service.updateLeaveMessage(leaveMessage);
		return new JsonResult(n);
	}
	
	
	
	
	
	
}
