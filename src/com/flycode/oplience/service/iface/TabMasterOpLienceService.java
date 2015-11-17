package com.flycode.oplience.service.iface;

import java.util.List;

import com.flycode.oplience.entity.TabMasterOpLience;
import com.flycode.oplience.entity.TabMasterOpLienceExample;

public interface TabMasterOpLienceService {
	 int insertSelective(TabMasterOpLience record);
	int deleteByExample(TabMasterOpLienceExample example);
	List<TabMasterOpLience> selectByExample(TabMasterOpLienceExample example);
	List<Integer> selectmIDByExample(TabMasterOpLienceExample example);
}
