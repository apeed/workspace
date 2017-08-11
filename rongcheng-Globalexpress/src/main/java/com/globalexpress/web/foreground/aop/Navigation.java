package com.globalexpress.web.foreground.aop;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;

import com.globalexpress.web.entity.BlockChannel;
import com.globalexpress.web.entity.UserConfigSettings;
import com.globalexpress.web.foreground.dao.ForegroundBlockChannelDao;
import com.globalexpress.web.foreground.dao.ForegroundUserConfigSettingsDao;
import com.globalexpress.web.foreground.service.userConfigSettings.ForegroundUserConfigSettingsService;

import net.sf.json.JSONArray;



@Aspect
public class Navigation {
	// 主账号id
	@Value("#{config['ownerId']}")
	private Long ownerId;

	@Resource
	ForegroundBlockChannelDao blockChannelDao;
	@Resource
	ForegroundUserConfigSettingsDao configDao;
	@Resource
	private ForegroundUserConfigSettingsService fconfigService;
	//@Pointcut("execution( * com.jimlp.JIML.controller..*.*(..)")
	// 匹配所有在com包及其子包中的所以方法
	@Pointcut("within(com.globalexpress.web.foreground.controller..*)")
	public void inPage() {
	}

	@After(value = "inPage() && args(request,..)")
	public void inPageBefore(HttpServletRequest request) {
		BlockChannel bc = new BlockChannel();
		bc.setOwnerId(ownerId);
		//查导航类型的
		bc.setRecordType(5);
		ArrayList<BlockChannel> BlockChannelList = (ArrayList<BlockChannel>) blockChannelDao.listSelective(bc);
		JSONArray jo = JSONArray.fromObject(BlockChannelList);
		request.setAttribute("BCList", jo);
		//查配置
		HashMap<String, Object> map = fconfigService.getMapConfig(new UserConfigSettings(ownerId));
		map.put("ownerId", ownerId);
		request.setAttribute("configMap", map);
	}
}
