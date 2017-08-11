package com.rongcheng.rcb.service.AlternateImgModule;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.AlternateImgDao;
import com.rongcheng.rcb.dao.AlternateImgModuleDao;
import com.rongcheng.rcb.entity.AlternateImg;
import com.rongcheng.rcb.entity.AlternateImgModule;
import com.rongcheng.rcb.exception.ModuleNameException;

@Service("alternateImgModuleService")
public class AlternateImgModuleServiceImpl implements AlternateImgModuleService {
	@Resource
	private AlternateImgModuleDao dao;
	@Resource
	private AlternateImgDao aidao;
	
	public AlternateImgModule findAlternateImgModuleById(Integer id) {
		AlternateImgModule aim=dao.findAlternateImgModuleById(id);
		return aim;
	}
	public int addAlternateImgCol(String moduleName, String remark, Byte display) {
		if(moduleName==null||moduleName.trim().isEmpty()){
			throw new ModuleNameException("栏目名称不能为空");
		}
		
		AlternateImgModule aim  = new AlternateImgModule();
		aim.setModuleName(moduleName);
		aim.setRemark(remark);
		aim.setDisplay(display);
		int n =dao.addAlternateImgModule(aim);
		return n;
	}
	public int delAlternateImgModuleById(Integer id) {
		aidao.delAlternateImgByModuleId(id);
		dao.delAlternateImgModuleById(id);
		return 1;
	}
	public int modifyHomeImg(Integer id,String moduleName, String remark, Byte display) {
		AlternateImgModule aim =dao.findAlternateImgModuleById(id);
		aim.setRemark(remark);
		aim.setModuleName(moduleName);
		aim.setDisplay(display);
		int n=dao.modifyAlternateImgModule(aim);
		return n;
	}
	public List<AlternateImgModule> findAlternateImgModuleAll() {
		List<AlternateImgModule> list=dao.findAlternateImgModuleAll();
		return list;
	}
	/**
	 * 
	 * @author jxb
	 *
	 * @param num
	 * @return
	 */
	public List<AlternateImgModule> listAlternateImgModuleByFrontRow(Integer num) {
		return dao.listAlternateImgModuleByFrontRow(num);
	}
}
