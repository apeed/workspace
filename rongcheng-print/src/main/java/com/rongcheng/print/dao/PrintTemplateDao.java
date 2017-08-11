package com.rongcheng.print.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.rongcheng.print.entity.AddressCarrierAllocation;
import com.rongcheng.print.entity.PrintTemplate;

public interface PrintTemplateDao {
public List<PrintTemplate> findtemplateType(BigInteger carrierId);
public PrintTemplate findtemplateName(BigInteger id);
//public void modifyPrintTemplate(Map<Object, Object> map);//修改
}
