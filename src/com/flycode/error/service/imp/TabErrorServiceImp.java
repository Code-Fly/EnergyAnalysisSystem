/**
 * 
 */
package com.flycode.error.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flycode.error.entity.TabError;
import com.flycode.error.entity.TabErrorExample;
import com.flycode.error.mapper.TabErrorMapper;
import com.flycode.error.service.iface.TabErrorService;

/**
 * @author VM
 *
 */
@Service("tabErrorService")
public class TabErrorServiceImp implements TabErrorService {
	@Autowired
	private TabErrorMapper tabErrorMapper;

	@Override
	public List<TabError> selectByExample(TabErrorExample example) {
		return tabErrorMapper.selectByExample(example);
	}
}
