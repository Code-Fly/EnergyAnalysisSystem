/**
 * 
 */
package com.flycode.oplience.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.meter.entity.TabMeter;
import com.flycode.meter.service.iface.TabMeterService;
import com.flycode.oplience.entity.TabMasterOpLience;
import com.flycode.oplience.entity.TabMasterOpLienceExample;
import com.flycode.oplience.service.iface.TabMasterOpLienceService;

/**
 * @author VM
 * 表具权限Controller
 */
@Controller
@RequestMapping(value = "/api/lience")
public class TabMasterOpLienceController extends BaseController {
	
		@Autowired
		private TabMasterOpLienceService tabTabMasterOpLienceService;
		
		@Autowired
		private TabMeterService tabMeterService;
		
		/**
		 * 删除用户表具权限
		 * @param opID 用户id
		 * @param mID 表具id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/delete",method=RequestMethod.DELETE)
		public String deleteOpLience(@RequestParam(value = "opID", required = true) Integer opID,
				@RequestParam(value = "mID", required = true) Integer mID) {
			TabMasterOpLienceExample tabTabMasterOpLienceExample = new TabMasterOpLienceExample();
			tabTabMasterOpLienceExample.or().andOpIDEqualTo(opID).andMIDEqualTo(mID);
			tabTabMasterOpLienceService.deleteByExample(tabTabMasterOpLienceExample);
			return SUCESS;
		}
		
		/**
		 * 增加用户表具权限 
		 * @param opID 用户id
		 * @param mID 表具id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/add",method=RequestMethod.PUT)
		public String addOpLience(@RequestParam(value = "opID", required = true) Integer opID,
				@RequestParam(value = "mID", required = true) Integer mID) {
			TabMeter tabMeter = tabMeterService.selectByPrimaryKey(mID);
			if(null == tabMeter) {
				return FAIL;
			} else {
				TabMasterOpLience tabTabMasterOpLience = new TabMasterOpLience();
				tabTabMasterOpLience.setInfoID(tabMeter.getInfoID());
				tabTabMasterOpLience.setmID(mID);
				tabTabMasterOpLience.setNm(tabMeter.getNm());
				tabTabMasterOpLience.setOpID(opID);
				tabTabMasterOpLienceService.insertSelective(tabTabMasterOpLience);
				return SUCESS;
			}
		}
}
