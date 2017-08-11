package com.rongcheng.rcb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class LeaveMessage implements Serializable {

	private static final long serialVersionUID = 8954150560659786410L;
	
	private Integer id;				//（10）（无符号型自增id）
	private String name; 			//（50） 留言人
	private String tel; 			//（20） 手机号
	private String email; 			//（100） 邮箱
	private String content;			//（500） 留言内容
	private Timestamp creatTime; 	// 留言时间（默认当前时间）
	private String reply; 			//（500） 回复内容
	private Timestamp replyTime;	// 回复时间
	private Byte display; 				//（3） 是否显示（默认1。0：不显示，1：显示。）
	private Byte seq; 				//（3） 排序（默认100，取值0-255，值越小越靠前）
	private String remark; 			//（200） 备注

	public LeaveMessage() {
	}

	public LeaveMessage(Integer id, String name, String tel, String email, String content, Timestamp creatTime,
			String reply, Timestamp replyTime, Byte display, Byte seq, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.content = content;
		this.creatTime = creatTime;
		this.reply = reply;
		this.replyTime = replyTime;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
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
		return "LeaveMessage [id=" + id + ", name=" + name + ", tel=" + tel + ", email=" + email + ", content="
				+ content + ", creatTime=" + creatTime + ", reply=" + reply + ", replyTime=" + replyTime + ", display="
				+ display + ", seq=" + seq + ", remark=" + remark + "]";
	}
}
