package com.rongcheng_tech.cms.dao;
import java.util.List;

import com.rongcheng_tech.cms.entity.StatementNotice;

public interface StatementNoticeDao {
	//分页
	 List<StatementNotice> findStatementNoticeByPage(int start,int rows,Long ownerId);
	 String findStatementNoticeCount(Long ownerId);
	 StatementNotice findByStatementNoticeId(Long id,Long ownerId);
	//修改，添加,删除方法
	 int modifyStatementNotice(StatementNotice sn);
	 int modifyStatementNotice1(StatementNotice sn);
	 int addStatementNotice(StatementNotice sn);
	 void delStatementNotice(Long id,Long ownerId);
	 //模糊查询
	 List<StatementNotice> findListByStatementNotice(String keyword,Long ownerId);
	 //其他不启用
	 List<StatementNotice> findListByReserved1(Long id,Long ownerId);
}
