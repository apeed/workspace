package com.rongcheng_tech.cms.dao;

import java.util.List;

import com.rongcheng_tech.cms.entity.BlockContentLink;

public interface BlockContentLinkDAO {
	int insertSelective(List<BlockContentLink> record);
	
	
	
    int deleteByPrimaryKey(Long id);

    BlockContentLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlockContentLink record);

}