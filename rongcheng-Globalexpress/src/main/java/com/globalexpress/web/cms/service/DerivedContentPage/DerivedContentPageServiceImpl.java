package com.globalexpress.web.cms.service.DerivedContentPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.cms.dao.DerivedContentPageDAO;
import com.globalexpress.web.entity.DerivedContentPage;
import com.globalexpress.web.entity.MediaInfo;

@Service("contentPageService")
public class DerivedContentPageServiceImpl implements DerivedContentPageService {
	@Resource
	private DerivedContentPageDAO derivedContentPageDAO;

	public Object[] pageByOwnerIdAndKeyword(Long ownerId, String seq, int page, int rows, String blockChannelId, String keyword) {
		int maxPage = (int) Math.ceil(new Double(derivedContentPageDAO.countByBlockIdAndKeyword(ownerId,blockChannelId,keyword))/rows);
		if(maxPage == 0){
			return new Object[]{0,new ArrayList<MediaInfo>()};
		}
		if(page>maxPage){
			page = maxPage;
		}
		if(page<1){
			page = 1;
		}
		int start = page*rows-rows;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ownerId", ownerId);
		map.put("seq", seq);
		map.put("start", start);
		map.put("rows", rows);
		map.put("blockChannelId", blockChannelId);
		map.put("keyword", keyword);
		
		List<DerivedContentPage> blockChannelList = derivedContentPageDAO.limitByBlockIdAndKeyword(map);
		return new Object[]{maxPage,blockChannelList};
	}

}
