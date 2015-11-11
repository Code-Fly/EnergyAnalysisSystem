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
		 * 获取 趋势分析
		 * @param callBack
		 * @param yearmonth
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/readrec/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryMeters(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "yearmonth", required = true) String yearmonth) {
			/**
			 * 传入动态的表名如tab_readRec1511
			 */
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabReadRecService.selectByMonth("tab_readRec"+yearmonth));
			return readRecs;
		}

}
