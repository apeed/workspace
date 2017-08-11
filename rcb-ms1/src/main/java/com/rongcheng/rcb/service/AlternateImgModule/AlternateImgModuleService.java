package com.rongcheng.rcb.service.AlternateImgModule;

import java.util.List;

import com.rongcheng.rcb.entity.AlternateImgModule;

public interface AlternateImgModuleService {
	public AlternateImgModule findAlternateImgModuleById(Integer id);
	public int addAlternateImgCol(String moduleName,String remark,Byte display);//添加轮播图栏目
	public  int delAlternateImgModuleById(Integer id);//删除
	public  int modifyHomeImg(Integer id,String moduleName,String remark,Byte display);//修改
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
