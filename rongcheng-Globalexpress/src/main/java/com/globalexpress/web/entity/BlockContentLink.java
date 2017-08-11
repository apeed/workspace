package com.globalexpress.web.entity;

import java.util.Date;

public class BlockContentLink {
    private Long id;

    private Byte blockType;
    
    private Long blockId;

    private Byte contentType;
    
    private Long contentId;

    private String reserved1;

    private String note;

    private Long ownerId;

    private Long operatorId;

    private Boolean authorization;

    private Boolean apply;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
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

    public Boolean getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Boolean authorization) {
        this.authorization = authorization;
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

	public Byte getBlockType() {
		return blockType;
	}

	public void setBlockType(Byte blockType) {
		this.blockType = blockType;
	}

	public Byte getContentType() {
		return contentType;
	}

	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "BlockContentLink [id=" + id + ", blockType=" + blockType + ", blockId=" + blockId + ", contentType="
				+ contentType + ", contentId=" + contentId + ", reserved1=" + reserved1 + ", note=" + note
				+ ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorization=" + authorization
				+ ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
    
}