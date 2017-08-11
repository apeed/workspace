package com.rongcheng.rcb.service.leave_message;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.LeaveMessageDAO;
import com.rongcheng.rcb.entity.LeaveMessage;

@Service("leaveMessageService")
public class LeaveMessageServiceImpl implements LeaveMessageService {

	@Resource
	private LeaveMessageDAO leaveMessageDAO;

	public int saveLeaveMessage(LeaveMessage leaveMessage) {
		return leaveMessageDAO.saveLeaveMessage(leaveMessage);
	}
	public int delLeaveMessageById(String id) {
		int n=leaveMessageDAO.delLeaveMessageById(id);
		return n;
	}

	public int delLeaveMessagesById(String... id) {
	
		int m = leaveMessageDAO.delLeaveMessagesById(id);
		return m;
	}

	public List<LeaveMessage> findLeaveMessageByPage(int start,int rows) {
		List<LeaveMessage> list=leaveMessageDAO.findLeaveMessageByPage(start,rows);
		return list;
	}

	public String findLeaveMessageCount() {
		String p = leaveMessageDAO.findLeaveMessageCount();
		return p;
	}
	public LeaveMessage getLeaveMessageById(Integer id) {
		return leaveMessageDAO.getLeaveMessageById(id);
	}
	public int updateLeaveMessage(LeaveMessage leaveMessage) {
		return leaveMessageDAO.updateLeaveMessage(leaveMessage);
	}
}
