package com.flycode.error.service.iface;

import java.util.List;

import com.flycode.error.entity.TabError;
import com.flycode.error.entity.TabErrorExample;

public interface TabErrorService {
	List<TabError> selectByExample(TabErrorExample example);

}
