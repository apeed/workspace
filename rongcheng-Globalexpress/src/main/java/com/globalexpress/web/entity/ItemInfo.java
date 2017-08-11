package com.globalexpress.web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ItemInfo {
	private Long id;

	private Long shopId;

	private Long itemSku;

	private String itemName;

	private String itemShortName;

	private String itemEnTitle;

	private String interfaceName;

	private String iconUrl;

	private String iconDirectLink;

	private String itemProfile;

	private String itemImage1;

	private String categoryId;

	private String itemBrand;

	private String itemSeries;

	private String itemColor;

	private String itemSize;

	private String barCode;

	private Byte itemType;

	private BigDecimal normalPrice;

	private BigDecimal costPrice;

	private String itemLocation;

	private Integer stockQuantity;

	private BigDecimal promotionPrice;

	private Integer saleQuantity;

	private String labelId;

	private String itemKeyword;

	private Boolean show;

	private Integer userSequence;

	private String reserved1;

	private String note;

	private Long ownerId;

	private Long operatorId;

	private Boolean authorized;

	private Boolean apply;

	private Date gmtCreate;

	private Date gmtModified;

	private String itemDetail;

	public ItemInfo() {
		super();
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
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public String getItemShortName() {
		return itemShortName;
	}

	public void setItemShortName(String itemShortName) {
		this.itemShortName = itemShortName == null ? null : itemShortName.trim();
	}

	public String getItemEnTitle() {
		return itemEnTitle;
	}

	public void setItemEnTitle(String itemEnTitle) {
		this.itemEnTitle = itemEnTitle == null ? null : itemEnTitle.trim();
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

	public String getItemProfile() {
		return itemProfile;
	}

	public void setItemProfile(String itemProfile) {
		this.itemProfile = itemProfile == null ? null : itemProfile.trim();
	}

	public String getItemImage1() {
		return itemImage1;
	}

	public void setItemImage1(String itemImage1) {
		this.itemImage1 = itemImage1 == null ? null : itemImage1.trim();
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId == null ? null : categoryId.trim();
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand == null ? null : itemBrand.trim();
	}

	public String getItemSeries() {
		return itemSeries;
	}

	public void setItemSeries(String itemSeries) {
		this.itemSeries = itemSeries == null ? null : itemSeries.trim();
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor == null ? null : itemColor.trim();
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize == null ? null : itemSize.trim();
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode == null ? null : barCode.trim();
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
		this.itemLocation = itemLocation == null ? null : itemLocation.trim();
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
		this.labelId = labelId == null ? null : labelId.trim();
	}

	public String getItemKeyword() {
		return itemKeyword;
	}

	public void setItemKeyword(String itemKeyword) {
		this.itemKeyword = itemKeyword == null ? null : itemKeyword.trim();
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
		this.itemDetail = itemDetail == null ? null : itemDetail.trim();
	}

	@Override
	public String toString() {
		return "ItemInfo [id=" + id + ", shopId=" + shopId + ", itemSku=" + itemSku + ", itemName=" + itemName
				+ ", itemShortName=" + itemShortName + ", itemEnTitle=" + itemEnTitle + ", interfaceName="
				+ interfaceName + ", iconUrl=" + iconUrl + ", iconDirectLink=" + iconDirectLink + ", itemProfile="
				+ itemProfile + ", itemImage1=" + itemImage1 + ", categoryId=" + categoryId + ", itemBrand=" + itemBrand
				+ ", itemSeries=" + itemSeries + ", itemColor=" + itemColor + ", itemSize=" + itemSize + ", barCode="
				+ barCode + ", itemType=" + itemType + ", normalPrice=" + normalPrice + ", costPrice=" + costPrice
				+ ", itemLocation=" + itemLocation + ", stockQuantity=" + stockQuantity + ", promotionPrice="
				+ promotionPrice + ", saleQuantity=" + saleQuantity + ", labelId=" + labelId + ", itemKeyword="
				+ itemKeyword + ", show=" + show + ", userSequence=" + userSequence + ", reserved1=" + reserved1
				+ ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorized="
				+ authorized + ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", itemDetail=" + itemDetail + "]";
	}

}