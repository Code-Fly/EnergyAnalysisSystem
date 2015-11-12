/**
 * 
 */
package com.flycode.monthaccount.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.monthaccount.entity.TabMonthAccount;
import com.flycode.monthaccount.entity.TabMonthAccountExample;
import com.flycode.monthaccount.mapper.TabMonthAccountMapper;
import com.flycode.monthaccount.service.iface.TabMonthAccountService;

/**
 * @author VM
 *
 */
@Service("tabMonthAccountService")
public class TabMonthAccountServiceImp implements TabMonthAccountService {
	
	@Autowired
	private TabMonthAccountMapper monthCountMapper;
	
	@Override
	public List<TabMonthAccount> selectByExample(
			TabMonthAccountExample tabMonthAccountExample) {
		return monthCountMapper.selectByExample(tabMonthAccountExample);
	}

}
