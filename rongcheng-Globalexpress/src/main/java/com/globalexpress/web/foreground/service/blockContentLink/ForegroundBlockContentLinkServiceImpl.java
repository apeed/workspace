package com.globalexpress.web.foreground.service.blockContentLink;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.entity.BlockContentLink;
import com.globalexpress.web.foreground.dao.ForegroundBlockContentLinkDao;

@Service("fBlockContentLinkService")
public class ForegroundBlockContentLinkServiceImpl implements ForegroundBlockContentLinkService {
	@Resource
	private ForegroundBlockContentLinkDao dao;

	public Object[] pageSelective(BlockContentLink bcl, Byte[] contentType, int page, int rows) {
		int maxPage = (int) Math.ceil(new Double(dao.countSelective(bcl, contentType))/rows);
		if(maxPage == 0){
			return new Object[]{0,new ArrayList<BlockContentLink>()};
		}
		if(page>maxPage){
			page = maxPage;
		}
		if(page<1){
			page = 1;
		}
		int start = page*rows-rows;
		List<BlockContentLink> blockContentLinkList = dao.limitSelective(bcl, contentType, start, rows);
		return new Object[]{maxPage,blockContentLinkList};
	}

}
