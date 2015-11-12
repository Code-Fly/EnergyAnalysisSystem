package com.flycode.yearaccount.service.iface;

import java.util.List;

import com.flycode.yearaccount.entity.TabYearAccount;
import com.flycode.yearaccount.entity.TabYearAccountExample;


public interface TabYearAccountService {
	List<TabYearAccount> selectByExample(TabYearAccountExample tabYearAccountExample);
}
