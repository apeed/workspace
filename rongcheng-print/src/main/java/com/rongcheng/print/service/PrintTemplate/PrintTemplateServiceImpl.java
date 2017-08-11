package com.rongcheng.print.service.PrintTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.rongcheng.print.dao.PrintTemplateDao;
import com.rongcheng.print.entity.PrintTemplate;
@Service("printTemplateService")
public class PrintTemplateServiceImpl implements PrintTemplateService {
	@Resource
	private PrintTemplateDao dao;
	public List<PrintTemplate> findtemplateType(BigInteger carrierId) {
		List<PrintTemplate> pt=dao.findtemplateType(carrierId);
		return pt;
	}
	public PrintTemplate findtemplateName(BigInteger id) {
		PrintTemplate pt=dao.findtemplateName(id);
		return pt;
	}
	/*public int modifyPrintTemplate(BigInteger carrierId) {
		List<PrintTemplate> list=dao.findtemplateType(carrierId);
		return 0;
	}
	public void modifyPrintTemplate(Map<Object, Object> map) {
		
		
	}*/

}
