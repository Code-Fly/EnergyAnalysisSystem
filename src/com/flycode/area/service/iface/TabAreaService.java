package com.flycode.area.service.iface;

import java.util.List;

import com.flycode.area.entity.TabArea;
import com.flycode.area.entity.TabAreaExample;


public interface TabAreaService {
	List<TabArea> selectByExample(TabAreaExample tabAreaExample);
	List<TabArea> selectByInfoID(String  infoID);
	TabArea selectByPrimaryKey(String infoID);
}
