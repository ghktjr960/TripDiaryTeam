package com.tripdiary.HScontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.HSservice.AdminService;
import com.tripdiary.HSvo.DelMemberVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.ReportBoardVo;
import com.tripdiary.HSvo.ReportCntVo;
import com.tripdiary.HSvo.ReportReplyVo;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private AdminService adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpSession session) throws Exception  {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		if(memberVo != null && memberVo.isAdmin() == true) {
			return "redirect:/admin/member";
		} else {
			return "redirect:/";
		}
		
	}
	@RequestMapping(value = "/admin/member", method = RequestMethod.GET)
	public String memberManageGet(Model model, ReportCntVo reportCntVo, HttpSession session) throws Exception  {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		if(memberVo != null && memberVo.isAdmin() == true) {
			
			List<ReportCntVo> reportCnt = adminService.reportCntVo(reportCntVo);
			model.addAttribute("reportCnt", reportCnt);
			
			return "/admin/adminMember";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/admin/member", method = RequestMethod.POST)
	public String memberManagePost(Model model, String memberNumList, HttpSession session) throws Exception  {
		MemberVo loginMember = (MemberVo) session.getAttribute("memberLoginTest");
		if(loginMember != null && loginMember.isAdmin() == true) {
			
			if(memberNumList != null) {
				// check 박스 여러러개 받을 경우
				String[] memberNum = memberNumList.split(",");
				for(int i = 0; i < memberNum.length; i++) {
					MemberVo memberVo = adminService.getMemberVo(Integer.parseInt(memberNum[i]));
					int result = adminService.memberManageDelte(Integer.parseInt(memberNum[i]));
					if(result > 0) {
						System.out.println(memberNum[i] + "번 회원 삭제성공");
						
						DelMemberVo delMemberVo = adminService.delMemberSelectOne(Integer.parseInt(memberNum[i]));
						if(delMemberVo != null) {
							adminService.delmemberUpdate(Integer.parseInt(memberNum[i]));
						} else {
							adminService.delMemberInsert(memberVo);
						}
					} else {
						System.out.println(memberNum[i] + "번 회원 삭제실패");
					}
				}
			}
			return "redirect:/admin/member";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/admin/delmember", method = RequestMethod.GET)
	public String delMemberGet(Model model, DelMemberVo delMemberVo, HttpSession session) {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		if(memberVo != null && memberVo.isAdmin() == true) {
			
			List<DelMemberVo> delMember = adminService.delMemberSelectList();
			if(delMember.isEmpty()) {
				model.addAttribute("delMember", null);
			} else {
				model.addAttribute("delMember", delMember);
			}
			return "/admin/delMember";
		} else {
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/admin/delmember", method = RequestMethod.POST)
	public String delMemberPost(String memberNumList) {
		
		if(memberNumList != null) {
			// check 박스 여러러개 받을 경우
			String[] memberNum = memberNumList.split(",");
			for(int i = 0; i < memberNum.length; i++) {
				System.out.println("memberNum : " + memberNum[i]);
				
				DelMemberVo delMember = adminService.delMemberSelectOne(Integer.parseInt(memberNum[i]));
				System.out.println("delMember : " + delMember.toString());
				System.out.println("delMember.gerTimeove : " + delMember.getTimeover());
				if(delMember.getTimeover() == 0) {
					adminService.delmemberUpdate(delMember.getMemberNum());
					adminService.memberManageDelte(delMember.getMemberNum());
				} else {
					
				}
			}
		}
		return "redirect:/admin/delmember";
	}
	
	@RequestMapping(value="/admin/board", method = RequestMethod.GET)
	public String reportBoardGet(Model model, HttpSession session) {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
			if(memberVo != null && memberVo.isAdmin() == true) {
				
			List<ReportBoardVo> reportBoardList = adminService.reportBoardList();
			
			if(reportBoardList.isEmpty()) {
				model.addAttribute("reportBoardList", null);
			} else {
				model.addAttribute("reportBoardList", reportBoardList);
			}
			
			return "/admin/reportBoard";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/admin/board", method = RequestMethod.POST)
	public String reportBoardPost(String reportBoardNumList, HttpServletRequest req) {
		System.out.println("reply req : " + req.getParameter("prom"));
		String problem = req.getParameter("prom");

		if(problem.equals("Y")) {
			if(reportBoardNumList != null) {
				// check 박스 여러러개 받을 경우
				String[] reportBoardNum = reportBoardNumList.split(",");
				for(int i = 0; i < reportBoardNum.length; i++) {
					System.out.println("reportBoardNum : " + reportBoardNum[i]);
					ReportBoardVo reportBoardVo = adminService.reportBoardOne(Integer.parseInt(reportBoardNum[i]));
					adminService.reportBoardDelete(reportBoardVo);
					adminService.mainBoardDelete(reportBoardVo);
					adminService.reportMemberInsert(reportBoardVo);
					adminService.reportCntSend(reportBoardVo.getMemberNumSend());
					adminService.reportCntReceive(reportBoardVo.getMemberNumReceive());
				}
			}
		} else if(problem.equals("N")) {
			if(reportBoardNumList != null) {
				// check 박스 여러러개 받을 경우
				String[] reportBoardNum = reportBoardNumList.split(",");
				for(int i = 0; i < reportBoardNum.length; i++) {
					System.out.println("reportBoardNum : " + reportBoardNum[i]);
					ReportBoardVo reportBoardVo = adminService.reportBoardOne(Integer.parseInt(reportBoardNum[i]));
					adminService.reportBoardDelete(reportBoardVo);
				}
			}
		}
		return "redirect:/admin/board";
	}
	
	@RequestMapping(value="/admin/reply", method = RequestMethod.GET)
	public String reportReplyGet(Model model, HttpSession session) {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
			if(memberVo != null && memberVo.isAdmin() == true) {
			List<ReportReplyVo> reportReplyList = adminService.reportReplyList();
			
			if(reportReplyList.isEmpty()) {
				model.addAttribute("reportReplyList", null);
			} else {
				model.addAttribute("reportReplyList", reportReplyList);
			}
			
			return "/admin/reportReply";
		} else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="/admin/reply", method = RequestMethod.POST)
	public String reportReplyPost(String reportReplyNumList, HttpServletRequest req) {
		
		System.out.println("reply req : " + req.getParameter("prom"));
		String problem = req.getParameter("prom");
		
		if(problem.equals("Y")) {
			if(reportReplyNumList != null) {
				// check 박스 여러러개 받을 경우
				String[] reportReplyNum = reportReplyNumList.split(",");
				for(int i = 0; i < reportReplyNum.length; i++) {
					System.out.println("reportReplyNum : " + reportReplyNum[i]);
					ReportReplyVo reportReplyVo = adminService.reportReplyOne(Integer.parseInt(reportReplyNum[i]));
					adminService.reportReplyDelete(reportReplyVo);
					adminService.mainReplyDelete(reportReplyVo);
					adminService.reportMemberInsertReply(reportReplyVo);
					adminService.reportCntSend(reportReplyVo.getMemberNumSend());
					adminService.reportCntReceive(reportReplyVo.getMemberNumReceive());
				}
			}
		} else if(problem.equals("N")) {
			if(reportReplyNumList != null) {
				// check 박스 여러러개 받을 경우
				String[] reportReplyNum = reportReplyNumList.split(",");
				for(int i = 0; i < reportReplyNum.length; i++) {
					System.out.println("reportReplyNum : " + reportReplyNum[i]);
					ReportReplyVo reportReplyVo = adminService.reportReplyOne(Integer.parseInt(reportReplyNum[i]));
					adminService.reportReplyDelete(reportReplyVo);
				}
			}
			
		}
		
		return "redirect:/admin/reply";
	}
	
	
}
