package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.LeaveMessage;

public interface LeaveMessageDAO {
	int saveLeaveMessage(LeaveMessage leaveMessage);
	LeaveMessage getLeaveMessageById(Integer id);
	int delLeaveMessageById(String id); //通过id删除表中一条信息
	int delLeaveMessagesById(String[] id); //通过id数组删除表中多条信息
	List<LeaveMessage> findLeaveMessageByPage(int start,int rows);//分页查找LeaveMessage
	String findLeaveMessageCount();//查找LeaveMessage记录的总条数
	int updateLeaveMessage(LeaveMessage leaveMessage);
}
