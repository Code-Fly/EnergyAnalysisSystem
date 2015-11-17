/**
 * 
 */
package com.flycode.common;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.flycode.oplience.service.iface.TabMasterOpLienceService;



/**
 * @author VM
 *
 */
public abstract class BaseController {
	
	@Autowired
	protected TabMasterOpLienceService tabMasterOpLienceService;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected String SUCESS = "sucess";
	
	protected String FAIL = "fail";
	
	/**
	 * 运行时异常的处理方法
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleUnexpectedServerError(RuntimeException ex) {
		logger.error("内部错误", ex);
		return "System Error.";
	}
}
