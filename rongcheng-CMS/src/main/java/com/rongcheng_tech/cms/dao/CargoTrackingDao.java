package com.rongcheng_tech.cms.dao;

import java.util.List;
import com.rongcheng_tech.cms.entity.CargoTracking;

public interface CargoTrackingDao {
	//分页
	 List<CargoTracking> findCargoTrackingByPage(int start,int rows,Long ownerId);
	 String findCargoTrackingCount(Long ownerId);
	//添加，修改数据
	 int addCargoTracking(CargoTracking ct);
	 int modifyCargoTracking(CargoTracking ct);
	 CargoTracking findByCargoTrackingId(Long id,Long ownerId);
	//模糊查询
	 List<CargoTracking> findListByCargoTracking(String keyword,Long ownerId);
	
}
