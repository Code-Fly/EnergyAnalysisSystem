/**
 * 
 */
package com.flycode.common;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * @author VM
 *
 */
public abstract class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
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
