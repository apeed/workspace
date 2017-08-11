package com.rongcheng_tech.cms.entity;

import java.util.Date;

public class UserRemark {
    private Long id;

    private Long contentId;//留言所在内容页面
    
    private Byte contentType;//内容类型

    private String userAccount;//用户账户

    private String userName;//用户姓名

    private String userTel;//用户电话

    private String userEmail;//用户邮箱
    
    private String userWord;//留言或评论内容

    private Date userWordTime;//留言或评论时间
    
    private String adminReply;//客服回复内容

    private Date replyTime;//客服回复时间

    private Integer userSequence;//用户自定义顺序号
    
    private Integer remarkType;//评论类型
    
    private Boolean reply;//是否回复

    private Boolean show;//是否显示

    private String reserved1;//自定义内容

    private String note;//备注

    private Long ownerId;//用户主账户ID

    private Long operatorId;//操作人

    private Boolean authorization;//该记录是否被授权

    private Date gmtCreate;//记录创建时间

    private Date gmtModified;//记录修改时间
    
    private Long userId;//用户编号
    public UserRemark() {
		
	}
	public UserRemark(Long id, Long contentId, Byte contentType, String userAccount, String userName, String userTel,
			String userEmail, String userWord, Date userWordTime, String adminReply, Date replyTime,
			Integer userSequence, Integer remarkType, Boolean reply, Boolean show, String reserved1, String note,
			Long ownerId, Long operatorId, Boolean authorization, Date gmtCreate, Date gmtModified, Long userId) {
		super();
		this.id = id;
		this.contentId = contentId;
		this.contentType = contentType;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userWord = userWord;
		this.userWordTime = userWordTime;
		this.adminReply = adminReply;
		this.replyTime = replyTime;
		this.userSequence = userSequence;
		this.remarkType = remarkType;
		this.reply = reply;
		this.show = show;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.operatorId = operatorId;
		this.authorization = authorization;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public Byte getContentType() {
		return contentType;
	}
	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserWord() {
		return userWord;
	}
	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}
	public Date getUserWordTime() {
		return userWordTime;
	}
	public void setUserWordTime(Date userWordTime) {
		this.userWordTime = userWordTime;
	}
	public String getAdminReply() {
		return adminReply;
	}
	public void setAdminReply(String adminReply) {
		this.adminReply = adminReply;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Integer getUserSequence() {
		return userSequence;
	}
	public void setUserSequence(Integer userSequence) {
		this.userSequence = userSequence;
	}
	public Integer getRemarkType() {
		return remarkType;
	}
	public void setRemarkType(Integer remarkType) {
		this.remarkType = remarkType;
	}
	public Boolean getReply() {
		return reply;
	}
	public void setReply(Boolean reply) {
		this.reply = reply;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Boolean getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Boolean authorization) {
		this.authorization = authorization;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserRemark [id=" + id + ", contentId=" + contentId + ", contentType=" + contentType + ", userAccount="
				+ userAccount + ", userName=" + userName + ", userTel=" + userTel + ", userEmail=" + userEmail
				+ ", userWord=" + userWord + ", userWordTime=" + userWordTime + ", adminReply=" + adminReply
				+ ", replyTime=" + replyTime + ", userSequence=" + userSequence + ", remarkType=" + remarkType
				+ ", reply=" + reply + ", show=" + show + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId="
				+ ownerId + ", operatorId=" + operatorId + ", authorization=" + authorization + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRemark other = (UserRemark) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    

    
}