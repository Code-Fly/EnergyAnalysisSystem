/**
 * 
 */
package com.flycode.area.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.area.entity.TabArea;
import com.flycode.area.entity.TabAreaExample;
import com.flycode.area.mapper.TabAreaMapper;
import com.flycode.area.service.iface.TabAreaService;

/**
 * @author VM
 *
 */
@Service("tabAreaService")
public class TabAreaServiceImp implements TabAreaService {
	
	@Autowired
	private TabAreaMapper areaMapper;
	
	@Override
	public List<TabArea> selectByExample(
			TabAreaExample tabAreaExample) {
		return areaMapper.selectByExample(tabAreaExample);
	}
	
	@Override
	public TabArea selectByPrimaryKey(String infoID) {
		 return areaMapper.selectByPrimaryKey(infoID);
	}

	@Override
	public List<TabArea> selectByInfoID(String infoID) {
		return areaMapper.selectByInfoID(infoID);
	}
	
}
