package com.rongcheng.rcb.entity;

import java.io.Serializable;

public class Config implements Serializable {

	private static final long serialVersionUID = -4500649329682146893L;
	
	private Integer id;			//（10） （无符号型自增id）
	private String paramName; 	//（50）   参数名
	private String paramValue1; //（500） 参数值1
	private String paramValue2; //（500） 参数值2
	private String paramValue3; //（500） 参数值3
	private String remark; 		//（200） 备注

	public Config() {
	}

	public Config(Integer id, String paramName, String paramValue1, String paramValue2, String paramValue3,
			String remark) {
		super();
		this.id = id;
		this.paramName = paramName;
		this.paramValue1 = paramValue1;
		this.paramValue2 = paramValue2;
		this.paramValue3 = paramValue3;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue1() {
		return paramValue1;
	}

	public void setParamValue1(String paramValue1) {
		this.paramValue1 = paramValue1;
	}

	public String getParamValue2() {
		return paramValue2;
	}

	public void setParamValue2(String paramValue2) {
		this.paramValue2 = paramValue2;
	}

	public String getParamValue3() {
		return paramValue3;
	}

	public void setParamValue3(String paramValue3) {
		this.paramValue3 = paramValue3;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Config [id=" + id + ", paramName=" + paramName + ", paramValue1=" + paramValue1 + ", paramValue2="
				+ paramValue2 + ", paramValue3=" + paramValue3 + ", remark=" + remark + "]";
	}
}
