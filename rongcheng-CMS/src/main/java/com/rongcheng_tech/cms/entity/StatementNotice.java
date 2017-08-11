package com.rongcheng_tech.cms.entity;

import java.sql.Timestamp;

public class StatementNotice  {
    private Long id;

    private String reserved1;//自定义内容

    private String note;//备注

    private Long ownerId;//用户主账户ID

    private Long operatorId;//操作人

    private Boolean apply;//该记录是否已被应用或调用

    private Timestamp gmtCreate;//记录创建时间

    private Timestamp gmtModified;//记录修改时间

    private String statement;//公告内容

    private String notice;//注意事项
    
    private String statementTitle;//公告名称
    
    public StatementNotice() {
		// TODO Auto-generated constructor stub
	}
	public StatementNotice(Long id, String reserved1, String note, Long ownerId, Long operatorId,
			Boolean apply, Timestamp gmtCreate, Timestamp gmtModified, String statement, String notice,
			String statementTitle) {
		super();
		this.id = id;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.operatorId = operatorId;
		this.apply = apply;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.statement = statement;
		this.notice = notice;
		this.statementTitle = statementTitle;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Boolean getApply() {
		return apply;
	}
	public void setApply(Boolean apply) {
		this.apply = apply;
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
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getStatementTitle() {
		return statementTitle;
	}
	public void setStatementTitle(String statementTitle) {
		this.statementTitle = statementTitle;
	}
	
	@Override
	public String toString() {
		return "StatementNotice [id=" + id + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId=" + ownerId
				+ ", operatorId=" + operatorId + ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + ", statement=" + statement + ", notice=" + notice + ", statementTitle=" + statementTitle
				+ "]";
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
		StatementNotice other = (StatementNotice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
   