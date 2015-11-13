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
	 * @param errFlag 0:全部，1:正常，2:异常。
	 * @param errProcessFlag errProcessFlag 0：告警未处理，1：告警已经处理
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/error/query", produces = "application/x-javascript;charset=UTF-8")
	public String queryErrors(@RequestParam(value = "callback", required = true) String callBack,
			@RequestParam(value = "beginDate", required = true) String beginDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "errFlag", required = false, defaultValue="0") String errFlag,
			@RequestParam(value = "errProcessFlag", required = false) Integer errProcessFlag) {
		TabErrorExample example = new TabErrorExample();
		example.or().andReadTimeBetween(beginDate, endDate);
		if("1".equals(errFlag)){
			example.or().andErrClassEqualTo("200");
		} else if ("2".equals(errFlag)){
			example.or().andErrClassNotEqualTo("200");
		} 
		if (null != errProcessFlag){
			example.or().andErrProcessFlagEqualTo(errProcessFlag);
		}
		String readRecs = JsonUtil.jsonArray2Sting(callBack,tabErrorService.selectByExample(example));
		return readRecs;
	}

}
