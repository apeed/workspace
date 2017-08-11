package com.rongcheng.rcb.entity;

import java.io.Serializable;

public class AlternateImg implements Serializable {

	private static final long serialVersionUID = -1769878778703593771L;
	
	private Integer id;			//（10）（无符号型自增id）
	private Integer moduleId; 	//（10）轮播图所属模块（非空）
	private String title; 		//（50） 标题
	private String imgUrl;		//（100） 轮播图url地址
	private String profile; 	//（200） 简介
	private String link; 		//（500） 链接地址
	private String keyword; 	//（100） 关键字
	private Byte display; 			//（3） 是否显示（默认1。0：不显示，1：显示。）
	private Byte seq; 			//（3） 排序（默认100，取值0-255，值越小越靠前）
	private String remark; 		//（200） 备注

	public AlternateImg() {
	}

	public AlternateImg(Integer id, Integer moduleId, String title, String imgUrl, String profile, String link,
			String keyword, Byte display, Byte seq, String remark) {
		super();
		this.id = id;
		this.moduleId = moduleId;
		this.title = title;
		this.imgUrl = imgUrl;
		this.profile = profile;
		this.link = link;
		this.keyword = keyword;
		this.display = display;
		this.seq = seq;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Byte getDisplay() {
		return display;
	}

	public void setDisplay(Byte display) {
		this.display = display;
	}

	public Byte getSeq() {
		return seq;
	}

	public void setSeq(Byte seq) {
		this.seq = seq;
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
		return "AlternateImg [id=" + id + ", moduleId=" + moduleId + ", title=" + title + ", imgUrl=" + imgUrl
				+ ", profile=" + profile + ", link=" + link + ", keyword=" + keyword + ", display=" + display + ", seq="
				+ seq + ", remark=" + remark + "]";
	}
}
