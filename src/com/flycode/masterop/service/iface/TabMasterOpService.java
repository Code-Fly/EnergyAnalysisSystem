package com.flycode.masterop.service.iface;

import java.util.List;

import com.flycode.masterop.entity.TabMasterOp;
import com.flycode.masterop.entity.TabMasterOpExample;

public interface TabMasterOpService {
	List<TabMasterOp> selectByExample(TabMasterOpExample tabMasterOpExample);
}
