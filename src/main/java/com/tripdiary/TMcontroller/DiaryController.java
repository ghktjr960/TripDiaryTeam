package com.tripdiary.TMcontroller;


import javax.servlet.http.HttpSession;

import org.project.regist.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.HSservice.MainService;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.TMservice.DiaryService;
import com.tripdiary.TMutil.PageCalc;
import com.tripdiary.TMvo.GetEmblemCmd;
import com.tripdiary.TMvo.PageCmd;

@Controller
public class DiaryController {
	
	private DiaryService diaryService;
	private PageCalc pageCalc;
	private PageCmd pageVO;
	private MainService mainService;
	
	@Autowired
	public DiaryController(DiaryService diaryService, PageCalc pageCalc, PageCmd pageVO, MainService mainService) {
		this.diaryService = diaryService;
		this.pageCalc = pageCalc;
	    this.pageVO = pageVO;
	    this.mainService = mainService;
	}
	
	@RequestMapping(value = "/diary", method = RequestMethod.GET)
	public String diary(Model model, int memberNum, String pageNum, HttpSession session) throws Exception {
    	if(session.getAttribute("authInfo") != null) {
    		MemberVo memberVo = (MemberVo) session.getAttribute("authInfo");
    		ProfileImgVo profileImgVo = mainService.profileImg(memberVo.getMemberNum());
    		session.setAttribute("profileImg", profileImgVo);
    	}
		int currentPage = 1;
		int articleCount = diaryService.getArticleCount(memberNum);
		if (pageNum != null) {
	         currentPage = Integer.parseInt(pageNum);
	    }
	    pageVO = pageCalc.pageCalc(currentPage, articleCount);
	    pageVO.setMemberNum(memberNum);
		 	
	    
		model.addAttribute("diaryBoardList", diaryService.getBoardList(pageVO));
		model.addAttribute("page",pageVO);
		model.addAttribute("mapCmd", diaryService.getMap(memberNum));
		model.addAttribute("calendar", diaryService.getDate(memberNum));
		model.addAttribute("profile", diaryService.getProfile(memberNum));
		model.addAttribute("haveEmblem", diaryService.haveEmblem(memberNum));
		model.addAttribute("emblem", diaryService.selectEmblem());
		model.addAttribute("actCnt", diaryService.getActCnt(memberNum));
		return "/diary";
	}
	
	
	@RequestMapping(value = "/getEmblem", method = RequestMethod.POST)
	public String getEmblem(GetEmblemCmd getEmblem, Model model) {
		diaryService.getEmblem(getEmblem);
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/forward";
	}
	
	@RequestMapping(value = "/profileUpdate", method = RequestMethod.POST)
	public String profileUpdate(MultipartHttpServletRequest mpRequest, Model model, int memberNum, String message) throws Exception {
    	if(message.equals("")) {
    		model.addAttribute("msg", "상태메세지를 입력해주세요!");
    		model.addAttribute("url", "/diary?memberNum=");
    		return "/return/diaryAlert";
    	}
		diaryService.profileUpdate(mpRequest, memberNum, message);
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/forward";
	}
	
	
}
