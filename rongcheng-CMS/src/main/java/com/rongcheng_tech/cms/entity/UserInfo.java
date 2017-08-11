package com.rongcheng_tech.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = -1898305085636281742L;
	//用户id
	private Long id;
	//用户头像
	private String userPortrait;
	//用户账户
	private String accountNum;
	//账户密码
	private String userPassword;
	//账户新密码
	private String userNewPassword;
	//数字证书
	private String digitalCertificate;
	//密码找回验证邮箱
	private String accountEmail;
	//用户类型
	private Byte userType;
	//用户昵称
	private String userNickname;
	//用户姓名
	private String userName;
	//用户电话
	private String userTelephone;
	//用户手机
	private String userMobile;
	//用户地址
	private String userAddress;
	//账户状态
	private Byte accountStatus;
	//用户设置的问题1
	private String userQuestion1;
	//用户设置的答案1
	private String userAnswer1;
	//用户设置的问题2
	private String userQuestion2;
	//用户设置的答案2
	private String userAnswer2;
	//用户设置的问题3
	private String userQuestion3;
	//用户设置的答案3
	private String userAnswer3;
	//账户角色
	private Integer roleId;
	//账户补充权限
	private Integer authorityId;
	//自定义内容1
	private String reserved1;
	//备注
	private String note;
	//用户主账户ID
	private Long ownerId;
	//操作人
	private Long operatorId;
	//是否管理员账号
	private Boolean admin;
	//是否主账号（或所有者）
	private Boolean rootAccount;
	//该账户是否已被应用或调用
	private Boolean apply;
	//记录创建时间
	private Date gmtCreate;
	//记录修改时间
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait == null ? null : userPortrait.trim();
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum == null ? null : accountNum.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public String getUserNewPassword() {
		return userNewPassword;
	}

	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}

	public String getDigitalCertificate() {
		return digitalCertificate;
	}

	public void setDigitalCertificate(String digitalCertificate) {
		this.digitalCertificate = digitalCertificate == null ? null : digitalCertificate.trim();
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail == null ? null : accountEmail.trim();
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone == null ? null : userTelephone.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}


	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Byte getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Byte accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getUserQuestion1() {
		return userQuestion1;
	}

	public void setUserQuestion1(String userQuestion1) {
		this.userQuestion1 = userQuestion1 == null ? null : userQuestion1.trim();
	}

	public String getUserAnswer1() {
		return userAnswer1;
	}

	public void setUserAnswer1(String userAnswer1) {
		this.userAnswer1 = userAnswer1 == null ? null : userAnswer1.trim();
	}

	public String getUserQuestion2() {
		return userQuestion2;
	}

	public void setUserQuestion2(String userQuestion2) {
		this.userQuestion2 = userQuestion2 == null ? null : userQuestion2.trim();
	}

	public String getUserAnswer2() {
		return userAnswer2;
	}

	public void setUserAnswer2(String userAnswer2) {
		this.userAnswer2 = userAnswer2 == null ? null : userAnswer2.trim();
	}

	public String getUserQuestion3() {
		return userQuestion3;
	}

	public void setUserQuestion3(String userQuestion3) {
		this.userQuestion3 = userQuestion3 == null ? null : userQuestion3.trim();
	}

	public String getUserAnswer3() {
		return userAnswer3;
	}

	public void setUserAnswer3(String userAnswer3) {
		this.userAnswer3 = userAnswer3 == null ? null : userAnswer3.trim();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1 == null ? null : reserved1.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
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

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getRootAccount() {
		return rootAccount;
	}

	public void setRootAccount(Boolean rootAccount) {
		this.rootAccount = rootAccount;
	}

	public Boolean getApply() {
		return apply;
	}

	public void setApply(Boolean apply) {
		this.apply = apply;
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

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public UserInfo clone() {   
        try {   
            return (UserInfo) super.clone();   
        } catch (CloneNotSupportedException e) {   
            return null;   
        }   
    }  
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userPortrait=" + userPortrait + ", accountNum=" + accountNum
				+ ", userPassword=" + userPassword + ", userNewPassword=" + userNewPassword + ", digitalCertificate="
				+ digitalCertificate + ", accountEmail=" + accountEmail + ", userType=" + userType + ", userNickname="
				+ userNickname + ", userName=" + userName + ", userTelephone=" + userTelephone + ", userMobile="
				+ userMobile + ", userAddress=" + userAddress + ", accountStatus=" + accountStatus + ", userQuestion1="
				+ userQuestion1 + ", userAnswer1=" + userAnswer1 + ", userQuestion2=" + userQuestion2 + ", userAnswer2="
				+ userAnswer2 + ", userQuestion3=" + userQuestion3 + ", userAnswer3=" + userAnswer3 + ", roleId="
				+ roleId + ", authorityId=" + authorityId + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId="
				+ ownerId + ", operatorId=" + operatorId + ", admin=" + admin + ", rootAccount=" + rootAccount
				+ ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

}