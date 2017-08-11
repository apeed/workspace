package com.globalexpress.web.foreground.service.derivedContentPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.entity.DerivedContentPage;
import com.globalexpress.web.foreground.dao.ForegroundDerivedContentPageDao;

@Service("fDerivedContentPageService")
public class ForegroundDerivedContentPageServiceImpl implements ForegroundDerivedContentPageService {
	@Resource
	private ForegroundDerivedContentPageDao derivedContentPageDao;

	public Object[] pageByBlockIdAndKeyword(Long ownerId, String seq, int page, int rows, Long blockId,
			String keyword) {
		int maxPage = (int) Math.ceil(
				new Double(derivedContentPageDao.countByOwnerIdAndKeyword(ownerId, blockId, keyword)) / rows);
		if (maxPage == 0) {
			return new Object[] { 0, new ArrayList<DerivedContentPage>() };
		}
		if (page > maxPage) {
			page = maxPage;
		}
		if (page < 1) {
			page = 1;
		}
		int start = page * rows - rows;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ownerId", ownerId);
		map.put("seq", seq);
		map.put("start", start);
		map.put("rows", rows);
		map.put("blockId", blockId);
		map.put("keyword", keyword);

		List<DerivedContentPage> blockChannelList = derivedContentPageDao.limitByBlockIdAndKeyword(map);
		return new Object[] { maxPage, blockChannelList };
	}
	
	public List<DerivedContentPage> pageByBlockIdAndKeyword(Long ownerId, int start, int rows, Long blockId,
			String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ownerId", ownerId);
		map.put("start", start);
		map.put("rows", rows);
		map.put("blockId", blockId);
		map.put("keyword", keyword);
		List<DerivedContentPage> blockChannelList = derivedContentPageDao.limitByBlockIdAndKeyword(map);
		return blockChannelList;
	}

}
