/**
 * 
 */
package com.flycode.masterop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flycode.common.BaseController;
import com.flycode.masterop.entity.TabMasterOp;
import com.flycode.masterop.entity.TabMasterOpExample;
import com.flycode.masterop.service.iface.TabMasterOpService;
import com.flycode.util.JsonUtil;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api")
public class TabMasterOpController extends BaseController {
	
		@Autowired
		private TabMasterOpService tabMasterOpService;

		/**
		 * 登陆用户名和密码校验，错误返回error，正确返回对应的opID
		 * @param beginDate
		 * @param endDate
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/login/query")
		public String loginOp(@RequestParam(value = "opNm", required = true) String opNm,
				@RequestParam(value = "opPwd", required = true) String opPwd) {
			TabMasterOpExample tabMasterOpExample = new TabMasterOpExample();
			tabMasterOpExample.or().andOpNmEqualTo(opNm);
			List<TabMasterOp> tabMasterOps = tabMasterOpService.selectByExample(tabMasterOpExample);
			if (null == tabMasterOps || 0 == tabMasterOps.size()) {
				return "";
			} else {
				if (opPwd.equals(tabMasterOps.get(0).getOpPwd())) {
					return tabMasterOps.get(0).getOpID().toString();
				} else {
					return "";
				}
			}
		}
		
		/**
		 * 查询所有用户
		 * @param callBack
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/op/query", produces = "application/x-javascript;charset=UTF-8")
		public String queryOp(@RequestParam(value = "callback", required = true) String callBack) {
			return JsonUtil.jsonArray2Sting(callBack,tabMasterOpService.selectByExample(null));
		}
}
