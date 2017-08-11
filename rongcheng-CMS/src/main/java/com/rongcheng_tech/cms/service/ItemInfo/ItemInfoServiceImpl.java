package com.rongcheng_tech.cms.service.ItemInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng_tech.cms.dao.ItemInfoDAO;
import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.MediaInfo;

@Service("itemInfoService")
public class ItemInfoServiceImpl implements ItemInfoService {
	@Resource
	private ItemInfoDAO itemInfoDAO;

	public Object[] pageByOwnerIdAndKeyword(Long ownerId, int page, int rows, String blockChannelId, String keyword) {
		int maxPage = (int) Math.ceil(new Double(itemInfoDAO.countByOwnerIdAndKeyword(ownerId,blockChannelId,keyword))/rows);
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
		map.put("start", start);
		map.put("rows", rows);
		map.put("blockChannelId", blockChannelId);
		map.put("keyword", keyword);
		
		List<ItemInfo> mediaInfoList = itemInfoDAO.listByOwnerIdAndKeyword(map);
		return new Object[]{maxPage,mediaInfoList};
	}

	public List<ItemInfo> getItemSku(String keyword, Long ownerId) {
		List<ItemInfo> list=itemInfoDAO.getItemSku(keyword, ownerId);	
		return list;
	}


}
