package com.rongcheng.rcb.entity;

import java.io.Serializable;

public class TwoMenu implements Serializable {
	
	private static final long serialVersionUID = 8894856173395862839L;
	
	private Integer id;			//（10）（无符号型自增id）
	private Integer oneMenuId;	//（10） 一级标题id（非空）
	private String title; 		//（50） 标题
	private String iconUrl; 	//（100） 二级标题图标url地址
	private String link;		//（500） 链接地址
	private String profile; 	//（200） 简介
	private String keyword; 	//（100） 关键字
	private Byte display; 			//（3） 是否显示（默认1。0：不显示，1：显示。）
	private Byte seq; 			//（3） 排序（默认100，取值0-255，值越小越靠前）
	private String remark; 		//（200） 备注

	public TwoMenu() {
	}

	public TwoMenu(Integer id, Integer oneMenuId, String title, String iconUrl, String link, String profile,
			String keyword, Byte display, Byte seq, String remark) {
		super();
		this.id = id;
		this.oneMenuId = oneMenuId;
		this.title = title;
		this.iconUrl = iconUrl;
		this.link = link;
		this.profile = profile;
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

	public Integer getOneMenuId() {
		return oneMenuId;
	}

	public void setOneMenuId(Integer oneMenuId) {
		this.oneMenuId = oneMenuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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

	@Override
	public String toString() {
		return "TwoMenu [id=" + id + ", oneMenuId=" + oneMenuId + ", title=" + title + ", iconUrl=" + iconUrl
				+ ", link=" + link + ", profile=" + profile + ", keyword=" + keyword + ", display=" + display + ", seq="
				+ seq + ", remark=" + remark + "]";
	}
}
