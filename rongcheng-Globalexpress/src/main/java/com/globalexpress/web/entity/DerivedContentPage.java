package com.globalexpress.web.entity;

import java.util.Date;

public class DerivedContentPage {
    private Long id;

    private String contentTitle;

    private String contentSubtitle;

    private String contentEnTitle;

    private String interfaceName;

    private String contentProfile;

    private String author;

    private Integer click;

    private String contentLabel;

    private String contentKeyword;

    private String iconUrl;

    private String iconDirectLink;

    private Integer userSequence;

    private Long parentId;

    private Boolean show;

    private String reserved1;

    private String note;

    private Long ownerId;

    private Long operatorId;

    private Boolean authorization;

    private Boolean apply;

    private Date gmtCreate;

    private Date gmtModified;

    private String content1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle == null ? null : contentTitle.trim();
    }

    public String getContentSubtitle() {
        return contentSubtitle;
    }

    public void setContentSubtitle(String contentSubtitle) {
        this.contentSubtitle = contentSubtitle == null ? null : contentSubtitle.trim();
    }

    public String getContentEnTitle() {
        return contentEnTitle;
    }

    public void setContentEnTitle(String contentEnTitle) {
        this.contentEnTitle = contentEnTitle == null ? null : contentEnTitle.trim();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getContentProfile() {
        return contentProfile;
    }

    public void setContentProfile(String contentProfile) {
        this.contentProfile = contentProfile == null ? null : contentProfile.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getContentLabel() {
        return contentLabel;
    }

    public void setContentLabel(String contentLabel) {
        this.contentLabel = contentLabel == null ? null : contentLabel.trim();
    }

    public String getContentKeyword() {
        return contentKeyword;
    }

    public void setContentKeyword(String contentKeyword) {
        this.contentKeyword = contentKeyword == null ? null : contentKeyword.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getIconDirectLink() {
        return iconDirectLink;
    }

    public void setIconDirectLink(String iconDirectLink) {
        this.iconDirectLink = iconDirectLink == null ? null : iconDirectLink.trim();
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1 == null ? null : content1.trim();
    }

	@Override
	public String toString() {
		return "DerivedContentPage [id=" + id + ", contentTitle=" + contentTitle + ", contentSubtitle="
				+ contentSubtitle + ", contentEnTitle=" + contentEnTitle + ", interfaceName=" + interfaceName
				+ ", contentProfile=" + contentProfile + ", author=" + author + ", click=" + click + ", contentLabel="
				+ contentLabel + ", contentKeyword=" + contentKeyword + ", iconUrl=" + iconUrl + ", iconDirectLink="
				+ iconDirectLink + ", userSequence=" + userSequence + ", parentId=" + parentId + ", show=" + show
				+ ", reserved1=" + reserved1 + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId
				+ ", authorization=" + authorization + ", apply=" + apply + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + ", content1=" + content1 + "]";
	}
    
}