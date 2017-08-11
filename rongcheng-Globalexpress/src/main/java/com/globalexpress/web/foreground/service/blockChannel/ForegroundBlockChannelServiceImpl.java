package com.globalexpress.web.foreground.service.blockChannel;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.globalexpress.web.entity.BlockChannel;
import com.globalexpress.web.foreground.dao.ForegroundBlockChannelDao;

public class ForegroundBlockChannelServiceImpl implements ForegroundBlockChannelService {
	@Resource
	ForegroundBlockChannelDao blockChannelDao;

	/*public List<BlockChannel> 该类型所有栏目(Long ownerId, Integer recordType) {
		BlockChannel bc = new BlockChannel();
		bc.setOwnerId(ownerId);
		bc.setRecordType(recordType);
		//该类型所有栏目
		List<BlockChannel> blockChannelList = blockChannelDao.listSelective(bc);
		return blockChannelList;
	}
	public Map<BlockChannel, List<Map<BlockChannel, List<BlockChannel>>>> 得到顶级栏目集合(List<BlockChannel> blockChannelList) {
		
		List<BlockChannel> 顶级栏目 = new ArrayList<BlockChannel>();
		Map<BlockChannel, List<Map<BlockChannel, List<BlockChannel>>>> 栏目 = new HashMap<BlockChannel, List<Map<BlockChannel,List<BlockChannel>>>>();
		Iterator<BlockChannel> it = blockChannelList.iterator();
		while (it.hasNext()) {
			BlockChannel blockChannel = (BlockChannel) it.next();
			Long parentId = blockChannel.getParentId();
			if(parentId == 0L){
				栏目.put(blockChannel, null);
				顶级栏目.add(blockChannel);
				it.remove();
			}
		}
		得到栏目集合(顶级栏目, blockChannelList);
		
		return 栏目;
	}
	
	public List<BlockChannel> 得到栏目集合(List<BlockChannel> 父栏目集合,List<BlockChannel> blockChannelList) {
		List<BlockChannel> 父栏目_父 = new ArrayList<BlockChannel>();
		Map<BlockChannel, List<Map<BlockChannel, List<BlockChannel>>>> 栏目 = new HashMap<BlockChannel, List<Map<BlockChannel,List<BlockChannel>>>>();
		Iterator<BlockChannel> it = blockChannelList.iterator();
		for (BlockChannel 父栏目 : 父栏目集合) {
			while (it.hasNext()) {
				BlockChannel blockChannel = (BlockChannel) it.next();
				Long parentId = blockChannel.getParentId();
				if(parentId == 父栏目.getId()){
					栏目.put(blockChannel, null);
					父栏目_父.add(blockChannel);
					it.remove();
				}
			}
		}
		//遍历栏目集合，查询各栏目下直接子栏目
		for (BlockChannel blockChannel : 父栏目集合) {
			Long parentId = blockChannel.getParentId();
			if(parentId == 0L){
				顶级栏目.put(blockChannel, null);
			}
		}
		return 顶级栏目;
	}
	
	
	
	
	
	//获取指定栏目下的直接子栏目
	public Map<BlockChannel, Object> listBlockChannel(Long parentId, Integer recordType, Long ownerId, Map<BlockChannel, Object> map) {
		
		//栏目，当前栏目下子栏目集合
		//Map<BlockChannel, List<Map<BlockChannel, List<BlockChannel>>>> map = new HashMap<BlockChannel, List<Map<BlockChannel,List<BlockChannel>>>>()
		
		BlockChannel bc = new BlockChannel();
		bc.setOwnerId(ownerId);
		bc.setRecordType(recordType);
		bc.setParentId(parentId);
		//当前父类下直接子栏目
		List<BlockChannel> blockChannelList = blockChannelDao.listSelective(bc);
		//如果没有子栏目，退出方法
		if(blockChannelList == null || blockChannelList.size() ==0){
			map.put(null, null);
			return map;
		}
		//遍历栏目集合
		for (BlockChannel blockChannel : blockChannelList) {
			map.put(blockChannel, new Object());
			//当前栏目id
			Long id = blockChannel.getId();
			listBlockChannel(id, recordType, ownerId, map);
		}
		return map;
	}*/
	public Map<BlockChannel, List<BlockChannel>> mapNavigationBars(Long ownerId, Integer recordType) {
		// TODO Auto-generated method stub
		return null;
	}

}
