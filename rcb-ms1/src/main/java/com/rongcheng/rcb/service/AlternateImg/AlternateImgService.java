package com.rongcheng.rcb.service.AlternateImg;

import java.util.List;

import com.rongcheng.rcb.entity.AlternateImg;


public interface AlternateImgService {
	public AlternateImg findAlternateImgById(Integer id); //通过id查出一条信息
	public int addAlternateImgCol(Integer moduleId,String title,String imgUrl,String keyword,
			String link,String remark,String profile,Byte display,Byte seq);//添加轮播图
	public int delAlternateImgById(Integer id);//删除
	Integer delAlternateImgByModuleId(Integer moduleId);//删除
	public int modifyAlternateImg(Integer id,String title,String imgUrl,String keyword,
			String link,String remark,String profile,Byte display,Byte seq);//修改
	public List<AlternateImg> findAlternateImgAll();//查全部
	
	/**
	 * 
	 * @author jxb
	 *
	 * @param moduleId
	 * @param displayNumber
	 * @return
	 */
	List<AlternateImg> listAlternateImgByModuleIdAndDisplayNumber(Integer moduleId,Integer displayNumber);
}
