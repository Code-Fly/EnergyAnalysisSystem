/**
 * 
 */
package com.flycode.meter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.meter.service.iface.TabMeterService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabMeterController extends BaseController{
	@Autowired
	private  TabMeterService tabMeterService;
	
	@ResponseBody
	@RequestMapping(value = "/meter/query")
	public String queryMeters(){
		String meters = JsonUtil.jsonArray2Sting(tabMeterService.selectByExample(null));
		return meters;
	}
	
}
