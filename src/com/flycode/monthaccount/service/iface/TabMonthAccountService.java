package com.flycode.monthaccount.service.iface;

import java.util.List;

import com.flycode.monthaccount.entity.TabMonthAccount;
import com.flycode.monthaccount.entity.TabMonthAccountExample;


public interface TabMonthAccountService {
	List<TabMonthAccount> selectByExample(TabMonthAccountExample tabMonthAccountExample);
}
