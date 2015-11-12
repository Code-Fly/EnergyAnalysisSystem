/**
 * 
 */
package com.flycode.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flycode.common.BaseController;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/web")
public class WebController extends BaseController {

	@RequestMapping(value = "/meter")
	public String meter(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "/meter";
	}

	@RequestMapping(value = "/readrec")
	public String readrec(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "/readrec";
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "/login";
	}

	@RequestMapping(value = {"/index" })
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "/meter";
	}
}
