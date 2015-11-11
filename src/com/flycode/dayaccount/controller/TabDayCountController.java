/**
 * 
 */
package com.flycode.dayaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.dayaccount.entity.TabDayAccountExample;
import com.flycode.dayaccount.service.iface.TabDayAccountService;
import com.flycode.readrec.entity.TabReadRecExample;
import com.flycode.readrec.service.iface.TabReadRecService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabDayCountController extends BaseController {
	
		@Autowired
		private TabDayAccountService tabDayAccountService;

		/**
		 * 日用量分析
		 * @param callBack
		 * @param yearmonth
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/dayaccount/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryMeters(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "beginDate", required = true) String beginDate,
				@RequestParam(value = "endDate", required = true) String endDate) {
			
			/* 
			 *  get tableName 2015-11-10 
				str= [2015,11,10]
			 */		
			String[] str = beginDate.split("-");
			String year = str[0];
			/**
			 * 传入动态的表名如tab_dayAccount2015
			 */
			logger.info("tableName="+"tab_dayAccount"+year);
			TabDayAccountExample example = new TabDayAccountExample();
			example.or().andCollectDayBetween("'"+beginDate+"'", "'"+endDate+"'");
			example.setTableName("tab_dayAccount"+year);
			example.setOrderByClause("collectDay");
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabDayAccountService.selectByExample(example));
			return readRecs;
		}

}
