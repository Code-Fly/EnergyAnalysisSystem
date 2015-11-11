package com.flycode.dayaccount.service.iface;

import java.util.List;

import com.flycode.dayaccount.entity.TabDayAccount;
import com.flycode.dayaccount.entity.TabDayAccountExample;

public interface TabDayAccountService {
	List<TabDayAccount> selectByExample(TabDayAccountExample tabDayAccountExample);
}
