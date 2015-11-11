package com.flycode.readrec.service.iface;

import java.util.List;

import com.flycode.readrec.entity.TabReadRec;
import com.flycode.readrec.entity.TabReadRecExample;

public interface TabReadRecService {
	List<TabReadRec> selectByExample(TabReadRecExample readRecExample);
}
