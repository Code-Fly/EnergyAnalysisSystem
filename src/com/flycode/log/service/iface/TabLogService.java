package com.flycode.log.service.iface;

import java.util.List;

import com.flycode.log.entity.TabLog;
import com.flycode.log.entity.TabLogExample;

public interface TabLogService {
	List<TabLog> selectByExample(TabLogExample logExample);
}
