package com.rongcheng.rcb.service.one_menu;

import java.util.List;

import com.rongcheng.rcb.entity.OneMenu;

public interface OneMenuService {
	String getTitleById(Integer id);
	OneMenu getOneMenuById(Integer id);
	/**
	 * 查询前几个一级菜单（包含不显示的）
	 * @param num 要查询的数量
	 * @return
	 */
	List<OneMenu> listOneMenuByFrontRow(Integer num);
	/////zb//////////
	//查找OneMenu所有对象
		public List<OneMenu> listOneMenuAll();
		
		//增加OneMenu
		public OneMenu insertOneMenu(String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark);
		
		//修改OneMenu
		public int updateOneMenu(Integer id, String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark);
		
		//删除OneMenu
		public int deleteOneMenuById(Integer id);
		
		//查找OneMenu根据id，返回OneMenu对象
		//public OneMenu getOneMenuById(Integer id);
	/////zb//////////
}
