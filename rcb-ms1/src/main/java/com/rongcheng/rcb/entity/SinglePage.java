package com.rongcheng.rcb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SinglePage implements Serializable{
	
	private static final long serialVersionUID = -627627236021108626L;
	
	private Integer id;				//（10）（无符号型自增id）
	private Integer oneMenuId; 		//（10） 一级菜单id（非空）
	private Integer twoMenuId; 		//（10） 二级菜单（默认值-1。无二级菜单请赋值-1）
	private String title; 			//（50） 标题
	private String shortTitle; 		//（20） 短标题
	private String author; 			//（50） 短标题
	private String imgUrl; 			//（100） 图片
	private String keyword; 		//（100） 关键字
	private String profile; 		//（200） 简介
	private String content1; 		//（text） 主内容1
	private String content2; 		//（text） 主内容2
	private String content3; 		//（text） 主内容3
	private Timestamp createTime;	// 创建时间（默认值为数据库当前时间）
	private Timestamp modifyTime; 	// 修改时间
	private Byte display; 			//（3） 是否显示（默认1。0：不显示，1：显示。）
	private Byte seq; 				//（3） 排序（默认100，取值0-255，值越小越靠前）
	private Integer click; 			//（10） 点击量（默认值0）
	private String remark; 			//（200） 备注
	
	public SinglePage() {
		super();
	}

	public SinglePage(Integer id, Integer oneMenuId, Integer twoMenuId, String title, String shortTitle, String author,
			String imgUrl, String keyword, String profile, String content1, String content2, String content3,
			Timestamp createTime, Timestamp modifyTime, Byte display, Byte seq, Integer click, String remark) {
		super();
		this.id = id;
		this.oneMenuId = oneMenuId;
		this.twoMenuId = twoMenuId;
		this.title = title;
		this.shortTitle = shortTitle;
		this.author = author;
		this.imgUrl = imgUrl;
		this.keyword = keyword;
		this.profile = profile;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.display = display;
		this.seq = seq;
		this.click = click;
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

	public Integer getTwoMenuId() {
		return twoMenuId;
	}

	public void setTwoMenuId(Integer twoMenuId) {
		this.twoMenuId = twoMenuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
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

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SinglePage [id=" + id + ", oneMenuId=" + oneMenuId + ", twoMenuId=" + twoMenuId + ", title=" + title
				+ ", shortTitle=" + shortTitle + ", author=" + author + ", imgUrl=" + imgUrl + ", keyword=" + keyword
				+ ", profile=" + profile + ", content1=" + content1 + ", content2=" + content2 + ", content3="
				+ content3 + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", display=" + display
				+ ", seq=" + seq + ", click=" + click + ", remark=" + remark + "]";
	}
}
