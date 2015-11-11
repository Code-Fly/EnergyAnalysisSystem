/**
 * 
 */
package com.flycode.readrec.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.readrec.entity.TabReadRec;
import com.flycode.readrec.mapper.TabReadRecMapper;
import com.flycode.readrec.service.iface.TabReadRecService;

/**
 * @author VM
 *
 */
@Service("tabReadRecService")
public class TabReadRecServiceImp implements TabReadRecService {
	
	@Autowired
	private TabReadRecMapper recMapper;
	
	@Override
	public List<TabReadRec> selectByMonth(String tableName) {
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("tableName", tableName);
		return recMapper.selectByMonth(mapParam);
	}

}
