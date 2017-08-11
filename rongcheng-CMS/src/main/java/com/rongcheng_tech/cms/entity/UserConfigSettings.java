package com.rongcheng_tech.cms.entity;

import java.util.Date;

public class UserConfigSettings {
    private Long id;

    private String parameterName;

    private String parameterValue1;

    private String parameterValue2;

    private String parameterValue3;

    private String reserved1;

    private String note;

    private Long ownerId;

    private Long operatorId;

    private Date gmtCreate;

    private Date gmtModified;

    
    public UserConfigSettings() {
		super();
	}

	public UserConfigSettings(Long ownerId) {
		super();
		this.ownerId = ownerId;
	}

	public UserConfigSettings(String parameterName, Long ownerId) {
		super();
		this.parameterName = parameterName;
		this.ownerId = ownerId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName == null ? null : parameterName.trim();
    }

    public String getParameterValue1() {
        return parameterValue1;
    }

    public void setParameterValue1(String parameterValue1) {
        this.parameterValue1 = parameterValue1 == null ? null : parameterValue1.trim();
    }

    public String getParameterValue2() {
        return parameterValue2;
    }

    public void setParameterValue2(String parameterValue2) {
        this.parameterValue2 = parameterValue2 == null ? null : parameterValue2.trim();
    }

    public String getParameterValue3() {
        return parameterValue3;
    }

    public void setParameterValue3(String parameterValue3) {
        this.parameterValue3 = parameterValue3 == null ? null : parameterValue3.trim();
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

	@Override
	public String toString() {
		return "UserConfigSettings [id=" + id + ", parameterName=" + parameterName + ", parameterValue1="
				+ parameterValue1 + ", parameterValue2=" + parameterValue2 + ", parameterValue3=" + parameterValue3
				+ ", reserved1=" + reserved1 + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
    
}