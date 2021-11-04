package com.tripdiary.TMcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DarkmodeController {
	@RequestMapping(value = "/darkmode", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("darkmode") == null) {
			session.setAttribute("darkmode", 1);
		}else if(session.getAttribute("darkmode") != null) {
			session.removeAttribute("darkmode");
		}
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}
