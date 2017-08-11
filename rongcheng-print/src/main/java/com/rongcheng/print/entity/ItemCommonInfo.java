package com.rongcheng.print.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
public class ItemCommonInfo implements Serializable{
	private static final long serialVersionUID = 2526181391607599544L;
	private BigInteger id;//商品ID
	private String  erpItemNum;//erp商品编码
	private String name;//商品名称
	private String shortName;//商品简称
	private BigInteger platformId;//来源（平台）编码
	private BigInteger platformItemSku;//来源（平台）商品编码SKU
	private String userShopCode;//用户自定义店铺编码
	private String userItemCode;//用户自定义商品编码
	private String image1;//商品图片
	private String category;//商品类目
	private String brand;//商品品牌
	private String series;//商品系列
	private String color;//商品颜色
	private String size;//商品尺码
	private  BigDecimal normalPrice;//商品原价
	private  BigDecimal costPrice;//成本价（进货价）
	private  BigDecimal promotionPrice;//商品促销价格
	private String barCode;//商品条码
	private String packageCondition;//商品包装（是否破损，包装完整等）
	private String userClassification;//用户自定义系统分类
	private Boolean presell;//是否预售
	private Boolean commissionSell;//是否代售
	private Boolean gift;//是否赠品
	private String barCodeImage;//商品ID条码图片
	private String qrCodeImage;//商品二维码图片
	private String reserved1;//自定义内容1
	private String note;//备注
	private Boolean authorized;//该记录是否被授权
	private String itemSecretKey;//商品秘钥
	private BigInteger ownerId;//用户主账户ID（数据表所有者）
	private BigInteger shopId;//所属店铺ID
	private Timestamp gmtCreate;//记录创建时间
	private Timestamp gmtModified;//记录修改时间
	private BigInteger operatorId;//操作人
	private String spec;//商品规格
	public ItemCommonInfo() {
		
	}
	public ItemCommonInfo(BigInteger id, String erpItemNum, String name, String shortName, BigInteger platformId,
			BigInteger platformItemSku, String userShopCode, String userItemCode, String image1, String category,
			String brand, String series, String color, String size, BigDecimal normalPrice, BigDecimal costPrice,
			BigDecimal promotionPrice, String barCode, String packageCondition, String userClassification,
			Boolean presell, Boolean commissionSell, Boolean gift, String barCodeImage, String qrCodeImage,
			String reserved1, String note, Boolean authorized, String itemSecretKey, BigInteger ownerId,
			BigInteger shopId, Timestamp gmtCreate, Timestamp gmtModified, BigInteger operatorId, String spec) {
		super();
		this.id = id;
		this.erpItemNum = erpItemNum;
		this.name = name;
		this.shortName = shortName;
		this.platformId = platformId;
		this.platformItemSku = platformItemSku;
		this.userShopCode = userShopCode;
		this.userItemCode = userItemCode;
		this.image1 = image1;
		this.category = category;
		this.brand = brand;
		this.series = series;
		this.color = color;
		this.size = size;
		this.normalPrice = normalPrice;
		this.costPrice = costPrice;
		this.promotionPrice = promotionPrice;
		this.barCode = barCode;
		this.packageCondition = packageCondition;
		this.userClassification = userClassification;
		this.presell = presell;
		this.commissionSell = commissionSell;
		this.gift = gift;
		this.barCodeImage = barCodeImage;
		this.qrCodeImage = qrCodeImage;
		this.reserved1 = reserved1;
		this.note = note;
		this.authorized = authorized;
		this.itemSecretKey = itemSecretKey;
		this.ownerId = ownerId;
		this.shopId = shopId;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.operatorId = operatorId;
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "ItemCommonInfo [id=" + id + ", erpItemNum=" + erpItemNum + ", name=" + name + ", shortName=" + shortName
				+ ", platformId=" + platformId + ", platformItemSku=" + platformItemSku + ", userShopCode="
				+ userShopCode + ", userItemCode=" + userItemCode + ", image1=" + image1 + ", category=" + category
				+ ", brand=" + brand + ", series=" + series + ", color=" + color + ", size=" + size + ", normalPrice="
				+ normalPrice + ", costPrice=" + costPrice + ", promotionPrice=" + promotionPrice + ", barCode="
				+ barCode + ", packageCondition=" + packageCondition + ", userClassification=" + userClassification
				+ ", presell=" + presell + ", commissionSell=" + commissionSell + ", gift=" + gift + ", barCodeImage="
				+ barCodeImage + ", qrCodeImage=" + qrCodeImage + ", reserved1=" + reserved1 + ", note=" + note
				+ ", authorized=" + authorized + ", itemSecretKey=" + itemSecretKey + ", ownerId=" + ownerId
				+ ", shopId=" + shopId + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", operatorId="
				+ operatorId + ", spec=" + spec + "]";
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getErpItemNum() {
		return erpItemNum;
	}
	public void setErpItemNum(String erpItemNum) {
		this.erpItemNum = erpItemNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public BigInteger getPlatformId() {
		return platformId;
	}
	public void setPlatformId(BigInteger platformId) {
		this.platformId = platformId;
	}
	public BigInteger getPlatformItemSku() {
		return platformItemSku;
	}
	public void setPlatformItemSku(BigInteger platformItemSku) {
		this.platformItemSku = platformItemSku;
	}
	public String getUserShopCode() {
		return userShopCode;
	}
	public void setUserShopCode(String userShopCode) {
		this.userShopCode = userShopCode;
	}
	public String getUserItemCode() {
		return userItemCode;
	}
	public void setUserItemCode(String userItemCode) {
		this.userItemCode = userItemCode;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getPackageCondition() {
		return packageCondition;
	}
	public void setPackageCondition(String packageCondition) {
		this.packageCondition = packageCondition;
	}
	public String getUserClassification() {
		return userClassification;
	}
	public void setUserClassification(String userClassification) {
		this.userClassification = userClassification;
	}
	public Boolean getPresell() {
		return presell;
	}
	public void setPresell(Boolean presell) {
		this.presell = presell;
	}
	public Boolean getCommissionSell() {
		return commissionSell;
	}
	public void setCommissionSell(Boolean commissionSell) {
		this.commissionSell = commissionSell;
	}
	public Boolean getGift() {
		return gift;
	}
	public void setGift(Boolean gift) {
		this.gift = gift;
	}
	public String getBarCodeImage() {
		return barCodeImage;
	}
	public void setBarCodeImage(String barCodeImage) {
		this.barCodeImage = barCodeImage;
	}
	public String getQrCodeImage() {
		return qrCodeImage;
	}
	public void setQrCodeImage(String qrCodeImage) {
		this.qrCodeImage = qrCodeImage;
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
	public Boolean getAuthorized() {
		return authorized;
	}
	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
	public String getItemSecretKey() {
		return itemSecretKey;
	}
	public void setItemSecretKey(String itemSecretKey) {
		this.itemSecretKey = itemSecretKey;
	}
	public BigInteger getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(BigInteger ownerId) {
		this.ownerId = ownerId;
	}
	public BigInteger getShopId() {
		return shopId;
	}
	public void setShopId(BigInteger shopId) {
		this.shopId = shopId;
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
	public BigInteger getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(BigInteger operatorId) {
		this.operatorId = operatorId;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
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
		ItemCommonInfo other = (ItemCommonInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
