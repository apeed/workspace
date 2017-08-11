package com.rongcheng.print.service.ShopInfo;

import java.math.BigInteger;
import java.util.List;

import com.rongcheng.print.entity.ShopInfo;

public interface ShopInfoService {
//	public ShopInfo findByShopType(String type);
	public ShopInfo findByShopId(BigInteger id);
	public int modifyShopInfo(BigInteger id,String name,String sellerAccount,String contactName,String contactTel,String userAddress);
	public List<ShopInfo> findAll();
	public int addShopInfo(String name,String sellerAccount,String contactName,String contactTel,String userAddress);
	public List<ShopInfo> findShopInfoByPage(int start,int rows);
	public String findShopInfoCount();	
	public int modifyShopInfoStatus(BigInteger id,Boolean shopStatus);
}
