/**
 * 
 */
package com.flycode.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.log.entity.TabLogExample;
import com.flycode.log.service.iface.TabLogService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabLogController extends BaseController {
	
		@Autowired
		private TabLogService tabLogService;

		
		/**
		 *  获取 趋势分析
		 * @param callBack
		 * @param beginDate 查询开始时间
		 * @param endDate 结束时间
		 * @param mID 用户id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/log/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryMeters(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "beginDate", required = true) String beginDate,
				@RequestParam(value = "endDate", required = true) String endDate) {
			TabLogExample example = new TabLogExample();
			example.or().andLogTimeBetween(beginDate, endDate);
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabLogService.selectByExample(example));
			return readRecs;
		}

}
