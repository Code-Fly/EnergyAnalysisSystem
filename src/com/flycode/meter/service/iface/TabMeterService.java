package com.flycode.meter.service.iface;

import java.util.List;

import com.flycode.meter.entity.TabMeter;
import com.flycode.meter.entity.TabMeterExample;

public interface TabMeterService {
	List<TabMeter> selectByExample(TabMeterExample example);

}
