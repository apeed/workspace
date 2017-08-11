package com.globalexpress.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 访客信息表 实体类
 * 
 * <p>访客信息表在JAVA层的具体对象。
 * @author 赵滨
 *
 */
public class VisitorInfo implements Serializable{

    /**
     * 实现序列化接口，生成序列化ID
     */
    private static final long serialVersionUID = -4461051184610095487L;

    //记录编号ID
    private Long id;
    
    //访客账号
    private String visitorAccount;
    
    //访客IP
    private Integer visitorIp;
    
    //访客主机名
    private String visitorHost;
    
    //访客位置地区
    private String visitorLocation;
    
    //宽带类型
    private Integer telecomType;
    
    //访客MAC物理地址
    private String visitorMacAddress;
    
    //访客操作系统
    private String osId;
    
    //访客操作系统版本
    private String osVersion;
    
    //访客操作系统位数
    private String osBit;
    
    //访客浏览器
    private String browserId;
    
    //访客浏览器版本
    private String browserVersion;
    
    //访客类型
    private Integer visitorType;
    
    //访客性别
    private Integer visitorGender;
    
    //访客年龄
    private Integer visitorAge;
    
    //访客层级潜力
    private Integer visitorLevel;
    
    //访客模糊归类
    private Long visitorClassId;
    
    //访客特征画像
    private String visitorLabel;
    
    //是否显示
    private Boolean show;
    
    //自定义内容
    private String reserved1;
    
    //备注
    private String note;
    
    //用户主账户ID
    private Long ownerId;
    
    //该记录操作人
    private Long operatorId;
    
    //该记录是否被授权
    private Boolean authorization;
    
    //该记录是否已被应用或调用
    private Boolean apply;
    
    //记录创建时间
    private Timestamp gmtCreate;
    
    //记录修改时间
    private Timestamp gmtModified;

    /**
     * 访客信息表 无参数的构造器
     */
    public VisitorInfo() {
        super();
    }

    /**
     * 访客信息表 有参数的构造器
     */
    public VisitorInfo(Long id, String visitorAccount, Integer visitorIp, String visitorHost, String visitorLocation,
            Integer telecomType, String visitorMacAddress, String osId, String osVersion, String osBit,
            String browserId, String browserVersion, Integer visitorType, Integer visitorGender, Integer visitorAge,
            Integer visitorLevel, Long visitorClassId, String visitorLabel, Boolean show, String reserved1, String note,
            Long ownerId, Long operatorId, Boolean authorization, Boolean apply, Timestamp gmtCreate,
            Timestamp gmtModified) {
        super();
        this.id = id;
        this.visitorAccount = visitorAccount;
        this.visitorIp = visitorIp;
        this.visitorHost = visitorHost;
        this.visitorLocation = visitorLocation;
        this.telecomType = telecomType;
        this.visitorMacAddress = visitorMacAddress;
        this.osId = osId;
        this.osVersion = osVersion;
        this.osBit = osBit;
        this.browserId = browserId;
        this.browserVersion = browserVersion;
        this.visitorType = visitorType;
        this.visitorGender = visitorGender;
        this.visitorAge = visitorAge;
        this.visitorLevel = visitorLevel;
        this.visitorClassId = visitorClassId;
        this.visitorLabel = visitorLabel;
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

    public String getVisitorAccount() {
        return visitorAccount;
    }

    public void setVisitorAccount(String visitorAccount) {
        this.visitorAccount = visitorAccount;
    }

    public Integer getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(Integer visitorIp) {
        this.visitorIp = visitorIp;
    }

    public String getVisitorLocation() {
        return visitorLocation;
    }

    public void setVisitorLocation(String visitorLocation) {
        this.visitorLocation = visitorLocation;
    }

    public Integer getTelecomType() {
        return telecomType;
    }

    public void setTelecomType(Integer telecomType) {
        this.telecomType = telecomType;
    }

    public String getVisitorMacAddress() {
        return visitorMacAddress;
    }

    public void setVisitorMacAddress(String visitorMacAddress) {
        this.visitorMacAddress = visitorMacAddress;
    }

    public Integer getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(Integer visitorType) {
        this.visitorType = visitorType;
    }

    public Integer getVisitorGender() {
        return visitorGender;
    }

    public void setVisitorGender(Integer visitorGender) {
        this.visitorGender = visitorGender;
    }

    public Integer getVisitorAge() {
        return visitorAge;
    }

    public void setVisitorAge(Integer visitorAge) {
        this.visitorAge = visitorAge;
    }

    public Integer getVisitorLevel() {
        return visitorLevel;
    }

    public void setVisitorLevel(Integer visitorLevel) {
        this.visitorLevel = visitorLevel;
    }

    public Long getVisitorClassId() {
        return visitorClassId;
    }

    public void setVisitorClassId(Long visitorClassId) {
        this.visitorClassId = visitorClassId;
    }

    public String getVisitorLabel() {
        return visitorLabel;
    }

    public void setVisitorLabel(String visitorLabel) {
        this.visitorLabel = visitorLabel;
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

    public String getVisitorHost() {
        return visitorHost;
    }

    public void setVisitorHost(String visitorHost) {
        this.visitorHost = visitorHost;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsBit() {
        return osBit;
    }

    public void setOsBit(String osBit) {
        this.osBit = osBit;
    }

    public String getBrowserId() {
        return browserId;
    }

    public void setBrowserId(String browserId) {
        this.browserId = browserId;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
    
    /**
     * 访客信息表 重写hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apply == null) ? 0 : apply.hashCode());
        result = prime * result + ((authorization == null) ? 0 : authorization.hashCode());
        result = prime * result + ((browserId == null) ? 0 : browserId.hashCode());
        result = prime * result + ((browserVersion == null) ? 0 : browserVersion.hashCode());
        result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
        result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
        result = prime * result + ((osBit == null) ? 0 : osBit.hashCode());
        result = prime * result + ((osId == null) ? 0 : osId.hashCode());
        result = prime * result + ((osVersion == null) ? 0 : osVersion.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((reserved1 == null) ? 0 : reserved1.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
        result = prime * result + ((telecomType == null) ? 0 : telecomType.hashCode());
        result = prime * result + ((visitorAccount == null) ? 0 : visitorAccount.hashCode());
        result = prime * result + ((visitorAge == null) ? 0 : visitorAge.hashCode());
        result = prime * result + ((visitorClassId == null) ? 0 : visitorClassId.hashCode());
        result = prime * result + ((visitorGender == null) ? 0 : visitorGender.hashCode());
        result = prime * result + ((visitorHost == null) ? 0 : visitorHost.hashCode());
        result = prime * result + ((visitorIp == null) ? 0 : visitorIp.hashCode());
        result = prime * result + ((visitorLabel == null) ? 0 : visitorLabel.hashCode());
        result = prime * result + ((visitorLevel == null) ? 0 : visitorLevel.hashCode());
        result = prime * result + ((visitorLocation == null) ? 0 : visitorLocation.hashCode());
        result = prime * result + ((visitorMacAddress == null) ? 0 : visitorMacAddress.hashCode());
        result = prime * result + ((visitorType == null) ? 0 : visitorType.hashCode());
        return result;
    }
    
    /**
     * 访客信息表 重写equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VisitorInfo other = (VisitorInfo) obj;
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
        if (browserId == null) {
            if (other.browserId != null)
                return false;
        } else if (!browserId.equals(other.browserId))
            return false;
        if (browserVersion == null) {
            if (other.browserVersion != null)
                return false;
        } else if (!browserVersion.equals(other.browserVersion))
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
        if (osBit == null) {
            if (other.osBit != null)
                return false;
        } else if (!osBit.equals(other.osBit))
            return false;
        if (osId == null) {
            if (other.osId != null)
                return false;
        } else if (!osId.equals(other.osId))
            return false;
        if (osVersion == null) {
            if (other.osVersion != null)
                return false;
        } else if (!osVersion.equals(other.osVersion))
            return false;
        if (ownerId == null) {
            if (other.ownerId != null)
                return false;
        } else if (!ownerId.equals(other.ownerId))
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
        if (telecomType == null) {
            if (other.telecomType != null)
                return false;
        } else if (!telecomType.equals(other.telecomType))
            return false;
        if (visitorAccount == null) {
            if (other.visitorAccount != null)
                return false;
        } else if (!visitorAccount.equals(other.visitorAccount))
            return false;
        if (visitorAge == null) {
            if (other.visitorAge != null)
                return false;
        } else if (!visitorAge.equals(other.visitorAge))
            return false;
        if (visitorClassId == null) {
            if (other.visitorClassId != null)
                return false;
        } else if (!visitorClassId.equals(other.visitorClassId))
            return false;
        if (visitorGender == null) {
            if (other.visitorGender != null)
                return false;
        } else if (!visitorGender.equals(other.visitorGender))
            return false;
        if (visitorHost == null) {
            if (other.visitorHost != null)
                return false;
        } else if (!visitorHost.equals(other.visitorHost))
            return false;
        if (visitorIp == null) {
            if (other.visitorIp != null)
                return false;
        } else if (!visitorIp.equals(other.visitorIp))
            return false;
        if (visitorLabel == null) {
            if (other.visitorLabel != null)
                return false;
        } else if (!visitorLabel.equals(other.visitorLabel))
            return false;
        if (visitorLevel == null) {
            if (other.visitorLevel != null)
                return false;
        } else if (!visitorLevel.equals(other.visitorLevel))
            return false;
        if (visitorLocation == null) {
            if (other.visitorLocation != null)
                return false;
        } else if (!visitorLocation.equals(other.visitorLocation))
            return false;
        if (visitorMacAddress == null) {
            if (other.visitorMacAddress != null)
                return false;
        } else if (!visitorMacAddress.equals(other.visitorMacAddress))
            return false;
        if (visitorType == null) {
            if (other.visitorType != null)
                return false;
        } else if (!visitorType.equals(other.visitorType))
            return false;
        return true;
    }

    /**
     * 访客信息表 重写toString
     */ 
    @Override
    public String toString() {
        return "VisitorInfo [id=" + id + ", visitorAccount=" + visitorAccount + ", visitorIp=" + visitorIp
                + ", visitorHost=" + visitorHost + ", visitorLocation=" + visitorLocation + ", telecomType="
                + telecomType + ", visitorMacAddress=" + visitorMacAddress + ", osId=" + osId + ", osVersion="
                + osVersion + ", osBit=" + osBit + ", browserId=" + browserId + ", browserVersion=" + browserVersion
                + ", visitorType=" + visitorType + ", visitorGender=" + visitorGender + ", visitorAge=" + visitorAge
                + ", visitorLevel=" + visitorLevel + ", visitorClassId=" + visitorClassId + ", visitorLabel="
                + visitorLabel + ", show=" + show + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId="
                + ownerId + ", operatorId=" + operatorId + ", authorization=" + authorization + ", apply=" + apply
                + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }

}
