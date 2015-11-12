/**
 * 
 */
package com.flycode.monthaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.monthaccount.entity.TabMonthAccountExample;
import com.flycode.monthaccount.service.iface.TabMonthAccountService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabMonthAccountController extends BaseController {
	
		@Autowired
		private TabMonthAccountService tabMonthAccountService;

		/**
		 * 日用量分析
		 * @param callBack
		 * @param beginDate 查询开始时间
		 * @param endDate 结束时间
		 * @param mID 用户id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/monthaccount/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryMonthaccounts(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "year", required = true) int year,
				@RequestParam(value = "mID", required = true) int mID) {
			logger.info("tableName="+"tab_MonthAccount"+year);
			TabMonthAccountExample example = new TabMonthAccountExample();
			example.or().andMIDEqualTo(mID).andCollectMonLike(year+"-%");
			example.setOrderByClause("collectMon");
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabMonthAccountService.selectByExample(example));
			return readRecs;
		}

}
