package com.tripdiary.HScontroller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageErrorController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 에러페이지
	@RequestMapping(value = "/pageError", method = RequestMethod.GET)
	public String pageError(HttpServletResponse response, Model model) {
		return "/pageError/pageError";
	}

}
