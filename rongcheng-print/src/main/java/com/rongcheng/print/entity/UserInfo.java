package com.rongcheng.print.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
/**
 * erp账号用户信息表
 * @author 赵滨
 *
 */
public class UserInfo implements Serializable{
    
    //版本号
    private static final long serialVersionUID = 3267766318450583865L;

    //1.子账号用户id  非空  非负  长度20
    private BigInteger id;
    
    //2.用户昵称  长度20
    private String nickname;
    
    //3.用户姓名  长度10
    private String name;
    
    //4.用户电话  长度30
    private String telephone;
    
    //5.用户手机  长度30
    private String mobile;
    
    //6.用户所在地区id  非负  长度20
    private BigInteger regionId;
    
    //7.自定义内容1  长度30
    private String reserved1;
    
    //8.备注  长度100
    private String note;
    
    //9.用户主账户ID  非空  非负  长度20  数据表所有者
    private BigInteger ownerId;
    
    //10.操作人  非空  非负  长度20
    private BigInteger operatorId;
    
    //11.是否管理员账号  非空  非负  长度1
    private Integer admin;
    
    //12.是否主账号（或所有者）  非空  非负  长度1
    private Integer rootAccount;
    
    //13.记录创建时间  非空  datetime
    private Timestamp gmtCreate;
    
    //14.记录修改时间  datetime
    private Timestamp gmtModified;
    //15.用户账户
    private String accountNum;
    //16.数字证书
    private String digitalCertificate;
    //17.账户状态
    private Integer accountStatus;
    //18.账户角色
    private Integer roleId;
    //19.账户补充权限
    private Integer authorityId;
    //20.账户密码
    private String password;
    //20.账户邮箱
    private String email;
    //无参数的构造器
    public UserInfo() {
        super();
    }

	  //有参数的构造器
	public UserInfo(BigInteger id, String nickname, String name, String telephone, String mobile, BigInteger regionId,
			String reserved1, String note, BigInteger ownerId, BigInteger operatorId, Integer admin,
			Integer rootAccount, Timestamp gmtCreate, Timestamp gmtModified, String accountNum,
			String digitalCertificate, Integer accountStatus, Integer roleId, Integer authorityId, String password,
			String email) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.telephone = telephone;
		this.mobile = mobile;
		this.regionId = regionId;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.operatorId = operatorId;
		this.admin = admin;
		this.rootAccount = rootAccount;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.accountNum = accountNum;
		this.digitalCertificate = digitalCertificate;
		this.accountStatus = accountStatus;
		this.roleId = roleId;
		this.authorityId = authorityId;
		this.password = password;
		this.email = email;
	}
	 //重写equals hashCode
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
		UserInfo other = (UserInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 //创建的setter和getter方法
	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public BigInteger getRegionId() {
		return regionId;
	}


	public void setRegionId(BigInteger regionId) {
		this.regionId = regionId;
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


	public BigInteger getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(BigInteger ownerId) {
		this.ownerId = ownerId;
	}


	public BigInteger getOperatorId() {
		return operatorId;
	}


	public void setOperatorId(BigInteger operatorId) {
		this.operatorId = operatorId;
	}


	public Integer getAdmin() {
		return admin;
	}


	public void setAdmin(Integer admin) {
		this.admin = admin;
	}


	public Integer getRootAccount() {
		return rootAccount;
	}


	public void setRootAccount(Integer rootAccount) {
		this.rootAccount = rootAccount;
	}


	public Timestamp getGmtCreate() {
		return gmtCreate;
	}


	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}


	public Timestamp getGmtModified() {
		return gmtModified;
	}


	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}


	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public String getDigitalCertificate() {
		return digitalCertificate;
	}


	public void setDigitalCertificate(String digitalCertificate) {
		this.digitalCertificate = digitalCertificate;
	}


	public Integer getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	//重写toString
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", nickname=" + nickname + ", name=" + name + ", telephone=" + telephone
				+ ", mobile=" + mobile + ", regionId=" + regionId + ", reserved1=" + reserved1 + ", note=" + note
				+ ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", admin=" + admin + ", rootAccount="
				+ rootAccount + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", accountNum="
				+ accountNum + ", digitalCertificate=" + digitalCertificate + ", accountStatus=" + accountStatus
				+ ", roleId=" + roleId + ", authorityId=" + authorityId + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
}
