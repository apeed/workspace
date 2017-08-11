package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.TwoMenu;

public interface TwoMenuDAO {
	String getTitleById(Integer id);
	List<TwoMenu> listTwoMenuDisplayByOneMenuId(Integer oneMenuId);
	
	/////////////zb////////
	//查找TwoMenu所有对象
		public List<TwoMenu> listTwoMenuAll();
		
		//增加TwoMenu
		public int insertTwoMenu(TwoMenu twoMenu);
		
		//查找TwoMenu根据id
		public TwoMenu getTwoMenuById(Integer id);
		
		//修改TwoMenu
		public int updateTwoMenu(TwoMenu twoMenu);
		
		//删除TwoMenu
		public int deleteTwoMenuById(Integer id);
		
		//查找TwoMenu根据oneMenuId
		public List<TwoMenu> listTwoMenuByOneMenuId(Integer oneMenuID);
	/////////////zb////////
}
