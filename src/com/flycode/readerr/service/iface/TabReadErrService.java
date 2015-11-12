package com.flycode.readerr.service.iface;

import java.util.List;

import com.flycode.readerr.entity.TabReadErr;
import com.flycode.readerr.entity.TabReadErrExample;



public interface TabReadErrService {
	List<TabReadErr> selectByExample(TabReadErrExample tabReadErrExample);
}
