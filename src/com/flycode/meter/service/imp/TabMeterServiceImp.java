/**
 * 
 */
package com.flycode.meter.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.meter.entity.TabMeter;
import com.flycode.meter.entity.TabMeterExample;
import com.flycode.meter.mapper.TabMeterMapper;
import com.flycode.meter.service.iface.TabMeterService;

/**
 * @author VM
 *
 */
@Service("tabMeterService")
public class TabMeterServiceImp implements TabMeterService {
	@Autowired
	private TabMeterMapper tabMeterMapper;

	@Override
	public List<TabMeter> selectByExample(TabMeterExample example) {
		return tabMeterMapper.selectByExample(example);
	}
}
