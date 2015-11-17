/**
 * 
 */
package com.flycode.meter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.meter.entity.TabMeterExample;
import com.flycode.meter.service.iface.TabMeterService;
import com.flycode.oplience.entity.TabMasterOpLienceExample;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabMeterController extends BaseController {
	
	@Autowired
	private TabMeterService tabMeterService;

	@ResponseBody
	@RequestMapping(value = "/meter/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryMeters(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "opID", required = true) Integer opID) {
		TabMeterExample example = new TabMeterExample();
		TabMasterOpLienceExample opLienceExample= new TabMasterOpLienceExample();
		opLienceExample.or().andOpIDEqualTo(opID);
		example.or().andMIDIn(tabMasterOpLienceService.selectmIDByExample(opLienceExample));
		String meters = JsonUtil.jsonArray2Sting(callBack,tabMeterService.selectByExample(example));
		return meters;
	}
	
	@ResponseBody
	@RequestMapping(value = "/lience/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryOpMeters(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "opID", required = true) Integer opID) {
		String meters = JsonUtil.jsonArray2Sting(callBack,tabMeterService.selectByOpID(opID));
		return meters;
	}

}
