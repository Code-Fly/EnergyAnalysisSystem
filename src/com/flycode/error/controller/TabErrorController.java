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
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabErrorController extends BaseController {
	@Autowired
	private TabErrorService tabErrorService;

	@ResponseBody
	@RequestMapping(value = "/error/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryErrors(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "beginDate", required = true) String beginDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "errClass", required = false) String errClass) {
		TabErrorExample example = new TabErrorExample();
		// 只查询正在告警的（ErrProcess=1）， 已经查看的告警(ErrProcess=0)不显示
		if(null != errClass){
			example.or().andReadTimeBetween(beginDate, endDate).andErrClassEqualTo(errClass).andErrProcessFlagEqualTo(1);
		} else {
			example.or().andReadTimeBetween(beginDate, endDate).andErrProcessFlagEqualTo(1);
		}
		String readRecs = JsonUtil.jsonArray2Sting(callBack,tabErrorService.selectByExample(example));
		return readRecs;
	}

}
