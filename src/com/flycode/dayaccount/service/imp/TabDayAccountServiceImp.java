/**
 * 
 */
package com.flycode.dayaccount.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.dayaccount.entity.TabDayAccount;
import com.flycode.dayaccount.entity.TabDayAccountExample;
import com.flycode.dayaccount.mapper.TabDayAccountMapper;
import com.flycode.dayaccount.service.iface.TabDayAccountService;


/**
 * @author VM
 *
 */
@Service("tabDayAccountService")
public class TabDayAccountServiceImp implements TabDayAccountService {
	
	@Autowired
	private TabDayAccountMapper dayCountMapper;
	
	@Override
	public List<TabDayAccount> selectByExample(TabDayAccountExample tabDayAccount) {
		return dayCountMapper.selectByExample(tabDayAccount);
	}

}
