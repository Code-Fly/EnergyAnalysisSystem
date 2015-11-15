/**
 * 
 */
package com.flycode.error.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.error.entity.TabErrorExample;
import com.flycode.error.service.iface.TabErrorService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *	供电（故障）查询
 */
@Controller
@RequestMapping(value = "/api")
public class TabErrorController extends BaseController {
	@Autowired
	private TabErrorService tabErrorService;

	/**
	 * 
	 * @param callBack
	 * @param beginDate
	 * @param endDate
	 * @param errClass 200:正常，201:低电压，202:电压超低，210：掉电电压正常，211：掉电电压低，212：掉电，电压超低。
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/error/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryErrors(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "beginDate", required = true) String beginDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "errClass", required = false, defaultValue="200") String errClass) {
		TabErrorExample example = new TabErrorExample();
		// 200，查询所有告警
		if("200".equals(errClass)){
			example.or().andReadTimeBetween(beginDate, endDate).andErrClassNotEqualTo("200");
		} else {
			example.or().andReadTimeBetween(beginDate, endDate).andErrClassEqualTo(errClass);
		}
		String readRecs = JsonUtil.jsonArray2Sting(callBack,tabErrorService.selectByExample(example));
		return readRecs;
	}
	
	

	/**
	 * 
	 * @param callBack
	 * @param beginDate
	 * @param endDate
	 * @param mID 表据ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/meterlog/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryMeterLog(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "beginDate", required = true) String beginDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "mID", required = false, defaultValue = "0") Integer mID) {
		TabErrorExample example = new TabErrorExample();
		// mID 为空时查询全部记录
		if (mID.equals("0")) {
			example.or().andReadTimeBetween(beginDate, endDate);
		} else {
			example.or().andReadTimeBetween(beginDate, endDate).andMIDEqualTo(mID);
		}
		String readRecs = JsonUtil.jsonArray2Sting(callBack,tabErrorService.selectByExample(example));
		return readRecs;
	}
	

}
