package com.rongcheng.rcb.service.leave_message;

import java.util.List;

import com.rongcheng.rcb.entity.LeaveMessage;

public interface LeaveMessageService {

	int saveLeaveMessage(LeaveMessage leaveMessage);
	LeaveMessage getLeaveMessageById(Integer id);
	int delLeaveMessageById(String id); //通过id删除表中一条信息
	int delLeaveMessagesById(String... ids);//删除多条
	List<LeaveMessage> findLeaveMessageByPage(int start , int rows);//分页查找LeaveMessage
	String findLeaveMessageCount();//查找LeaveMessage记录的总条数
	int updateLeaveMessage(LeaveMessage leaveMessage);
}
