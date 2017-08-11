package com.globalexpress.web.foreground.dao;

import com.globalexpress.web.entity.CargoTracking;

public interface ForegroundCargoTrackingDao {

	CargoTracking getByTrackingNum(String trackingNum, Long ownerId);
}