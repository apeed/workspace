package com.rongcheng_tech.cms.service.StatementNotice;

import java.sql.Timestamp;
import java.util.List;
import com.rongcheng_tech.cms.entity.StatementNotice;
import com.rongcheng_tech.cms.entity.UserInfo;

public interface StatementNoticeService {
	//分页 
	 List<StatementNotice> findStatementNoticeByPage(int start,int rows,Long ownerId);
	 String findStatementNoticeCount(Long ownerId);	
	//修改增加删除
	 StatementNotice findByStatementNoticeId(Long id,Long ownerId);
	 int modifyStatementNotice(Long id,Long ownerId,String statementTitle,String statement,String notice,String note,Long operatorId,Timestamp gmtModified);
	 int updateStatementNotice(Long id,Long ownerId,Long operatorId,Timestamp gmtModified,String reserved1);
	 int addStatementNotice(Long ownerId,Timestamp gmtCreate,String statementTitle,String statement,String notice,String note,Long operatorId);
	 void delStatementNotice(Long id,Long ownerId);
	 void delStatementNoticeList(Long[] id,Long ownerId);
	//模糊查询
	 List<StatementNotice> findListByStatementNotice(String keyword,Long ownerId);
	//其他不启用 修改
	 void updateStatementNotice1(Long id,Long ownerId,Long operatorId,Timestamp gmtModified,String reserved1);
	
//	 List<StatementNotice> findListByReserved1(Long ownerId);
}
