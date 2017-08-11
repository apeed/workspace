package com.globalexpress.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 访客行为表 实体类
 * 
 * <p>访客行为表在JAVA层的具体对象。
 * @author 赵滨
 *
 */
public class VisitorBehavior implements Serializable{

    /**
     * 实现序列化接口，生成序列化ID
     */
    private static final long serialVersionUID = 4591934845969696496L;
    
    //记录编号ID
    private Long id;
    
    //访客编号
    private Long visitorId;
    
    //来访时间
    private Timestamp arrivalTime;
    
    //入站来源（访客来源）地址
    private String parentId;
    
    //来源类型
    private Integer sourceType;
    
    //来源终端渠道
    private Integer sourceChannel;
    
    //来源关键词
    private String sourceKeyword;
    
    //被访（浏览）页面
    private String pageVisited;
    
    //被访页面加载时长
    private Long pageLoadingDuration;
    
    //单页面浏览时长
    private Long pageStayDuration;
    
    //被访页面搜索关键词
    private String keywordSearched;
    
    //动作类型
    private Integer behaviorType;
    
    //被点击按钮
    private Long buttonClicked;
    
    //是否下单
    private Boolean ordered;
    
    //离开时间
    private Timestamp departureTime;
    
    //离开去向链接
    private String leaveforLink;
    
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
     * 访客行为表 无参数的构造器
     */
    public VisitorBehavior() {
        super();
    }

    /**
     * 访客行为表 有参数的构造器
     */
    public VisitorBehavior(Long id, Long visitorId, Timestamp arrivalTime, String parentId, Integer sourceType,
            Integer sourceChannel, String sourceKeyword, String pageVisited, Long pageLoadingDuration,
            Long pageStayDuration, String keywordSearched, Integer behaviorType, Long buttonClicked, Boolean ordered,
            Timestamp departureTime, String leaveforLink, Boolean show, String reserved1, String note, Long ownerId,
            Long operatorId, Boolean authorization, Boolean apply, Timestamp gmtCreate, Timestamp gmtModified) {
        super();
        this.id = id;
        this.visitorId = visitorId;
        this.arrivalTime = arrivalTime;
        this.parentId = parentId;
        this.sourceType = sourceType;
        this.sourceChannel = sourceChannel;
        this.sourceKeyword = sourceKeyword;
        this.pageVisited = pageVisited;
        this.pageLoadingDuration = pageLoadingDuration;
        this.pageStayDuration = pageStayDuration;
        this.keywordSearched = keywordSearched;
        this.behaviorType = behaviorType;
        this.buttonClicked = buttonClicked;
        this.ordered = ordered;
        this.departureTime = departureTime;
        this.leaveforLink = leaveforLink;
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

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getSourceChannel() {
        return sourceChannel;
    }

    public void setSourceChannel(Integer sourceChannel) {
        this.sourceChannel = sourceChannel;
    }

    public String getSourceKeyword() {
        return sourceKeyword;
    }

    public void setSourceKeyword(String sourceKeyword) {
        this.sourceKeyword = sourceKeyword;
    }

    public String getPageVisited() {
        return pageVisited;
    }

    public void setPageVisited(String pageVisited) {
        this.pageVisited = pageVisited;
    }

    public Long getPageLoadingDuration() {
        return pageLoadingDuration;
    }

    public void setPageLoadingDuration(Long pageLoadingDuration) {
        this.pageLoadingDuration = pageLoadingDuration;
    }

    public Long getPageStayDuration() {
        return pageStayDuration;
    }

    public void setPageStayDuration(Long pageStayDuration) {
        this.pageStayDuration = pageStayDuration;
    }

    public String getKeywordSearched() {
        return keywordSearched;
    }

    public void setKeywordSearched(String keywordSearched) {
        this.keywordSearched = keywordSearched;
    }

    public Integer getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(Integer behaviorType) {
        this.behaviorType = behaviorType;
    }

    public Long getButtonClicked() {
        return buttonClicked;
    }

    public void setButtonClicked(Long buttonClicked) {
        this.buttonClicked = buttonClicked;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getLeaveforLink() {
        return leaveforLink;
    }

    public void setLeaveforLink(String leaveforLink) {
        this.leaveforLink = leaveforLink;
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

    /**
     * 访客行为表 重写hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apply == null) ? 0 : apply.hashCode());
        result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
        result = prime * result + ((authorization == null) ? 0 : authorization.hashCode());
        result = prime * result + ((behaviorType == null) ? 0 : behaviorType.hashCode());
        result = prime * result + ((buttonClicked == null) ? 0 : buttonClicked.hashCode());
        result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
        result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
        result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((keywordSearched == null) ? 0 : keywordSearched.hashCode());
        result = prime * result + ((leaveforLink == null) ? 0 : leaveforLink.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
        result = prime * result + ((ordered == null) ? 0 : ordered.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((pageLoadingDuration == null) ? 0 : pageLoadingDuration.hashCode());
        result = prime * result + ((pageStayDuration == null) ? 0 : pageStayDuration.hashCode());
        result = prime * result + ((pageVisited == null) ? 0 : pageVisited.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((reserved1 == null) ? 0 : reserved1.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
        result = prime * result + ((sourceChannel == null) ? 0 : sourceChannel.hashCode());
        result = prime * result + ((sourceKeyword == null) ? 0 : sourceKeyword.hashCode());
        result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
        result = prime * result + ((visitorId == null) ? 0 : visitorId.hashCode());
        return result;
    }

    /**
     * 访客行为表 重写equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VisitorBehavior other = (VisitorBehavior) obj;
        if (apply == null) {
            if (other.apply != null)
                return false;
        } else if (!apply.equals(other.apply))
            return false;
        if (arrivalTime == null) {
            if (other.arrivalTime != null)
                return false;
        } else if (!arrivalTime.equals(other.arrivalTime))
            return false;
        if (authorization == null) {
            if (other.authorization != null)
                return false;
        } else if (!authorization.equals(other.authorization))
            return false;
        if (behaviorType == null) {
            if (other.behaviorType != null)
                return false;
        } else if (!behaviorType.equals(other.behaviorType))
            return false;
        if (buttonClicked == null) {
            if (other.buttonClicked != null)
                return false;
        } else if (!buttonClicked.equals(other.buttonClicked))
            return false;
        if (departureTime == null) {
            if (other.departureTime != null)
                return false;
        } else if (!departureTime.equals(other.departureTime))
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
        if (keywordSearched == null) {
            if (other.keywordSearched != null)
                return false;
        } else if (!keywordSearched.equals(other.keywordSearched))
            return false;
        if (leaveforLink == null) {
            if (other.leaveforLink != null)
                return false;
        } else if (!leaveforLink.equals(other.leaveforLink))
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
        if (ordered == null) {
            if (other.ordered != null)
                return false;
        } else if (!ordered.equals(other.ordered))
            return false;
        if (ownerId == null) {
            if (other.ownerId != null)
                return false;
        } else if (!ownerId.equals(other.ownerId))
            return false;
        if (pageLoadingDuration == null) {
            if (other.pageLoadingDuration != null)
                return false;
        } else if (!pageLoadingDuration.equals(other.pageLoadingDuration))
            return false;
        if (pageStayDuration == null) {
            if (other.pageStayDuration != null)
                return false;
        } else if (!pageStayDuration.equals(other.pageStayDuration))
            return false;
        if (pageVisited == null) {
            if (other.pageVisited != null)
                return false;
        } else if (!pageVisited.equals(other.pageVisited))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
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
        if (sourceChannel == null) {
            if (other.sourceChannel != null)
                return false;
        } else if (!sourceChannel.equals(other.sourceChannel))
            return false;
        if (sourceKeyword == null) {
            if (other.sourceKeyword != null)
                return false;
        } else if (!sourceKeyword.equals(other.sourceKeyword))
            return false;
        if (sourceType == null) {
            if (other.sourceType != null)
                return false;
        } else if (!sourceType.equals(other.sourceType))
            return false;
        if (visitorId == null) {
            if (other.visitorId != null)
                return false;
        } else if (!visitorId.equals(other.visitorId))
            return false;
        return true;
    }

    /**
     * 访客行为表 重写toString
     */
    @Override
    public String toString() {
        return "VisitorBehavior [id=" + id + ", visitorId=" + visitorId + ", arrivalTime=" + arrivalTime + ", parentId="
                + parentId + ", sourceType=" + sourceType + ", sourceChannel=" + sourceChannel + ", sourceKeyword="
                + sourceKeyword + ", pageVisited=" + pageVisited + ", pageLoadingDuration=" + pageLoadingDuration
                + ", pageStayDuration=" + pageStayDuration + ", keywordSearched=" + keywordSearched + ", behaviorType="
                + behaviorType + ", buttonClicked=" + buttonClicked + ", ordered=" + ordered + ", departureTime="
                + departureTime + ", leaveforLink=" + leaveforLink + ", show=" + show + ", reserved1=" + reserved1
                + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorization="
                + authorization + ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
                + "]";
    }
    
    
}
