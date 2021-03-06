/**
 * 
 */
package com.flycode.yearaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.area.entity.TabArea;
import com.flycode.area.service.iface.TabAreaService;
import com.flycode.common.BaseController;
import com.flycode.yearaccount.entity.TabYearAccountExample;
import com.flycode.yearaccount.service.iface.TabYearAccountService;
import com.flycode.oplience.entity.TabMasterOpLienceExample;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 * 年用量
 */
@Controller
@RequestMapping(value = "/api")
public class TabYearAccountController extends BaseController {
	
		@Autowired
		private TabYearAccountService tabYearAccountService;
		
		@Autowired
		private TabAreaService tabAreaService;
		

		/**
		 * 年用量
		 * @param callBack
		 * @param year 年份
		 * @param infoID 域id
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/yearaccount/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryYearAccounts(@RequestParam(value = "callback", required = true) String callBack,
				@RequestParam(value = "year", required = true) String year,
				@RequestParam(value = "infoID", required = true) String infoID,
				@RequestParam(value = "opID", required = true) int opID) {
			
			TabMasterOpLienceExample opLienceExample= new TabMasterOpLienceExample();
			opLienceExample.or().andOpIDEqualTo(opID);
			
			TabArea area = tabAreaService.selectByPrimaryKey(infoID);
			TabYearAccountExample yearAccountexample = new TabYearAccountExample();
			// 域存在
			if(null == area){
				return null;
			}
			// 域的lever=l 则查询全部
			else if (1 == area.getLevel()){	
				yearAccountexample.or().andCollectYearEqualTo(year).andMIDIn(tabMasterOpLienceService.selectmIDByExample(opLienceExample));
			} else {
				yearAccountexample.or().andInfoIDEqualTo(infoID).andCollectYearEqualTo(year).andMIDIn(tabMasterOpLienceService.selectmIDByExample(opLienceExample));
			}
			String readRecs = JsonUtil.jsonArray2Sting(callBack,tabYearAccountService.selectByExample(yearAccountexample));
			return readRecs;
		}

}
