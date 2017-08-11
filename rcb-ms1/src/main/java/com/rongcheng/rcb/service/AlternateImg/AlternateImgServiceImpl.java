package com.rongcheng.rcb.service.AlternateImg;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.AlternateImgDao;
import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.exception.ModuleIdException;
import com.rongcheng.rcb.exception.ModuleNameException;

@Service("alternateImgService")
public class AlternateImgServiceImpl implements AlternateImgService {
	@Resource
	private AlternateImgDao dao;
	public AlternateImg findAlternateImgById(Integer id) {
		AlternateImg hig=dao.findAlternateImgById(id);
		return hig;
	}
	public int delAlternateImgById(Integer id) {
		int n=dao.delAlternateImgById(id);
		return n;
		
	}
	public Integer delAlternateImgByModuleId(Integer moduleId) {
		int n=dao.delAlternateImgByModuleId(moduleId);
		return n;
	}
	public int modifyAlternateImg(Integer id,String title,String imgUrl,String keyword,
			String link,String remark,String profile,Byte display,Byte seq) {
		AlternateImg aim = dao.findAlternateImgById(id);
		aim.setTitle(title);
		aim.setImgUrl(imgUrl);
		aim.setKeyword(keyword);
		aim.setLink(link);
		aim.setRemark(remark);
		aim.setProfile(profile);
		aim.setDisplay(display);
		aim.setSeq(seq);
		int n1=dao.modifyAlternateImg(aim);
		return n1;
	}
	public List<AlternateImg> findAlternateImgAll() {
		List<AlternateImg> list=dao.findAlternateImgAll();
		return list;
	}
	public int addAlternateImgCol(Integer moduleId,String title, String imgUrl, String keyword, String link, String remark,
			String profile, Byte display, Byte seq) {
		if(moduleId==null){//...........................
			throw new ModuleIdException("栏目id不能为空");
		}
		AlternateImg ai = new AlternateImg();
		ai.setModuleId(moduleId);
		ai.setTitle(title);
		ai.setImgUrl(imgUrl);
		ai.setKeyword(keyword);
		ai.setLink(link);
		ai.setRemark(remark);
		ai.setProfile(profile);
		ai.setDisplay(display);
		ai.setSeq(seq);
		System.out.println(ai);
		int n=dao.addAlternateImg(ai);
		return n;
	}
	
	/**
	 * 
	 * @author jxb
	 *
	 * @param moduleId
	 * @param displayNumber
	 * @return
	 */
	public List<AlternateImg> listAlternateImgByModuleIdAndDisplayNumber(Integer moduleId, Integer displayNumber) {
		return dao.listAlternateImgByModuleIdAndDisplayNumber(moduleId, displayNumber);
	}
}