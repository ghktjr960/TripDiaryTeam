package com.tripdiary.JCcontroller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.HSvo.ReportBoardVo;
import com.tripdiary.HSvo.ReportReplyVo;
import com.tripdiary.JCservice.ReadService;

@Controller
public class ReportController {
	
	@Inject
	ReadService service;
	
	@RequestMapping(value = "/report/board", method = RequestMethod.GET)
	public String reportBoardGet(ReportBoardVo reportBoardVo, Model model) throws Exception{
		System.out.println("신고 게시글 확인"+reportBoardVo.toString());
		model.addAttribute("reportBoardVo", reportBoardVo);
		return "/report/reportBoard";
	}

	@RequestMapping(value = "/report/board", method = RequestMethod.POST)
	public String reportBoardPost(ReportBoardVo reportBoardVo) throws Exception{
		
		System.out.println("ReportBoardVo : " + reportBoardVo.toString());
		
		service.boardBoartInsert(reportBoardVo);
		service.boardBoartUpdate(reportBoardVo);
		return "redirect:/readView?boardNum="+reportBoardVo.getBoardNum()+"&memberNum="+reportBoardVo.getMemberNumReceive();
	}
	
	@RequestMapping(value = "/report/reply", method = RequestMethod.GET)
	public String reportReplyGet(ReportReplyVo reportReplyVo, Model model) throws Exception{
		model.addAttribute("reportReplyVo", reportReplyVo);
		return "/report/reportReply";
	}
	
	@RequestMapping(value = "/report/reply", method = RequestMethod.POST)
	public String reportReplyPost(ReportReplyVo reportReplyVo) throws Exception{
		
		System.out.println("ReportReplyVo : " + reportReplyVo.toString());
		
		service.replyReportInsert(reportReplyVo);
		service.replyReportUpdate(reportReplyVo);
		return "redirect:/readView?boardNum="+reportReplyVo.getBoardNum()+"&memberNum="+reportReplyVo.getMemberNumReceive();
	}
	
}
