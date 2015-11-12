/**
 * 
 */
package com.flycode.yearaccount.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.yearaccount.entity.TabYearAccount;
import com.flycode.yearaccount.entity.TabYearAccountExample;
import com.flycode.yearaccount.mapper.TabYearAccountMapper;
import com.flycode.yearaccount.service.iface.TabYearAccountService;

/**
 * @author VM
 *
 */
@Service("tabYearAccountService")
public class TabYearAccountServiceImp implements TabYearAccountService {
	
	@Autowired
	private TabYearAccountMapper monthCountMapper;
	
	@Override
	public List<TabYearAccount> selectByExample(
			TabYearAccountExample tabYearAccountExample) {
		return monthCountMapper.selectByExample(tabYearAccountExample);
	}

}
