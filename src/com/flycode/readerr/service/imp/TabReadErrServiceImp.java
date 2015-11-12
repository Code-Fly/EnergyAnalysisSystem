/**
 * 
 */
package com.flycode.readerr.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.readerr.entity.TabReadErr;
import com.flycode.readerr.entity.TabReadErrExample;
import com.flycode.readerr.mapper.TabReadErrMapper;
import com.flycode.readerr.service.iface.TabReadErrService;

/**
 * @author VM
 *
 */
@Service("tabReadErrService")
public class TabReadErrServiceImp implements TabReadErrService {
	
	@Autowired
	private TabReadErrMapper readErrMapper;
	
	@Override
	public List<TabReadErr> selectByExample(
			TabReadErrExample tabReadErrExample) {
		return readErrMapper.selectByExample(tabReadErrExample);
	}

}
