/**
 * 
 */
package com.flycode.readerr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.meter.entity.TabMeterExample;
import com.flycode.oplience.entity.TabMasterOpLienceExample;
import com.flycode.readerr.entity.TabReadErrExample;
import com.flycode.readerr.service.iface.TabReadErrService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 * 停气和数据异常查询
 */
@Controller
@RequestMapping(value = "/api")
public class TabReadErrController extends BaseController {
	
		@Autowired
		private TabReadErrService tabReadErrService;

	/**
	 * 
	 * @param callBack
	 * @param beginDate
	 * @param endDate
	 * @param errType errType = 4  停气查询
	 *  errType = 3  数据异常查询
	 * @return
	 */
		@ResponseBody
		@RequestMapping(value = "/readerr/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryReadErrs(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "beginDate", required = true) String beginDate,
				@RequestParam(value = "endDate", required = true) String endDate,
				@RequestParam(value = "errType", required = true) int errType,
				@RequestParam(value = "opID", required = true) int opID) {
			TabMasterOpLienceExample opLienceExample= new TabMasterOpLienceExample();
			opLienceExample.or().andOpIDEqualTo(opID);
			TabReadErrExample example = new TabReadErrExample();
			example.or().andReadTimeBetween(beginDate, endDate).andErrTypeEqualTo(errType).andMIDIn(tabMasterOpLienceService.selectmIDByExample(opLienceExample));
			String readErrs = JsonUtil.jsonArray2Sting(callBack,tabReadErrService.selectByExample(example));
			return readErrs;
		}

}
