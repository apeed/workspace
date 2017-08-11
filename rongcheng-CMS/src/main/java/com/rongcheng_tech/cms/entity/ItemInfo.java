package com.rongcheng_tech.cms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItemInfo implements Serializable{
	private static final long serialVersionUID = 1524336696500393527L;
	//商品ID
	private Long id;
	//店铺编号
	private Long shopId;
	//商品编码SKU
	private Long itemSku;
	//商品名称
	private String itemName;
	//商品简称
	private String itemShortName;
	//商品英文名称
	private String itemEnTitle;
	//接口显示名称
	private String interfaceName;
	//缩略图
	private String iconUrl;
	//缩略图跳转链接
	private String iconDirectLink;
	//商品简介
	private String itemProfile;
	//商品图片1
	private String itemImage1;
	//商品类目
	private String categoryId;
	//商品品牌
	private String itemBrand;
	//商品系列
	private String itemSeries;
	//商品颜色
	private String itemColor;
	//商品尺码
	private String itemSize;
	//商品条码
	private String barCode;
	//商品类型
	private Byte itemType;
	//商品原价
	private BigDecimal normalPrice;
	//成本价（进货价）
	private BigDecimal costPrice;
	//商品所在地
	private String itemLocation;
	//库存数量
	private Integer stockQuantity;
	//商品促销价格
	private BigDecimal promotionPrice;
	//销量数据
	private Integer saleQuantity;
	//商品标签
	private String labelId;
	//商品关键词
	private String itemKeyword;
	//是否显示
	private Boolean show;
	//用户自定义顺序号
	private Integer userSequence;
	//自定义内容
	private String reserved1;
	//备注
	private String note;
	//用户主账户ID（数据表所有者）
	private Long ownerId;
	//操作人
	private Long operatorId;
	//该记录是否被授权
	private Boolean authorized;
	//该记录是否已被应用或调用
	private Boolean apply;
	//记录创建时间
	private Date gmtCreate;
	//记录修改时间
	private Date gmtModified;
	//商品详情
	private String itemDetail;

	  public ItemInfo() {

}

public ItemInfo(Long id, Long shopId, Long itemSku, String itemName, String itemShortName, String itemEnTitle,
		String interfaceName, String iconUrl, String iconDirectLink, String itemProfile, String itemImage1,
		String categoryId, String itemBrand, String itemSeries, String itemColor, String itemSize, String barCode,
		Byte itemType, BigDecimal normalPrice, BigDecimal costPrice, String itemLocation, Integer stockQuantity,
		BigDecimal promotionPrice, Integer saleQuantity, String labelId, String itemKeyword, Boolean show,
		Integer userSequence, String reserved1, String note, Long ownerId, Long operatorId, Boolean authorized,
		Boolean apply, Date gmtCreate, Date gmtModified, String itemDetail) {
	super();
	this.id = id;
	this.shopId = shopId;
	this.itemSku = itemSku;
	this.itemName = itemName;
	this.itemShortName = itemShortName;
	this.itemEnTitle = itemEnTitle;
	this.interfaceName = interfaceName;
	this.iconUrl = iconUrl;
	this.iconDirectLink = iconDirectLink;
	this.itemProfile = itemProfile;
	this.itemImage1 = itemImage1;
	this.categoryId = categoryId;
	this.itemBrand = itemBrand;
	this.itemSeries = itemSeries;
	this.itemColor = itemColor;
	this.itemSize = itemSize;
	this.barCode = barCode;
	this.itemType = itemType;
	this.normalPrice = normalPrice;
	this.costPrice = costPrice;
	this.itemLocation = itemLocation;
	this.stockQuantity = stockQuantity;
	this.promotionPrice = promotionPrice;
	this.saleQuantity = saleQuantity;
	this.labelId = labelId;
	this.itemKeyword = itemKeyword;
	this.show = show;
	this.userSequence = userSequence;
	this.reserved1 = reserved1;
	this.note = note;
	this.ownerId = ownerId;
	this.operatorId = operatorId;
	this.authorized = authorized;
	this.apply = apply;
	this.gmtCreate = gmtCreate;
	this.gmtModified = gmtModified;
	this.itemDetail = itemDetail;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getShopId() {
	return shopId;
}

public void setShopId(Long shopId) {
	this.shopId = shopId;
}

public Long getItemSku() {
	return itemSku;
}

public void setItemSku(Long itemSku) {
	this.itemSku = itemSku;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public String getItemShortName() {
	return itemShortName;
}

public void setItemShortName(String itemShortName) {
	this.itemShortName = itemShortName;
}

public String getItemEnTitle() {
	return itemEnTitle;
}

public void setItemEnTitle(String itemEnTitle) {
	this.itemEnTitle = itemEnTitle;
}

public String getInterfaceName() {
	return interfaceName;
}

public void setInterfaceName(String interfaceName) {
	this.interfaceName = interfaceName;
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

public String getItemProfile() {
	return itemProfile;
}

public void setItemProfile(String itemProfile) {
	this.itemProfile = itemProfile;
}

public String getItemImage1() {
	return itemImage1;
}

public void setItemImage1(String itemImage1) {
	this.itemImage1 = itemImage1;
}

public String getCategoryId() {
	return categoryId;
}

public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}

public String getItemBrand() {
	return itemBrand;
}

public void setItemBrand(String itemBrand) {
	this.itemBrand = itemBrand;
}

public String getItemSeries() {
	return itemSeries;
}

public void setItemSeries(String itemSeries) {
	this.itemSeries = itemSeries;
}

public String getItemColor() {
	return itemColor;
}

public void setItemColor(String itemColor) {
	this.itemColor = itemColor;
}

public String getItemSize() {
	return itemSize;
}

public void setItemSize(String itemSize) {
	this.itemSize = itemSize;
}

public String getBarCode() {
	return barCode;
}

public void setBarCode(String barCode) {
	this.barCode = barCode;
}

public Byte getItemType() {
	return itemType;
}

public void setItemType(Byte itemType) {
	this.itemType = itemType;
}

public BigDecimal getNormalPrice() {
	return normalPrice;
}

public void setNormalPrice(BigDecimal normalPrice) {
	this.normalPrice = normalPrice;
}

public BigDecimal getCostPrice() {
	return costPrice;
}

public void setCostPrice(BigDecimal costPrice) {
	this.costPrice = costPrice;
}

public String getItemLocation() {
	return itemLocation;
}

public void setItemLocation(String itemLocation) {
	this.itemLocation = itemLocation;
}

public Integer getStockQuantity() {
	return stockQuantity;
}

public void setStockQuantity(Integer stockQuantity) {
	this.stockQuantity = stockQuantity;
}

public BigDecimal getPromotionPrice() {
	return promotionPrice;
}

public void setPromotionPrice(BigDecimal promotionPrice) {
	this.promotionPrice = promotionPrice;
}

public Integer getSaleQuantity() {
	return saleQuantity;
}

public void setSaleQuantity(Integer saleQuantity) {
	this.saleQuantity = saleQuantity;
}

public String getLabelId() {
	return labelId;
}

public void setLabelId(String labelId) {
	this.labelId = labelId;
}

public String getItemKeyword() {
	return itemKeyword;
}

public void setItemKeyword(String itemKeyword) {
	this.itemKeyword = itemKeyword;
}

public Boolean getShow() {
	return show;
}

public void setShow(Boolean show) {
	this.show = show;
}

public Integer getUserSequence() {
	return userSequence;
}

public void setUserSequence(Integer userSequence) {
	this.userSequence = userSequence;
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

public Boolean getAuthorized() {
	return authorized;
}

public void setAuthorized(Boolean authorized) {
	this.authorized = authorized;
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

public String getItemDetail() {
	return itemDetail;
}

public void setItemDetail(String itemDetail) {
	this.itemDetail = itemDetail;
}

@Override
public String toString() {
	return "ItemInfo [id=" + id + ", shopId=" + shopId + ", itemSku=" + itemSku + ", itemName=" + itemName
			+ ", itemShortName=" + itemShortName + ", itemEnTitle=" + itemEnTitle + ", interfaceName=" + interfaceName
			+ ", iconUrl=" + iconUrl + ", iconDirectLink=" + iconDirectLink + ", itemProfile=" + itemProfile
			+ ", itemImage1=" + itemImage1 + ", categoryId=" + categoryId + ", itemBrand=" + itemBrand + ", itemSeries="
			+ itemSeries + ", itemColor=" + itemColor + ", itemSize=" + itemSize + ", barCode=" + barCode
			+ ", itemType=" + itemType + ", normalPrice=" + normalPrice + ", costPrice=" + costPrice + ", itemLocation="
			+ itemLocation + ", stockQuantity=" + stockQuantity + ", promotionPrice=" + promotionPrice
			+ ", saleQuantity=" + saleQuantity + ", labelId=" + labelId + ", itemKeyword=" + itemKeyword + ", show="
			+ show + ", userSequence=" + userSequence + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId="
			+ ownerId + ", operatorId=" + operatorId + ", authorized=" + authorized + ", apply=" + apply
			+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", itemDetail=" + itemDetail + "]";
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
	ItemInfo other = (ItemInfo) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}