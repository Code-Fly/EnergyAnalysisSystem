/**
 * 
 */
package com.flycode.oplience.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.oplience.entity.TabMasterOpLience;
import com.flycode.oplience.entity.TabMasterOpLienceExample;
import com.flycode.oplience.mapper.TabMasterOpLienceMapper;
import com.flycode.oplience.service.iface.TabMasterOpLienceService;

/**
 * @author VM
 *
 */
@Service("tabMasterOpLienceService")
public class TabMasterOpLienceServiceImp implements TabMasterOpLienceService {
	@Autowired
	private TabMasterOpLienceMapper tabMasterOpLienceMapper;

	@Override
	public List<TabMasterOpLience> selectByExample(TabMasterOpLienceExample example) {
		return tabMasterOpLienceMapper.selectByExample(example);
	}

	@Override
	public List<Integer> selectmIDByExample(TabMasterOpLienceExample example) {
		List<Integer> mIDs = new ArrayList<Integer>();
		List<TabMasterOpLience> opLiences = selectByExample(example);
		if(null == opLiences){
			return mIDs;
		} else {
			for(TabMasterOpLience op:opLiences){
				mIDs.add(op.getmID());
			}
			return mIDs;
		}
	}
}
