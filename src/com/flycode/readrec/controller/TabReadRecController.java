/**
 * 
 */
package com.flycode.readrec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.readrec.entity.TabReadRecExample;
import com.flycode.readrec.service.iface.TabReadRecService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabReadRecController extends BaseController {
	
		@Autowired
		private TabReadRecService tabReadRecService;

		
		/**
		 *  获取 趋势分析
		 * @param callBack
		 * @param beginDate 查询开始时间
		 * @param endDate 结束时间
		 * @param mID 用户id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/readrec/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryMeters(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "beginDate", required = true) String beginDate,
				@RequestParam(value = "endDate", required = true) String endDate,
				@RequestParam(value = "mID", required = true) int mID) {
			
			/* 
			 *  get tableName 2015-11-10 13:59:02
				str= [2015,11,10 13:59:02]
			 */		
			String[] str = beginDate.split("-");
			String year = str[0].substring(2);
			String month= str[1];
			/**
			 * 传入动态的表名如tab_readRec1511
			 */
			logger.info("tableName="+"tab_ReadRec"+year+month);
			TabReadRecExample example = new TabReadRecExample();
			example.or().andComTimeBetween("'"+beginDate+"'", "'"+endDate+"'").andMIDEqualTo(mID);
			example.setTableName("tab_ReadRec"+year+month);
			example.setOrderByClause("comTime");
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabReadRecService.selectByExample(example));
			return readRecs;
		}

}
