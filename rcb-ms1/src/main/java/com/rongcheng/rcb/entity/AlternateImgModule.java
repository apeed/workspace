package com.rongcheng.rcb.entity;

import java.io.Serializable;

public class AlternateImgModule implements Serializable {

	private static final long serialVersionUID = 8939892281889302511L;
	
	private Integer id;			//（10）（无符号型自增id）
	private String moduleName; 	//（50）轮播图模块名（非空唯一）
	private Byte display; 			//（3）是否显示（默认1。0：不显示，1：显示。）
	private String remark; 		//（200） 备注

	public AlternateImgModule() {
	}

	public AlternateImgModule(Integer id, String moduleName, Byte display, String remark) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.display = display;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Byte getDisplay() {
		return display;
	}

	public void setDisplay(Byte display) {
		this.display = display;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AlternateImgModule [id=" + id + ", moduleName=" + moduleName + ", display=" + display + ", remark="
				+ remark + "]";
	}
}
