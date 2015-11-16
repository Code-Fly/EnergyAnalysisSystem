/**
 * 
 */
package com.flycode.masterop.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.masterop.entity.TabMasterOp;
import com.flycode.masterop.entity.TabMasterOpExample;
import com.flycode.masterop.mapper.TabMasterOpMapper;
import com.flycode.masterop.service.iface.TabMasterOpService;


/**
 * @author VM
 *
 */
@Service("tabMasterOpService")
public class TabMasterOpServiceImp implements TabMasterOpService {
	
	@Autowired
	private TabMasterOpMapper opMapper;
	
	@Override
	public List<TabMasterOp> selectByExample(TabMasterOpExample tabMasterOp) {
		return opMapper.selectByExample(tabMasterOp);
	}

}
