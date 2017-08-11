package com.globalexpress.web.entity;

import java.util.Date;

public class MediaInfo {
    private Long id;

    private String mediaName;

    private String interfaceName;

    private String iconUrl;

    private String iconDirectLink;

    private String mediaLabel;

    private String mediaKeyword;

    private String mediaUrl;

    private String wordDesign;

    private String mediaDirectLink;

    private Byte mediaType;

    private Long parentId;

    private Integer userSequence;

    private Boolean show;

    private Integer click;

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

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
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

    public String getMediaLabel() {
        return mediaLabel;
    }

    public void setMediaLabel(String mediaLabel) {
        this.mediaLabel = mediaLabel == null ? null : mediaLabel.trim();
    }

    public String getMediaKeyword() {
        return mediaKeyword;
    }

    public void setMediaKeyword(String mediaKeyword) {
        this.mediaKeyword = mediaKeyword == null ? null : mediaKeyword.trim();
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    public String getWordDesign() {
        return wordDesign;
    }

    public void setWordDesign(String wordDesign) {
        this.wordDesign = wordDesign == null ? null : wordDesign.trim();
    }

    public String getMediaDirectLink() {
        return mediaDirectLink;
    }

    public void setMediaDirectLink(String mediaDirectLink) {
        this.mediaDirectLink = mediaDirectLink == null ? null : mediaDirectLink.trim();
    }

    public Byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(Byte mediaType) {
        this.mediaType = mediaType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
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
}