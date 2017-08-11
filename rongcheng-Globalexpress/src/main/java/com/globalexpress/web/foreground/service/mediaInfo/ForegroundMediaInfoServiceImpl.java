package com.globalexpress.web.foreground.service.mediaInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.entity.MediaInfo;
import com.globalexpress.web.foreground.dao.ForegroundMediaInfoDao;

@Service("fMediaInfoService")
public class ForegroundMediaInfoServiceImpl implements ForegroundMediaInfoService {
	@Resource
	private ForegroundMediaInfoDao mediaInfoDao;

	public Object[] pageByBlockIdAndKeyword(Long ownerId, String seq, int page, int rows, Long blockId, String keyword) {
		int maxPage = (int) Math.ceil(new Double(mediaInfoDao.countByBlockIdAndKeyword(ownerId,blockId,keyword))/rows);
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
		map.put("blockId", blockId);
		map.put("keyword", keyword);
		
		List<MediaInfo> mediaInfoList = mediaInfoDao.limitByBlockIdAndKeyword(map);
		return new Object[]{maxPage,mediaInfoList};
	}


	public List<MediaInfo> pageByBlockIdAndKeyword(Long ownerId, int start, int rows, Long blockId,
			String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ownerId", ownerId);
		map.put("start", start);
		map.put("rows", rows);
		map.put("blockId", blockId);
		map.put("keyword", keyword);
		List<MediaInfo> mediaInfoList = mediaInfoDao.limitByBlockIdAndKeyword(map);
		return mediaInfoList;
	}
}
