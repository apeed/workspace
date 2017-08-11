package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.AlternateImgModule;

public interface AlternateImgModuleDao {
	public AlternateImgModule findAlternateImgModuleById(int id);
	public int addAlternateImgModule(AlternateImgModule aim);//添加轮播图栏目
	public int modifyAlternateImgModule(AlternateImgModule aim);//修改
	public void delAlternateImgModuleById(Integer id);//删除
	public List<AlternateImgModule> findAlternateImgModuleAll();//查全部
	/**
	 * 
	 * @author jxb
	 *
	 * @param num
	 * @return
	 */
	List<AlternateImgModule> listAlternateImgModuleByFrontRow(Integer num);
}
