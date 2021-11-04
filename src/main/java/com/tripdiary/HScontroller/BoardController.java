package com.tripdiary.HScontroller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tripdiary.HSservice.MainService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private MainService mainService;
	
	// 게시글 상세보기할 때 사용할 코드 : 게시글 번호 날아오는거 확인완료
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(@RequestParam(value = "boardNum", required = false) String boardNum,
						@RequestParam(value = "memberNum", required = false) String memberNum ) {
		System.out.println("boardNum : " + boardNum);
		System.out.println("memberNum : " + memberNum);
		return "redirect:/";
	}
	
}
