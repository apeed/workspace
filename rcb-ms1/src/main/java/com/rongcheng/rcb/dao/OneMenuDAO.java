package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.OneMenu;

public interface OneMenuDAO {
	String getTitleById(Integer id);
	OneMenu getOneMenuById(Integer id);
	
	/**
	 * 查询前几个一级菜单（包含不显示的）
	 * @param num 要查询的数量
	 * @return
	 */
	List<OneMenu> listOneMenuByFrontRow(Integer num);
	////////zb////
	//查找OneMenu所有对象
	public List<OneMenu> listOneMenuAll();
	
	//增加OneMenu
	public int insertOneMenu(OneMenu oneMenu);
	
	//查找OneMenu根据id
	//public OneMenu getOneMenuById(Integer id);
	
	//修改OneMenu
	public int updateOneMenu(OneMenu oneMenu);
	
	//删除OneMenu
	public int deleteOneMenuById(Integer id);
	
	//查找SinglePage条数
	public int countOneMenu();
	////////zb////
}
