package com.globalexpress.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户访客信息表 实体类
 * 
 * <p>用户访客信息表在JAVA层的具体对象。
 * @author 赵滨
 *
 */
public class VipUser implements Serializable{

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1695694540950534358L;

    //记录编号ID
    private Long id;
    
    //用户账号
    private String vipCode;
    
    //用户类型
    private Integer vipType;
    
    //用户服务IP
    private Integer vipIp;
    
    //用户域名
    private String vipLink;
    
    //用户联系人
    private String contactName;
    
    //用户手机
    private Long contactMobile;
    
    //用户固定电话
    private Long contactTel;
    
    //用户邮箱
    private String contactEmail;
    
    //用户地址
    private String contactAddress;
    
    //用户qq
    private Long contactQq;
    
    //用户微信
    private String contactWechat;
    
    //联系情况记录
    private String contactRecord;
    
    //是否协商达成一致解决
    private Boolean solved;
    
    //父类用户id
    private String parentVip;
    
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
    
    //操作人
    private Long operatorId;
    
    //该记录是否已被应用或调用
    private Boolean apply;
    
    //记录创建时间
    private Timestamp gmtCreate;
    
    //记录修改时间
    private Timestamp gmtModified;

    /**
     * 用户访客信息表 无参数的构造器
     */
    public VipUser() {
        super();
    }

    /**
     * 用户访客信息表 有参数的构造器
     */
    public VipUser(Long id, String vipCode, Integer vipType, Integer vipIp, String vipLink, String contactName,
            Long contactMobile, Long contactTel, String contactEmail, String contactAddress, Long contactQq,
            String contactWechat, String contactRecord, Boolean solved, String parentVip, Integer userSequence,
            Boolean show, String reserved1, String note, Long ownerId, Long operatorId, Boolean apply,
            Timestamp gmtCreate, Timestamp gmtModified) {
        super();
        this.id = id;
        this.vipCode = vipCode;
        this.vipType = vipType;
        this.vipIp = vipIp;
        this.vipLink = vipLink;
        this.contactName = contactName;
        this.contactMobile = contactMobile;
        this.contactTel = contactTel;
        this.contactEmail = contactEmail;
        this.contactAddress = contactAddress;
        this.contactQq = contactQq;
        this.contactWechat = contactWechat;
        this.contactRecord = contactRecord;
        this.solved = solved;
        this.parentVip = parentVip;
        this.userSequence = userSequence;
        this.show = show;
        this.reserved1 = reserved1;
        this.note = note;
        this.ownerId = ownerId;
        this.operatorId = operatorId;
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

    public String getVipCode() {
        return vipCode;
    }

    public void setVipCode(String vipCode) {
        this.vipCode = vipCode;
    }

    public Integer getVipType() {
        return vipType;
    }

    public void setVipType(Integer vipType) {
        this.vipType = vipType;
    }

    public Integer getVipIp() {
        return vipIp;
    }

    public void setVipIp(Integer vipIp) {
        this.vipIp = vipIp;
    }

    public String getVipLink() {
        return vipLink;
    }

    public void setVipLink(String vipLink) {
        this.vipLink = vipLink;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Long getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(Long contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Long getContactTel() {
        return contactTel;
    }

    public void setContactTel(Long contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Long getContactQq() {
        return contactQq;
    }

    public void setContactQq(Long contactQq) {
        this.contactQq = contactQq;
    }

    public String getContactWechat() {
        return contactWechat;
    }

    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat;
    }

    public String getContactRecord() {
        return contactRecord;
    }

    public void setContactRecord(String contactRecord) {
        this.contactRecord = contactRecord;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    public String getParentVip() {
        return parentVip;
    }

    public void setParentVip(String parentVip) {
        this.parentVip = parentVip;
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
    
    /**
     * 用户访客信息表 重写hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apply == null) ? 0 : apply.hashCode());
        result = prime * result + ((contactAddress == null) ? 0 : contactAddress.hashCode());
        result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
        result = prime * result + ((contactMobile == null) ? 0 : contactMobile.hashCode());
        result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
        result = prime * result + ((contactQq == null) ? 0 : contactQq.hashCode());
        result = prime * result + ((contactRecord == null) ? 0 : contactRecord.hashCode());
        result = prime * result + ((contactTel == null) ? 0 : contactTel.hashCode());
        result = prime * result + ((contactWechat == null) ? 0 : contactWechat.hashCode());
        result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
        result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((parentVip == null) ? 0 : parentVip.hashCode());
        result = prime * result + ((reserved1 == null) ? 0 : reserved1.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
        result = prime * result + ((solved == null) ? 0 : solved.hashCode());
        result = prime * result + ((userSequence == null) ? 0 : userSequence.hashCode());
        result = prime * result + ((vipCode == null) ? 0 : vipCode.hashCode());
        result = prime * result + ((vipIp == null) ? 0 : vipIp.hashCode());
        result = prime * result + ((vipLink == null) ? 0 : vipLink.hashCode());
        result = prime * result + ((vipType == null) ? 0 : vipType.hashCode());
        return result;
    }

    /**
     * 用户访客信息表 重写equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VipUser other = (VipUser) obj;
        if (apply == null) {
            if (other.apply != null)
                return false;
        } else if (!apply.equals(other.apply))
            return false;
        if (contactAddress == null) {
            if (other.contactAddress != null)
                return false;
        } else if (!contactAddress.equals(other.contactAddress))
            return false;
        if (contactEmail == null) {
            if (other.contactEmail != null)
                return false;
        } else if (!contactEmail.equals(other.contactEmail))
            return false;
        if (contactMobile == null) {
            if (other.contactMobile != null)
                return false;
        } else if (!contactMobile.equals(other.contactMobile))
            return false;
        if (contactName == null) {
            if (other.contactName != null)
                return false;
        } else if (!contactName.equals(other.contactName))
            return false;
        if (contactQq == null) {
            if (other.contactQq != null)
                return false;
        } else if (!contactQq.equals(other.contactQq))
            return false;
        if (contactRecord == null) {
            if (other.contactRecord != null)
                return false;
        } else if (!contactRecord.equals(other.contactRecord))
            return false;
        if (contactTel == null) {
            if (other.contactTel != null)
                return false;
        } else if (!contactTel.equals(other.contactTel))
            return false;
        if (contactWechat == null) {
            if (other.contactWechat != null)
                return false;
        } else if (!contactWechat.equals(other.contactWechat))
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
        if (parentVip == null) {
            if (other.parentVip != null)
                return false;
        } else if (!parentVip.equals(other.parentVip))
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
        if (solved == null) {
            if (other.solved != null)
                return false;
        } else if (!solved.equals(other.solved))
            return false;
        if (userSequence == null) {
            if (other.userSequence != null)
                return false;
        } else if (!userSequence.equals(other.userSequence))
            return false;
        if (vipCode == null) {
            if (other.vipCode != null)
                return false;
        } else if (!vipCode.equals(other.vipCode))
            return false;
        if (vipIp == null) {
            if (other.vipIp != null)
                return false;
        } else if (!vipIp.equals(other.vipIp))
            return false;
        if (vipLink == null) {
            if (other.vipLink != null)
                return false;
        } else if (!vipLink.equals(other.vipLink))
            return false;
        if (vipType == null) {
            if (other.vipType != null)
                return false;
        } else if (!vipType.equals(other.vipType))
            return false;
        return true;
    }


    /**
     * 用户访客信息表 重写toString
     */ 
    @Override
    public String toString() {
        return "VipUser [id=" + id + ", vipCode=" + vipCode + ", vipType=" + vipType + ", vipIp=" + vipIp + ", vipLink="
                + vipLink + ", contactName=" + contactName + ", contactMobile=" + contactMobile + ", contactTel="
                + contactTel + ", contactEmail=" + contactEmail + ", contactAddress=" + contactAddress + ", contactQq="
                + contactQq + ", contactWechat=" + contactWechat + ", contactRecord=" + contactRecord + ", solved="
                + solved + ", parentVip=" + parentVip + ", userSequence=" + userSequence + ", show=" + show
                + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId
                + ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
    
}
