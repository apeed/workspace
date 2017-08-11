package com.rongcheng.print.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
/**
 * 字段坐标表
 * @author 赵滨
 *
 */
public class FieldCoordinate implements Serializable{

    //版本号
    private static final long serialVersionUID = 5296016906713213161L;

    //1.记录编号ID  非空  非负  长度20
    private BigInteger id;
    
    //2.字段中文名称  长度10
    private String FieldName;
    
    //3.字段英文命名  非空  长度20
    private String terminalName;
    
    //4.坐标类型  非负  长度1
    private Integer coordinateType;
    
    //5.字段x坐标  长度3
    private Integer xCoordinate;
    
    //6.字段y坐标  长度3
    private Integer yCoordinate;
    
    //7.备注  长度100
    private String note;
    
    //8.用户主账户ID  非空  非负  长度20  数据表所有者
    private BigInteger ownerId;
    
    //9.操作人  非负  长度20
    private BigInteger operatorId;
    
    //10.是否授权  非负  长度1
    private Boolean authorized;
    
    //11.记录创建时间  非空  datetime
    private Timestamp gmtCreate;
    
    //12.记录修改时间  datetime
    private Timestamp gmtModified;

    //无参数的构造器
    public FieldCoordinate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //有参数的构造器
    public FieldCoordinate(BigInteger id, String fieldName, String terminalName, Integer coordinateType,
            Integer xCoordinate, Integer yCoordinate, String note, BigInteger ownerId, BigInteger operatorId,
            Boolean authorized, Timestamp gmtCreate, Timestamp gmtModified) {
        super();
        this.id = id;
        FieldName = fieldName;
        this.terminalName = terminalName;
        this.coordinateType = coordinateType;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.note = note;
        this.ownerId = ownerId;
        this.operatorId = operatorId;
        this.authorized = authorized;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    //创建的setter和getter方法
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Integer getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(Integer coordinateType) {
        this.coordinateType = coordinateType;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigInteger getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(BigInteger ownerId) {
        this.ownerId = ownerId;
    }

    public BigInteger getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(BigInteger operatorId) {
        this.operatorId = operatorId;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
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

    //重写hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((FieldName == null) ? 0 : FieldName.hashCode());
        result = prime * result + ((authorized == null) ? 0 : authorized.hashCode());
        result = prime * result + ((coordinateType == null) ? 0 : coordinateType.hashCode());
        result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
        result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((terminalName == null) ? 0 : terminalName.hashCode());
        result = prime * result + ((xCoordinate == null) ? 0 : xCoordinate.hashCode());
        result = prime * result + ((yCoordinate == null) ? 0 : yCoordinate.hashCode());
        return result;
    }

    //重写equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FieldCoordinate other = (FieldCoordinate) obj;
        if (FieldName == null) {
            if (other.FieldName != null)
                return false;
        } else if (!FieldName.equals(other.FieldName))
            return false;
        if (authorized == null) {
            if (other.authorized != null)
                return false;
        } else if (!authorized.equals(other.authorized))
            return false;
        if (coordinateType == null) {
            if (other.coordinateType != null)
                return false;
        } else if (!coordinateType.equals(other.coordinateType))
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
        if (terminalName == null) {
            if (other.terminalName != null)
                return false;
        } else if (!terminalName.equals(other.terminalName))
            return false;
        if (xCoordinate == null) {
            if (other.xCoordinate != null)
                return false;
        } else if (!xCoordinate.equals(other.xCoordinate))
            return false;
        if (yCoordinate == null) {
            if (other.yCoordinate != null)
                return false;
        } else if (!yCoordinate.equals(other.yCoordinate))
            return false;
        return true;
    }

    //重写toString
    @Override
    public String toString() {
        return "FieldCoordinate [id=" + id + ", FieldName=" + FieldName + ", terminalName=" + terminalName
                + ", coordinateType=" + coordinateType + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
                + ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorized="
                + authorized + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
    
}
