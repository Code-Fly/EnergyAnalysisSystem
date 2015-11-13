/**
 * 
 */
package com.flycode.log.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.log.entity.TabLog;
import com.flycode.log.entity.TabLogExample;
import com.flycode.log.mapper.TabLogMapper;
import com.flycode.log.service.iface.TabLogService;

/**
 * @author VM
 *
 */
@Service("tabLogService")
public class TabLogServiceImp implements TabLogService {
	
	@Autowired
	private TabLogMapper logMapper;
	
	@Override
	public List<TabLog> selectByExample(TabLogExample logExample) {
		return logMapper.selectByExample(logExample);
	}

}
