package com.rongcheng.rcb.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 8954150560659786410L;
	
	private Integer id;			//（10）（无符号型自增id）
	private String name; 		//（50） 用户名
	private String account; 	//（50） 账号（非空且唯一）
	private String password;	//（50） 密码（非空）
	private Byte enable; 		//（3） 是否启用此帐号（默认0。0：不启用，1：启用）
	private Byte rootAdmin; 	//（3） 是否是最高权限管理员（默认0。0：否，1：是）
	private String tel; 		//（20） 电话
	private String email; 		//（100） 邮箱
	private String remark; 		//（200） 备注

	public User() {
	}

	public User(Integer id, String name, String account, String password, Byte enable, Byte rootAdmin, String tel,
			String email, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.enable = enable;
		this.rootAdmin = rootAdmin;
		this.tel = tel;
		this.email = email;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getEnable() {
		return enable;
	}

	public void setEnable(Byte enable) {
		this.enable = enable;
	}

	public Byte getRootAdmin() {
		return rootAdmin;
	}

	public void setRootAdmin(Byte rootAdmin) {
		this.rootAdmin = rootAdmin;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", enable="
				+ enable + ", rootAdmin=" + rootAdmin + ", tel=" + tel + ", email=" + email + ", remark=" + remark
				+ "]";
	}
}
