package com.rongcheng.rcb.service.two_menu;

import java.util.List;

import com.rongcheng.rcb.entity.TwoMenu;

public interface TwoMenuService {
	String getTitleById(Integer id);
	List<TwoMenu> listTwoMenuDisplayByOneMenuId(Integer oneMenuId);
	//////zb/////////////
	//查找TwoMenu所有对象
	public List<TwoMenu> listTwoMenuAll();
	
	//增加TwoMenu
	public TwoMenu insertTwoMenu(Integer oneMenuId,String title,String iconUrl, String link, String profile, String keyword,Byte display,
			Byte seq,String remark);
	
	//修改TwoMenu
	public int updateTwoMenu(Integer id, Integer oneMenuId,String title,String iconUrl, String link, String profile, String keyword,Byte display,
			Byte seq,String remark);
	
	//删除TwoMenu
	public int deleteTwoMenuById(Integer id);
	
	//查找TwoMenu根据id
	public TwoMenu getTwoMenuById(Integer id);
	
	//查找TwoMenu根据oneMenuId
	public List<TwoMenu> listTwoMenuByOneMenuId(Integer oneMenuID);
	//////zb/////////////
}
