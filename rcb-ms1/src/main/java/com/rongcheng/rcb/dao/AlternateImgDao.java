package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.AlternateImg;

public interface AlternateImgDao {
	public AlternateImg findAlternateImgById(Integer id); //通过id查出一条信息
	public int addAlternateImg(AlternateImg aig);//添加
	public int delAlternateImgById(Integer id);//删除
	Integer delAlternateImgByModuleId(Integer moduleId);//删除
	public int modifyAlternateImg(AlternateImg aig);//修改
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
