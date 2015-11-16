package com.flycode.oplience.service.iface;

import java.util.List;

import com.flycode.oplience.entity.TabMasterOpLience;
import com.flycode.oplience.entity.TabMasterOpLienceExample;

public interface TabMasterOpLienceService {
	List<TabMasterOpLience> selectByExample(TabMasterOpLienceExample example);
	List<Integer> selectmIDByExample(TabMasterOpLienceExample example);
}
