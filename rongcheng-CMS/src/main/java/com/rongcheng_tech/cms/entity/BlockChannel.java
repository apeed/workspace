package com.rongcheng_tech.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 栏目通道管理表 实体类
 * 
 * <p>栏目表在JAVA层的具体对象。
 * @author 赵滨
 *
 */
public class BlockChannel implements Serializable{
    
    //序列号
    private static final long serialVersionUID = 4751805442925978467L;

    //定义实体类参数
    
    //记录编号ID
    private Long id;
    
    //栏目标题
    private String blockTitle;
    
    //栏目子标题
    private String blockSubtitle;

    //栏目英文标题
    private String enTitle;

    //接口显示名称
    private String interfaceName;

    //栏目简介（摘要）
    private String blockProfile;

    //栏目标签
    private String blockLabel;

    //栏目关键字
    private String blockKeyword;

    //缩略图地址
    private String iconUrl;

    //点击缩略图的跳转地址
    private String iconDirectLink;

    //点击量
    private Integer click;

    //父类id
    private Long parentId;

    //该条记录类型
    private Integer recordType;

    //用户自定义排序号
    private Integer userSequence;

    //是否显示
    private Boolean show;

    //自定义内容1
    private String reserved1;

    //备注
    private String note;

    //用户主账户ID
    private Long ownerId;

    //操作人ID
    private Long operatorId;

    //该记录是否被授权
    private Boolean authorization;

    //该记录是否已被应用或调用
    private Boolean apply;

    //记录创建时间
    private Date gmtCreate;

    //记录修改时间
    private Date gmtModified;

    /**
     * 栏目通道管理表 无参数的构造器
     */
    public BlockChannel() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 栏目通道管理表 有参数的构造器
     */
    public BlockChannel(Long id, String blockTitle, String blockSubtitle, String enTitle, String interfaceName,
            String blockProfile, String blockLabel, String blockKeyword, String iconUrl, String iconDirectLink,
            Integer click, Long parentId, Integer recordType, Integer userSequence, Boolean show, String reserved1,
            String note, Long ownerId, Long operatorId, Boolean authorization, Boolean apply, Date gmtCreate,
            Date gmtModified) {
        super();
        this.id = id;
        this.blockTitle = blockTitle;
        this.blockSubtitle = blockSubtitle;
        this.enTitle = enTitle;
        this.interfaceName = interfaceName;
        this.blockProfile = blockProfile;
        this.blockLabel = blockLabel;
        this.blockKeyword = blockKeyword;
        this.iconUrl = iconUrl;
        this.iconDirectLink = iconDirectLink;
        this.click = click;
        this.parentId = parentId;
        this.recordType = recordType;
        this.userSequence = userSequence;
        this.show = show;
        this.reserved1 = reserved1;
        this.note = note;
        this.ownerId = ownerId;
        this.operatorId = operatorId;
        this.authorization = authorization;
        this.apply = apply;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    //创建的setter和getter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public String getBlockSubtitle() {
        return blockSubtitle;
    }

    public void setBlockSubtitle(String blockSubtitle) {
        this.blockSubtitle = blockSubtitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getBlockProfile() {
        return blockProfile;
    }

    public void setBlockProfile(String blockProfile) {
        this.blockProfile = blockProfile;
    }

    public String getBlockLabel() {
        return blockLabel;
    }

    public void setBlockLabel(String blockLabel) {
        this.blockLabel = blockLabel;
    }

    public String getBlockKeyword() {
        return blockKeyword;
    }

    public void setBlockKeyword(String blockKeyword) {
        this.blockKeyword = blockKeyword;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconDirectLink() {
        return iconDirectLink;
    }

    public void setIconDirectLink(String iconDirectLink) {
        this.iconDirectLink = iconDirectLink;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
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

    /**
     * 栏目通道管理表 重写hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apply == null) ? 0 : apply.hashCode());
        result = prime * result + ((authorization == null) ? 0 : authorization.hashCode());
        result = prime * result + ((blockKeyword == null) ? 0 : blockKeyword.hashCode());
        result = prime * result + ((blockLabel == null) ? 0 : blockLabel.hashCode());
        result = prime * result + ((blockProfile == null) ? 0 : blockProfile.hashCode());
        result = prime * result + ((blockSubtitle == null) ? 0 : blockSubtitle.hashCode());
        result = prime * result + ((blockTitle == null) ? 0 : blockTitle.hashCode());
        result = prime * result + ((click == null) ? 0 : click.hashCode());
        result = prime * result + ((enTitle == null) ? 0 : enTitle.hashCode());
        result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
        result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
        result = prime * result + ((iconDirectLink == null) ? 0 : iconDirectLink.hashCode());
        result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((interfaceName == null) ? 0 : interfaceName.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
        result = prime * result + ((reserved1 == null) ? 0 : reserved1.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
        result = prime * result + ((userSequence == null) ? 0 : userSequence.hashCode());
        return result;
    }

    /**
     * 栏目通道管理表 重写equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BlockChannel other = (BlockChannel) obj;
        if (apply == null) {
            if (other.apply != null)
                return false;
        } else if (!apply.equals(other.apply))
            return false;
        if (authorization == null) {
            if (other.authorization != null)
                return false;
        } else if (!authorization.equals(other.authorization))
            return false;
        if (blockKeyword == null) {
            if (other.blockKeyword != null)
                return false;
        } else if (!blockKeyword.equals(other.blockKeyword))
            return false;
        if (blockLabel == null) {
            if (other.blockLabel != null)
                return false;
        } else if (!blockLabel.equals(other.blockLabel))
            return false;
        if (blockProfile == null) {
            if (other.blockProfile != null)
                return false;
        } else if (!blockProfile.equals(other.blockProfile))
            return false;
        if (blockSubtitle == null) {
            if (other.blockSubtitle != null)
                return false;
        } else if (!blockSubtitle.equals(other.blockSubtitle))
            return false;
        if (blockTitle == null) {
            if (other.blockTitle != null)
                return false;
        } else if (!blockTitle.equals(other.blockTitle))
            return false;
        if (click == null) {
            if (other.click != null)
                return false;
        } else if (!click.equals(other.click))
            return false;
        if (enTitle == null) {
            if (other.enTitle != null)
                return false;
        } else if (!enTitle.equals(other.enTitle))
            return false;
        if (gmtCreate == null) {
            if (other.gmtCreate != null)
                return false;
        } else if (!gmtCreate.equals(other.gmtCreate))
            return false;
        if (gmtModified == null) {
            if (other.gmtModified != null)
                return false;
        } else if (!gmtModified.equals(other.gmtModified))
            return false;
        if (iconDirectLink == null) {
            if (other.iconDirectLink != null)
                return false;
        } else if (!iconDirectLink.equals(other.iconDirectLink))
            return false;
        if (iconUrl == null) {
            if (other.iconUrl != null)
                return false;
        } else if (!iconUrl.equals(other.iconUrl))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (interfaceName == null) {
            if (other.interfaceName != null)
                return false;
        } else if (!interfaceName.equals(other.interfaceName))
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (operatorId == null) {
            if (other.operatorId != null)
                return false;
        } else if (!operatorId.equals(other.operatorId))
            return false;
        if (ownerId == null) {
            if (other.ownerId != null)
                return false;
        } else if (!ownerId.equals(other.ownerId))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        if (recordType == null) {
            if (other.recordType != null)
                return false;
        } else if (!recordType.equals(other.recordType))
            return false;
        if (reserved1 == null) {
            if (other.reserved1 != null)
                return false;
        } else if (!reserved1.equals(other.reserved1))
            return false;
        if (show == null) {
            if (other.show != null)
                return false;
        } else if (!show.equals(other.show))
            return false;
        if (userSequence == null) {
            if (other.userSequence != null)
                return false;
        } else if (!userSequence.equals(other.userSequence))
            return false;
        return true;
    }

    /**
     * 栏目通道管理表 重写toString
     */
    @Override
    public String toString() {
        return "BlockChannel [id=" + id + ", blockTitle=" + blockTitle + ", blockSubtitle=" + blockSubtitle
                + ", enTitle=" + enTitle + ", interfaceName=" + interfaceName + ", blockProfile=" + blockProfile
                + ", blockLabel=" + blockLabel + ", blockKeyword=" + blockKeyword + ", iconUrl=" + iconUrl
                + ", iconDirectLink=" + iconDirectLink + ", click=" + click + ", parentId=" + parentId + ", recordType="
                + recordType + ", userSequence=" + userSequence + ", show=" + show + ", reserved1=" + reserved1
                + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorization="
                + authorization + ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
                + "]";
    }

}